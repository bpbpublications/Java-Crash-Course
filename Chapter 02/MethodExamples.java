public static void main(String[] args) {
    welcome();

    int a = 8;
    int b = 24;
    System.out.println(add(a, b));

    // Generate an error
    int x = 8;
    double y = 24;
    //System.out.println(add(x, y));

}

public static void welcome() {
    System.out.println("Welcome to my world!");
    }

public static int add(int nbrA, int nbrB) {
        return nbrA + nbrB;
    }
    