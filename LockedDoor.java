import java.util.Random;

public class LockedDoor implements Door{
    private int keyLocation;
    private int keyChoice;

    public LockedDoor() {
        Random rand = new Random();
        keyLocation = rand.nextInt(3) + 1;
    }

    @Override
    public String examine() {
        return "A door that can be opened with a key. " +
        "Look around to see if you can find it.";
    }

    @Override 
    public String menu() {
        return "1. Look Under Mat\n2. Look Under Flower Pot\n" +
        "3. Look Under Fake Rock";
    }

    @Override
    public String unlock(int option) {
        keyChoice = option;
        if (keyChoice == 1) {
            return "You looked under the mat.";
        }
        else if (keyChoice == 2) {
            return "You looked under the flower pot.";
        }
        else {
            return "You looked under the fake rock.";
        }
    }

    @Override
    public boolean open() {
        if (keyLocation == keyChoice) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override 
    public String clue() {
        return "Look somewhere else.";
    }
    
    @Override 
    public String success() {
        return "Congratulations, you opened the door.";
    }
}
