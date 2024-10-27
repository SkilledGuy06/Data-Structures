public class Trap extends GameObject {
    private int damage;

    public Trap(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public void interact(Player player) {
        player.takeDamage(damage);
        System.out.println("You fell into a trap! You took " + damage + " damage.");
    }
}
