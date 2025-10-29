import java.util.*;

class WordCountWorker implements Runnable {
    private final List<String> lines;
    private final Map<String, Integer> wordCounts = new HashMap<>();

    public WordCountWorker(List<String> lines) {
        this.lines = lines;
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }

    @Override
    public void run() {
        for (String line : lines) {
            String[] words = line.toLowerCase()
                                 .replaceAll("[^a-z0-9\\s]", "")
                                 .split("\\s+");

            for (String word : words) {
                if (!word.isBlank()) {
                    wordCounts.merge(word, 1, Integer::sum);
                }
            }
        }
    }
}