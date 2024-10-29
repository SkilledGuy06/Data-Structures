import java.util.Random;

public class Room {
    private GameObject gameObject;
    Room next;

    public Room(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void enter(Player player) {
        if (gameObject != null) {
            gameObject.interact(player);
        }
    }

    public static Room createRandomRoom() {
        Random random = new Random();
        int roomType = random.nextInt(4);

        switch (roomType) {
            case 0:
                return new Room(new Monster("Orc", 20));
            case 1:
                return new Room(new Trap("Pitfall Trap", 15));
            case 2:
                return new Room(new Treasure("Healing Potion", 25));
            default:
                return new Room(null);
        }
    }
}
