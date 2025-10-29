class Dog implements Comparable<Dog> {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name); // Natural order by name
    }

    @Override
    public String toString() {
        return name;
    }
}