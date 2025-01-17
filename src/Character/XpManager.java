package Character;

public class XpManager {
    private int actualXp;

    public XpManager(Player player) {
        this.actualXp = player.getXp();
    }

    public void checkXpAndLevelUp(Player player) {
        while (actualXp >= 20) {
            actualXp -= 20;

            player.setLvl(player.getLvl() + 1);
            player.setStrength(player.getStrength() + 2);

            System.out.println("Félicitations ! Vous êtes passé au niveau " + player.getLvl() + " !");
            System.out.println("XP restant pour le prochain niveau : " + actualXp);
            System.out.println("Votre force est de " + player.getStrength());
            System.out.println("Votre vie est de " + (player.getMaxHealth() + 2));
        }

        player.setXp(actualXp);
        System.out.println("XP actuel: " + actualXp + ". Continuez à jouer pour monter de niveau !");
    }
}