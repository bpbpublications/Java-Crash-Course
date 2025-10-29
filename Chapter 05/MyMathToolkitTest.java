public class MyMathToolkitTest {
    public static void main(String[] args) {
        MyMathToolkit mathToolkit = new MyMathToolkit();
        try {
            mathToolkit.divide(19, 0);
            System.out.println("Test failed: No exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed: Caught IllegalArgumentException.");
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}
