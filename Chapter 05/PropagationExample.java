public class PropagationExample {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void methodA() throws Exception {
        methodB(); // Propagates exception
    }

    public static void methodB() throws Exception {
        throw new Exception("Something went wrong in methodB.");
    }
}
