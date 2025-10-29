public class CustomUncheckedExceptionImplementation {
    public static void main(String[] args) {
        try {
            loadConfiguration(null);
        } catch (ConfigurationException e) {
            System.out.println("Configuration error: " + e.getMessage());
        }
    }

    public static void loadConfiguration(String configPath) {
        if (configPath == null) {
            throw new ConfigurationException("Configuration file path cannot be null.");
        }
        System.out.println("Loading configuration from: " + configPath);
    }
}
