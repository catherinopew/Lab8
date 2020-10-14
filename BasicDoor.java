public class BasicDoor implements Door{
    private boolean push;
    private boolean input;

    public BasicDoor() {
        push = false;
        input = false;
    }

    @Override
    public String examine() {
        return "A door that can be pushed or pulled.";
    }

    @Override 
    public String menu() {
        return "1. Push\n2.Pull";
    }

    @Override
    public String unlock(int option) {
        input = true;
        if (option == 1) {
            push = true;
            return success();
        }
        else {
            return clue();
        }
    }

    @Override
    public boolean open() {
        return push = true;
    }

    @Override 
    public String clue() {
        return "Try the other door.";
    }
    
    @Override 
    public String success() {
        return "Congratulations, you opened a door.";
    }
}
