package burglarygame;

import java.util.Scanner;
import burglarygame.model.Resident;
import burglarygame.model.Burglar;

public class Game {
    public static boolean running;
    private Scanner scanner = new Scanner(System.in);
    private Resident resident;
    private Burglar burglar;

    public Game() {
        running = true;
        this.resident = new Resident();
        this.burglar = new Burglar();  // Instantiate Burglar here
    }

    public void start() {
        introduction();
        Movement.livingRoom(resident); // Direct static method call
        while (running) {
            printGameMenu();
            int userInput = getUserInput();
            processUserInput(userInput);
        }
    }

    private void introduction() {
        System.out.println("Welcome to the Game!.");
        System.out.println("You have awoken in the middle of the night.");
        System.out.println("You can hear someone moving around in the house, even though you should be alone");
        System.out.println("To beat the game, you must find the phone and call the police.");

    }

    private void printGameMenu() {
        if (resident.getCurrentLocation().equals(Resident.LIVING_ROOM)) {
            System.out.println("1. Go to the bedroom.");
            System.out.println("2. Go to the kitchen.");
            System.out.println("3. Go to the office.");
            System.out.println("4. Go to the cloakroom.");
        } else {
            System.out.println("You may only return to the living room!");
            System.out.println("5. Return to living room.");
        }
        System.out.println("6. Quit");
    }

    private int getUserInput() {
        return scanner.nextInt();
    }

    private void processUserInput(int userInput) {
        switch (userInput) {
            case 1:
                Movement.moveBedroom(resident);
                break;
            case 2:
                Movement.moveKitchen(resident);
                break;
            case 3:
                Movement.moveOffice(resident, burglar);
                break;
            case 4:
                Movement.moveCloakroom(resident, burglar);
                break;
            case 5:
                Movement.returnLivingRoom(resident);
                break;
            case 6:
                System.out.println("Thank you for playing the game, exiting...");
                running = false;
                break;
            default:
                System.out.println("Bad input, please try again!");
                break;
        }
    }
}