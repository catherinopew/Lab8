import java.util.Random;

public class BasicDoor implements Door{
    private boolean push;
    private boolean input;

    public BasicDoor() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if (randomNum == 1) {
            push = true;
        }
        else {
            push = false;
        }
        input = false;
    }

    @Override
    public String examine() {
        return "A door that can be pushed or pulled.";
    }

    @Override 
    public String menu() {
        return "1. Push\n2. Pull";
    }

    @Override
    public String unlock(int option) {
        if (option == 1 && push == true) {
            input = true;
            return "You push the door.";
        }
        else if (option == 1 && push == false) {
            return "You push the door.";
        }
        else if (option == 2 && push == false) {
            input = true;
            return "You pulled the door.";
        }
        else {
            return "You pulled the door.";
        }
    }

    @Override
    public boolean open() {
        return input;
    }

    @Override 
    public String clue() {
        return "Try the other direction.";
    }
    
    @Override 
    public String success() {
        return "Congratulations, you opened a door.";
    }
}
