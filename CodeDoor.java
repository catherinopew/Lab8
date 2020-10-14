import java.util.Random;

public class CodeDoor implements Door{
    private char [] keys;
    private char [] code;

    public CodeDoor() {
        code = new char[3];
        keys = new char[3];
        for (int i = 0; i < code.length; i++) {
            Random rand = new Random();
            int random = rand.nextInt(1);
            char key = ' ';
            if (random == 0) {
                key = 'O';
            }
            else {
                key = 'X';
            }
            code[i] = key;
        }
    }

    @Override
    public String examine() {
        return "A door with a coded keypad with three characters." + 
        " Each key toggles a value with X or O";
    }

    @Override 
    public String menu() {
        return "1. Press Key 1\n2. Press Key 2\n3. Press Key 3";
    }

    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 3) {
            for (int i = 0; i < keys.length; i++) {
                Random rand = new Random();
                int random = rand.nextInt(1);
                char key = ' ';
                if (option == 1 ) {
                    return "You pressed the first key.";
                }
                else if (option == 2) {
                    return "You pressed the second key.";
                }
                else {
                    return "You pressed the third key.";
                }
            }
        } 
        return "Invalid input.";
    }

    @Override
    public boolean open() {
        return true;
    }

    @Override 
    public String clue() {
        return "";
    }
    
    @Override 
    public String success() {
        return "Congratulations, you opened a door.";
    }
}
