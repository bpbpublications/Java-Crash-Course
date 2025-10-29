public class RuntimeError {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        // Trying to access an invalid index
        System.out.println(numbers[5]); // Runtime error: ArrayIndexOutOfBoundsException
    }
}