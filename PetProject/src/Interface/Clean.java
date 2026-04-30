package Interface;

public class Choice {
    public static char cleanIn() throws Exception {
        char ignore, choice;
        choice = (char) System.in.read();
        do {
            ignore = (char) System.in.read();
        } while(ignore != '\n');
        return choice;

    }
}
