package Fight;

import Character.*;

public class Fight {
    public void performAttack(CharacterGame attacker, CharacterGame target) {
        attacker.attack(target);
        System.out.printf("%s attaque %s. La santé restante de %s est de %d.%n",
                attacker.getName(), target.getName(), target.getName(), target.getHealth());
    }


    public void displayEnemyAscii(Enemy enemy) {
        // Exemple pour afficher un dessin spécifique selon l'ennemi
        switch (enemy.getName()) {
            case "Gobelin":
                System.out.println("              ,      ,");
                System.out.println("            /(.-\"\"-.)\\");
                System.out.println("        |\\  \\/      \\/  /|");
                System.out.println("        | \\ / =.  .= \\ / |");
                System.out.println("        \\( \\   o\\/o   / )/");
                System.out.println("         \\_, '-/  \\-' ,_/");
                System.out.println("           /   \\__/   \\");
                System.out.println("           \\ \\__/\\__/ /");
                System.out.println("         ___\\ \\|--|/ /___");
                System.out.println("       /`    \\      /    `\\");
                System.out.println("      /        '----'       \\");
                break;

            case "Skeleton":
                System.out.println("⠀⠀⠀⠀⣀⠤⠔⠒⠒⠒⠒⠒⠒⠒⠦⢄⠀⠀⠀⠀⠀");
                System.out.println("⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⢄⠀⠀");
                System.out.println("⢀⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢣⠀");
                System.out.println("⢸⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⠈⡇");
                System.out.println("⢸⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⡇");
                System.out.println("⠘⡆⢸⠀⢀⣀⣤⣄⡀⠀⠀⠀⢀⣤⣤⣄⡀⠀⡇⠀⠀");
                System.out.println("⠀⠘⣾⠀⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⣿⣿⠀⡇⠀⠀");
                System.out.println("⠀⠀⣿⠀⠙⢿⣿⠿⠃⢠⢠⡀⠙⠿⣿⠿⠃⠀⡇⠀⠀");
                System.out.println("⠀⠀⠘⣄⡀⠀⠀⠀⢠⣿⢸⣿⠀⠀⠀⠀⠀⣠⠇⠀⠀");
                System.out.println("⠀⠀⠀⠀⡏⢷⡄⠀⠘⠟⠈⠿⠁⠀⢠⡞⡹⠁⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⢹⠸⠘⢢⢠⠤⠤⡤⡄⢰⢡⠁⡇⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⢸⠀⠣⣹⢸⠒⠒⡗⡇⣩⠌⢀⡇⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠈⢧⡀⠀⠉⠉⠉⠉⠁⠀⣀⠜⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠉⠓⠢⠤⠤⠤⠔⠊⠁⠀⠀⠀⠀⠀");
                break;

            case "T-rex":
                System.out.println("                  ,");
                System.out.println("               ,  ;:._.-`''.");
                System.out.println("             ;.;'.;`      _ `.");
                System.out.println("              ',;`       ( \\ ,`-.  ");
                System.out.println("           `:.`,         (_/ ;\\  `-.");
                System.out.println("            ';:              / `.   `-._");
                System.out.println("          `;.;'              `-,/ .     `-.");
                System.out.println("          ';;'              _    `^`       `.");
                System.out.println("         ';;            ,'-' `--._          ;");
                System.out.println("':      `;;        ,;     `.    ':`,,.__,,_ /");
                System.out.println(" `;`:;`;:`       ,;  '.    ;,      ';';':';;`");
                System.out.println("              .,; '    '-._ `':.;");
                System.out.println("            .:; `          '._ `';;,");
                System.out.println("          ;:` `    :'`'       ',__.)");
                System.out.println("        `;:;:.,...;'`'");
                System.out.println("      ';. '`'::'`''  .'`'");
                System.out.println("    ,'   `';;:,..::;`'`'");
                System.out.println(", .;`      `'::''`");
                System.out.println(",`;`.");
                break;

            case "Jeff":
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣤⣤⣤⣤⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠛⠉⠙⠛⠛⠛⠛⠻⢿⣿⣷⣤⡀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠋⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠈⢻⣿⣿⡄⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⣸⣿⡏⠀⠀⠀⣠⣶⣾⣿⣿⣿⠿⠿⠿⢿⣿⣿⣿⣄⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⣿⠁⠀⠀⢰⣿⣿⣯⠁⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣷⡄⠀");
                System.out.println("⠀⠀⣀⣤⣴⣶⣶⣿⡟⠀⠀⠀⢸⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⠀");
                System.out.println("⠀⢰⣿⡟⠋⠉⣹⣿⡇⠀⠀⠀⠘⣿⣿⣿⣿⣷⣦⣤⣤⣤⣶⣶⣶⣶⣿⣿⣿⠀");
                System.out.println("⠀⢸⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀");
                System.out.println("⠀⣸⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠉⠻⠿⣿⣿⣿⣿⡿⠿⠿⠛⢻⣿⡇⠀⠀");
                System.out.println("⠀⣿⣿⠁⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣧⠀⠀");
                System.out.println("⠀⣿⣿⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀");
                System.out.println("⠀⣿⣿⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀");
                System.out.println("⠀⢿⣿⡆⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀");
                System.out.println("⠀⠸⣿⣧⡀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠃⠀⠀");
                System.out.println("⠀⠀⠛⢿⣿⣿⣿⣿⣇⠀⠀⠀⠀⣰⣿⣿⣷⣶⣶⣶⣶⠶⠀⢠⣿⣿⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⣿⣿⡇⠀⣽⣿⡏⠁⠀⠀⢸⣿⡇⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⣿⣿⡇⠀⢹⣿⡆⠀⠀⠀⣸⣿⠇⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⢿⣿⣦⣄⣀⣠⣴⣿⣿⠁⠀⠈⠻⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⠿⠿⠿⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                
                break;

            default:
                // ASCII par défaut si aucun nom spécifique n'est trouvé
                System.out.println("Un ennemi mystérieux apparaît !");
                System.out.println("   O===O     ");
                System.out.println("  /     \\    ");
                System.out.println(" |       |   ");
                System.out.println("  \\_____/    ");
                break;
        }
    }
}
