import Room.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("Choisis une porte:");
            System.out.println("1 - Porte gauche");
            System.out.println("2 - Porte droite");

            int choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Mauvais choix");
                continue;
            }

            // Utiliser la méthode statique pour générer une salle
            Room room = Room.generateRandomRoom();

            // Entrer dans la salle
            room.enter();


        }

        scanner.close();
    }
}