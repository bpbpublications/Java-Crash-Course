class Cat {
    private String breed;

    public Cat(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return breed;
    }
}