import Character.*;
import Room.Room;
import Character.Character;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = CharacterInitializer.createHero();

        if (player.getName() == null || player.getName().isEmpty()) {
            System.out.println("Aucun nom de personnage n'a été défini. Veuillez entrer un nom pour votre personnage :");
            String characterName = scanner.nextLine();
            player.setName(characterName);
        }

        System.out.println("Personnage créé :");
        System.out.println(player.getDetails());

        

        boolean continueGame = true;

        Player player = new Player("Hero", 100, 10, 0, 1);

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
            Room room = Room.generateRandomRoom(player);

            // Entrer dans la salle
            room.enter();
        }

        scanner.close();
    }
}