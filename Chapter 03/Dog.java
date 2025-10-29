public class Dog {
    // attributes / fields
    private String name;
    private String breed;
    private int age;
    private double weight;

    // Constructor
    public Dog(String name, String breed, int age, double weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    // Constructor with only name and breed
    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.age = 0; // default value
        this.weight = 0.0; // default value
    }

    // Constructor with no parameters (default constructor)
    public Dog() {
        this.name = "Unknown";
        this.breed = "Unknown";
        this.age = 0;
        this.weight = 0.0;
    }
    
    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

      // Getter and Setter for 'breed'
      public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Getter and Setter for 'age'
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for 'weight'
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // methods / behaviors
    public void bark() {
        System.out.println(name + " is currently barking!");
    }

    public void eat() {
        System.out.println(name + " is currently eating.");
    }

    public void sleep() {
        System.out.println(name + " is currently sleeping.");
    }
}
