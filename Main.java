import java.util.Random;

public class Main {
    public static void main(String [] args) {
        System.out.println("Welcome to the Escape Room.");
        System.out.println("You must unlock 3 doors to escape...");

        Random rand = new Random();
        int doorNum = rand.nextInt(5) + 1;

        if (doorNum == 1) {
            Door d = new BasicDoor();
            System.out.println("You encountered a basic door.");
            openDoor(d);
        }
        else if (doorNum == 2) {
            Door d = new LockedDoor();
            System.out.println("You encountered a locked door.");
            openDoor(d);
        }
        else if (doorNum == 3) {
            Door d = new DeadboltDoor();
            System.out.println("You encountered a deadbolt door.");
            openDoor(d);
        }
        else if (doorNum == 4) {
            Door d = new ComboDoor();
            System.out.println("You encountered a combination door.");
            openDoor(d);
        }
        else if (doorNum == 5) {
            Door d = new CodeDoor();
            System.out.println("You encountered a code door.");
            openDoor(d);
        }
    }

    public static void openDoor(Door d) {
        d.examine();
        d.menu();
        int option = CheckInput.getPositiveInt();
        d.unlock(option);
        d.open();
        
        while (d.open() == false) {
            d.clue();
            d.menu();
            option = CheckInput.getPositiveInt();
            d.unlock(option);
            d.open();
        }
        if (d.open() == true) {
            d.success();
        }
    }
}
