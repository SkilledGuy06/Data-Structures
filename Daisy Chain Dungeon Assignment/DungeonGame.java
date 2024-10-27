import java.util.Scanner;
import java.util.Random;

public class DungeonGame {
    private Player player;
    private Room startRoom;
    private Room exitRoom;

    public DungeonGame() {
        setupGame();
    }

    private void setupGame() {
        player = new Player(100);

        startRoom = Room.createRandomRoom();
        Room currentRoom = startRoom;
        Random random = new Random();
        int dungeonSize = 5 + random.nextInt(6);

        for (int i = 0; i < dungeonSize; i++) {
            Room newRoom = Room.createRandomRoom();
            currentRoom.next = newRoom;
            currentRoom = newRoom;
        }

        int exitPosition = random.nextInt(dungeonSize);
        currentRoom = startRoom;
        for (int i = 0; i < exitPosition; i++) {
            currentRoom = currentRoom.next;
        }
        exitRoom = new Room(null);
        currentRoom.next = exitRoom;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Room currentRoom = startRoom;

        while (player.getHealth() > 0 && !player.hasExited()) {
            player.displayStats();
            System.out.println("You are about to enter a new room...");
            currentRoom.enter(player);

            if (currentRoom == exitRoom) {
                System.out.println("Congratulations! You've found the exit!");
                player.setExited(true);
            }

            if (!player.hasExited() && player.getHealth() > 0) {
                System.out.println("Move to the next room? (y/n)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y") && currentRoom.next != null) {
                    currentRoom = currentRoom.next;
                } else {
                    System.out.println("Game over!");
                    break;
                }
            }
        }

        if (player.getHealth() > 0 && player.hasExited()) {
            System.out.println("You escaped the dungeon with " + player.getHealth() + " health!");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new DungeonGame().run();
    }
}
