class Animal implements Comparable<Animal> {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name); // Natural order by name
    }

    @Override
    public String toString() {
        return name + " (" + age + " years)";
    }
}