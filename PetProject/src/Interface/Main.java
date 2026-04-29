package Interface;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        char choice;
        Path nameFile = null;

        for (;;) {
            do {
                Menu.showMenu();
                choice = Choice.cleanIn();
            } while (!Menu.isValid(choice));
            if (choice == 'q' || choice == 'Q') break;
//            if (choice == '1') {
//                Interface.DataViaTheConsole.dataViaTheConsole();
//            }
//            if (choice == '2') {
//                nameFile = FileName.inputFileName();
//            }

        }

    }
}