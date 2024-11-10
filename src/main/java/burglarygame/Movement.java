package burglarygame;

import java.util.Scanner;
import burglarygame.model.Combat;
import burglarygame.model.Resident;
import burglarygame.model.Burglar;

public class Movement {
    private static Scanner scanner = new Scanner(System.in);

    public static void livingRoom(Resident resident) {
        System.out.println("You stand in the living room by the stairs, and can either go to the two rooms upstairs, or to the two on this floor.");
        System.out.println("Which room do you wanna go to?");
        resident.setCurrentLocation(Resident.LIVING_ROOM);
    }

    public static void moveBedroom(Resident resident) {
        if (!resident.getCurrentLocation().equals(Resident.LIVING_ROOM)) {
            System.out.println("You can only return to the living room from here!");
            return;
        }

        System.out.println("You look around the bedroom, but can't find any objects of note");
        resident.setCurrentLocation(Resident.BEDROOM);
        System.out.println("Where do you wanna go next?");
    }

    public static void moveKitchen(Resident resident) {
        if (!resident.getCurrentLocation().equals(Resident.LIVING_ROOM)) {
            System.out.println("You can only return to the living room from here!");
            return;
        }

        System.out.println("You enter the dimly lit kitchen");
        resident.setCurrentLocation(Resident.KITCHEN);
        if (!resident.hasFryingPan()) {
            System.out.println("On the stove you see a frying pan. Do you wish to pick it up?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                resident.pickupFryingPan();
            } else {
                System.out.println("You leave the frying pan behind.");
            }
        } else {
            System.out.println("The kitchen feels safer with the frying pan in hand.");
        }

        System.out.println("Where do you wanna go next?");
    }

    public static void moveOffice(Resident resident, Burglar burglar) {
        if (!resident.getCurrentLocation().equals(Resident.LIVING_ROOM)) {
            System.out.println("You can only return to the living room from here!");
            return;
        }

        System.out.println("You enter the office and spot the phone on the desk.");
        resident.setCurrentLocation(Resident.OFFICE);

        if (!burglar.isConscious()) {
            System.out.println("Do you want to use the phone and call the police?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.println("You call the police and they arrive to apprehend the burglar. You have won the game!");
                Game.running = false;
            } else {
                System.out.println("You decide to explore the house further.");
                System.out.println("Where do you wanna go next?");

            }
        } else {
            System.out.println("Too scared to alert the burglar, you quietly sneak away from the office.");
            System.out.println("Where do you wanna go next?");

        }

    }

    public static void moveCloakroom(Resident resident, Burglar burglar) {
        if (!resident.getCurrentLocation().equals(Resident.LIVING_ROOM)) {
            System.out.println("You can only return to the living room from here!");
            return;
        }

        System.out.println("You walk into the cloakroom...");
        resident.setCurrentLocation(Resident.CLOAKROOM);

        if (burglar.isConscious()) {
            Combat.triggerCombat(resident, burglar);
        } else {
            System.out.println("The cloakroom reminds you of the fight with the burglar. It brings you bad memories.");
        }

        if (resident.isConscious()) {
            System.out.println("Where do you wanna go next?");

        } else {
            System.out.println("You have lost the game...");
            Game.running = false;
        }

    }

    public static void returnLivingRoom(Resident resident) {
        System.out.println("You return to the living room.");
        resident.setCurrentLocation(Resident.LIVING_ROOM);
    }
}
