public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String myString = null;
        try {
            // Here we attempt to call a method with a null reference
            int length = myString.length();
        } catch (NullPointerException e) {
            System.out.println("We caught a NullPointerException:");
            e.printStackTrace();
        }
    }
}

