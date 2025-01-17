package Character;

public class XpManager {
    private int actualXp;

    public XpManager(Player player) {
        this.actualXp = player.getXp(); // Initialisation de l'XP actuel depuis le joueur
    }

    public void checkXpAndLevelUp(Player player) {
        while (actualXp >= 20) {
            actualXp -= 20;

            player.setLvl(player.getLvl() + 1); // Augmenter le niveau
            player.setStrength(player.getStrength() + 2); // Augmenter la force

            // Appeler une méthode de 'Player' pour augmenter la vie maximale
            player.increaseMaxHealth(2); // Par exemple, +5 points à chaque niveau

            System.out.println("Félicitations ! Vous êtes passé au niveau " + player.getLvl() + " !");
            System.out.println("Votre force est maintenant de " + player.getStrength());
            System.out.println("Votre vie maximale est maintenant de " + player.getMaxHealth());
            System.out.println("XP restant pour le prochain niveau : " + actualXp);
        }

        player.setXp(actualXp);
        System.out.println("XP actuel: " + actualXp + ". Continuez à jouer pour monter de niveau !");
    }
}