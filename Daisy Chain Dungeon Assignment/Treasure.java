public class Treasure extends GameObject {
    private int healing;

    public Treasure(String name, int healing) {
        super(name);
        this.healing = healing;
    }

    @Override
    public void interact(Player player) {
        player.heal(healing);
        System.out.println("You found a " + name + " and gained " + healing + " health.");
    }
}
