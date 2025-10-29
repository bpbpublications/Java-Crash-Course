public class CorgiLove {
    public static void main(String[] args) {
        // Creating an object of the Dog class
        Dog myDog = new Dog("Basil", "Corgi", 3, 12.5);

        // Accessing attributes with getters
        System.out.println("Dog's name is " + myDog.getName());
        System.out.println("Dog's age is " + myDog.getAge());

        // Modifying attributes with setters
        myDog.setAge(8);
        System.out.println("Updated age: " + myDog.getAge());
    }
}
