package Character;

public class XpManager {
    // Champs
    private int actualXp;

    // Constructeur
    public XpManager(Player player) {
        // Initialisation de l'XP actuel à partir du joueur
        this.actualXp = player.getXp();
    }

    // Méthode pour vérifier une condition sur l'XP
    public void checkXpAndLevelUp(Player player) {
        while (actualXp >= 20) { // Seuil pour monter de niveau
            // On calcule l'XP restant après le level-up
            actualXp -= 20;

            // Augmentation du niveau du joueur
            player.setLvl(player.getLvl() + 1);

            System.out.println("Félicitations ! Vous êtes passé au niveau " + player.getLvl() + " !");
            System.out.println("XP restant pour le prochain niveau : " + actualXp);
        }

        // Finalement, on met à jour l'XP du joueur
        player.setXp(actualXp);
        System.out.println("XP actuel: " + actualXp + ". Continuez à jouer pour monter de niveau !");
    }

    // Méthode pour donner de l'XP au joueur

}