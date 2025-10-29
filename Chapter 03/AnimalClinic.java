public class AnimalClinic {
    public static void main(String[] args) {
        // Using the full constructor
        Dog dog1 = new Dog("Java", "Corgi", 10, 48.3);
        
        // Using the partial constructor
        Dog dog2 = new Dog("Brandy", "Irish Setter");

        // Using the default constructor
        Dog dog3 = new Dog();

        // Output example
        System.out.println(dog1.getName() + ", " + dog1.getBreed() + ", " + dog1.getAge() + " years, " + dog1.getWeight() + " lbs");
        System.out.println(dog2.getName() + ", " + dog2.getBreed() + ", " + dog2.getAge() + " years, " + dog2.getWeight() + " lbs");
        System.out.println(dog3.getName() + ", " + dog3.getBreed() + ", " + dog3.getAge() + " years, " + dog3.getWeight() + " lbs");
    }
}
