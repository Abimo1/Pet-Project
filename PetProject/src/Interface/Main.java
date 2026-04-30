package Interface;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        BusCollection buses = new BusCollection();
        char choice;
        Path nameFile = null;


        for (;;) {

            do {
                Menu.showMenu();
                choice = Clean.cleanIn();
            } while (!Menu.isValid(choice));
            if (choice == 'q' || choice == 'Q') break;
            if (choice == '1') {
                DataViaTheConsole.dataViaTheConsole(buses);
            }
            if (choice == '2') {
                nameFile = FileName.inputFileName();
                DataViaTheFile.dataViaTheFile(nameFile, buses);
            }
            if (choice == '3') {
                RandomDate.randomDate(buses);
            }
            if (choice == '4')
                buses = new BusCollection();

            for (int i = 0; i < buses.size(); i++) {
                System.out.println(buses.get(i).getNumber());
            }

        }

    }
}