import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CityPopulationExplorer {

    static class City {
        String name, state, country;
        int population;
        double area; // in square miles

        City(String name, String state, String country, int population, double area) {
            this.name = name;
            this.state = state;
            this.country = country;
            this.population = population;
            this.area = area;
        }

        double getDensity() {
            return population / area;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s - Population: %,d, Area: %.1f sq mi, Density: %.1f/sq mi",
                    name, state, country, population, area, getDensity());
        }
    }

    public static void main(String[] args) {
        List<City> cities = loadCities("city_population_data.csv");
        if (cities.isEmpty()) {
            System.out.println("No cities loaded. Exiting.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- City Population Explorer ---");
            System.out.println("1. Filter cities by country");
            System.out.println("2. Filter cities by state");
            System.out.println("3. Filter cities by minimum population");
            System.out.println("4. Show top N cities by population density");
            System.out.println("5. Show bottom N cities by population density");
            System.out.println("6. Show average population per country");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter country: ");
                    String country = scanner.nextLine();
                    cities.stream()
                          .filter(c -> c.country.equalsIgnoreCase(country))
                          .forEach(System.out::println);
                }
                case "2" -> {
                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();
                    cities.stream()
                          .filter(c -> c.state.equalsIgnoreCase(state))
                          .forEach(System.out::println);
                }
                case "3" -> {
                    System.out.print("Minimum population: ");
                    int minPop = Integer.parseInt(scanner.nextLine());
                    cities.stream()
                          .filter(c -> c.population >= minPop)
                          .sorted(Comparator.comparingInt(c -> -c.population))
                          .forEach(System.out::println);
                }
                case "4" -> {
                    System.out.print("Top how many cities? ");
                    int n = Integer.parseInt(scanner.nextLine());
                    cities.stream()
                          .sorted(Comparator.comparingDouble(City::getDensity).reversed())
                          .limit(n)
                          .forEach(System.out::println);
                }
                case "5" -> {
                    System.out.print("Bottom how many cities? ");
                    int n = Integer.parseInt(scanner.nextLine());
                    cities.stream()
                          .sorted(Comparator.comparingDouble(City::getDensity))
                          .limit(n)
                          .forEach(System.out::println);
                }
                case "6" -> {
                    cities.stream()
                        .collect(Collectors.groupingBy(
                            c -> c.country,
                            Collectors.averagingInt(c -> c.population)))
                        .forEach((country, avgPop) ->
                            System.out.printf("%s: Average Population = %,d%n", country, Math.round(avgPop)));
                }
                case "7" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static List<City> loadCities(String fileName) {
        try (Stream<String> lines = Files.lines(Paths.get(fileName)).skip(1)) {
            return lines.map(line -> {
                        String[] parts = line.split(",");
                        return new City(
                                parts[0].trim(), // name
                                parts[1].trim(), // state
                                parts[2].trim(), // country
                                Integer.parseInt(parts[3].trim()), // population
                                Double.parseDouble(parts[4].trim()) // area
                        );
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
