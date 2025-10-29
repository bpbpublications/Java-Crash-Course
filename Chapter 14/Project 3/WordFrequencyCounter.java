import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    private static final int LINES_PER_THREAD = 500;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter path to the text file: ");
        String filePath = scanner.nextLine();

        List<String> allLines = new ArrayList<>();

        // Read the file into memory
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                allLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Split lines into chunks
        List<List<String>> chunks = new ArrayList<>();
        for (int i = 0; i < allLines.size(); i += LINES_PER_THREAD) {
            int end = Math.min(i + LINES_PER_THREAD, allLines.size());
            chunks.add(allLines.subList(i, end));
        }

        // Process chunks with threads
        List<WordCountWorker> workers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (List<String> chunk : chunks) {
            WordCountWorker worker = new WordCountWorker(chunk);
            Thread thread = new Thread(worker);
            workers.add(worker);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

        // Merge results
        Map<String, Integer> finalWordCounts = new HashMap<>();
        for (WordCountWorker worker : workers) {
            Map<String, Integer> localMap = worker.getWordCounts();
            for (Map.Entry<String, Integer> entry : localMap.entrySet()) {
                finalWordCounts.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }

        System.out.println("Total unique words: " + finalWordCounts.size());
        System.out.print("How many top frequent words would you like to see? ");
        int topN = scanner.nextInt();

        // Sort and display
        finalWordCounts.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(topN)
                .forEach(e -> System.out.printf("%-20s %d%n", e.getKey(), e.getValue()));
    }
}


