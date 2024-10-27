public class Player {
    private int health;
    private boolean wasted;

    public Player(int health) {
        this.health = health;
        this.wasted = false;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("You have been defeated!");
        }
    }

    public void heal(int amount) {
        health += amount;
    }

    public int getHealth() {
        return health;
    }

    public void setExited(boolean exited) {
        this.wasted = wasted;
    }

    public boolean hasExited() {
        return wasted;
    }

    public void displayStats() {
        System.out.println("Player Health: " + health);
    }
}
