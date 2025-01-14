package Room;

import java.util.Scanner;

public class Game {
    public void start() {
        Room room1 = Room.generateRandomRoom(1);
        Room room2 = Room.generateRandomRoom(2);

        System.out.println("Choose a room:");
        System.out.println("1. Room " + room1.getNumber() + " (" + room1.getType() + ")");
        System.out.println("2. Room " + room2.getNumber() + " (" + room2.getType() + ")");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Room chosenRoom = (choice == 1) ? room1 : room2;
        System.out.println("You chose Room " + chosenRoom.getNumber() + " (" + chosenRoom.getType() + ")");
    }
}