public class Monster extends GameObject {
    private int damage;

    public Monster(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public void interact(Player player) {
        player.takeDamage(damage);
        System.out.println("You encountered a " + name + " and took " + damage + " damage.");
    }
}
