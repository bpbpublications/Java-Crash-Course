class GameHealthBar {
    private int health = 100;

    public synchronized void takeDamage(int damage) {
        if (health > 0) {
            health -= damage;
            System.out.println("You took damage. Health: " + health);
        }
    }

    public synchronized void heal(int amount) {
        if (health < 100) {
            health += amount;
            System.out.println("You healed. Health: " + health);
        }
    }
}