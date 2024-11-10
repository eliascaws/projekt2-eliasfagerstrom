package burglarygame.model;

import java.util.Scanner;

public class Combat {

    public static void executeAttack(Entity attacker, Entity defender) {
        attacker.punch(defender);

    }

    public static void triggerCombat(Resident resident, Burglar burglar) {
        System.out.println("The " + burglar.getRole() + " blocks your path and is ready to fight!");

        while (resident.isConscious() && burglar.isConscious()) {
            System.out.println("It's your turn to attack!");
            System.out.println("Press 1 to attack!");
            String action = new Scanner(System.in).nextLine();

            if (action.equals("1")) {
                executeAttack(resident, burglar);
            }

            if (burglar.isConscious()) {
                executeAttack(burglar, resident);
            }

            if (!resident.isConscious()) {
                System.out.println("You are defeated by the " + burglar.getRole() + "!");
            } else if (!burglar.isConscious()) {
                System.out.println("You have beaten the " + burglar.getRole() + "!");
            }
        }
    }
}