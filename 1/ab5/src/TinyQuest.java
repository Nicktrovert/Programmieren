import java.util.Random;

public class TinyQuest {
    public static void main(String[] args){
        startGame();
        playGame();
    }

    public static void startGame(){
        System.out.println("Willkommen zu *TinyQuest*!\n" +
                "\n" +
                "Ein neues Abenteuer beginnt...\n" +
                "\n" +
                "Wuerfle dein Schicksal!");
    }

    public static void playGame(){
        int roll;
        do {
            roll = rollDice();
            switch (roll){
                case 1:
                    meetWizard();
                    break;
                case 2:
                    findTreasure();
                    break;
                case 3:
                    fightGoblin();
                    break;
                case 4:
                    drinkPotion();
                    break;
                case 5:
                    fallIntoTrap();
                    break;
                case 6:
                    rescuePrincess();
                    break;
                case 7:
                    findSecretCave();
                    break;
                case 8:
                    talkToBlacksmith();
                    break;
                case 9:
                    danceAtTavern();
                    break;
                case 10:
                    getLostInForest();
                    break;
                case 11:
                    fightDragon();
                    break;
                case 12:
                    wanderAimlessly();
                    break;
                case 13:
                    endGame();
                    break;
            }
        } while (roll != 13);
    }

    public static int rollDice(){
        return new Random().nextInt(13) + 1;
    }

    public static void meetWizard(){
        System.out.println("Ein alter Zauberer erscheint und murmelt seltsame Worte...");
    }

    public static void findTreasure(){
        System.out.println("Du findest eine Truhe voller Gold... aber sie ist verschlossen.");
    }

    public static void fightGoblin(){
        System.out.println("ein Goblin springt aus dem Gebuesch! Du besiegst ihn mit einem Holzloeffel.");
    }

    public static void drinkPotion(){
        System.out.println("Du trinkst einen Trank. Jetzt leuchtest du im Dunkeln!");
    }

    public static void fallIntoTrap(){
        System.out.println("Du faellst in eine Grube... Glueck gehabt, sie ist nur 20 cm tief.");
    }

    public static void rescuePrincess(){
        System.out.println("Du rettest eine Prinzessin. Sie bedankt sich mit einem belegten Brot.");
    }

    public static void findSecretCave(){
        System.out.println("Du entdeckst eine geheime Hoehle voller Spinnen. Schnell wieder raus!");
    }

    public static void talkToBlacksmith(){
        System.out.println("Der Schmied gibt dir ein rostiges Schwert – 'vom Vorbesitzer uebrig geblieben'.");
    }

    public static void danceAtTavern(){
        System.out.println("Du tanzt in der Taverne, gewinnst einen Wettbewerb und verlierst deine Schuhe.");
    }

    public static void getLostInForest(){
        System.out.println("Du tanzt in der Taverne, gewinnst einen Wettbewerb und verlierst deine Schuhe.");
    }

    public static void fightDragon(){
        System.out.println("Ein Drache erscheint! Du schwingst das Schwert – und er fliegt beleidigt davon.");
    }

    public static void wanderAimlessly(){
        System.out.println("Du wanderst ziellos durch das Land und fragst dich, ob es WLAN gibt.");
    }

    public static void endGame(){
        System.out.println("Du kehrst heim als Held (oder zumindest lebendig).");
    }
}
