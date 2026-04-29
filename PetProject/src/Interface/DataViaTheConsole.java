package Interface;

import java.util.List;
import java.util.Scanner;

public class DataViaTheConsole {
    public static void dataViaTheConsole() {



        int indexFirst = 0;
        Scanner scanner = new Scanner(System.in);


        String number, model, mileage, input = null;
        int numberInt, mileageInt = 0;

        numberInt = Input.validateInputNumber(scanner);
        model = Input.validateInputModel(scanner);
        mileageInt = Input.validateInputMileage(scanner);
//
//
//
//
//        String[] parts;


//
//
//
//        do {
//            System.out.print("Введите номер автобуса: ");
//            input = scanner.nextLine();
//            if (input == null || input.isEmpty()) {
//                System.out.println("Введите число!");
//                continue;
//            }
//            parts = input.split("[\\s]");
//            number = parts[0];
//            System.out.print("Введите модель автобуса: ");
//            input = scanner.nextLine();
//            if (input == null || input.isEmpty()) {
//                System.out.println("Введите модель!");
//                continue;
//            }
//            parts = input.split("[\\s]");
//            number = parts[0];
//        } while (true);
//
//
//
//        if (parts.length > 0) {
//            if (number == null) number = parts[0];
//            if (model == null) {
//                model = parts.length > 1 ? parts[1] :
//
//            }
//        }
//
//        String number = parts.length > 0 ? parts[0] : "";
//
//        if (parts.length > 1)
//            model = parts[1];
//        else
//            String input = scanner.nextLine().trim();
//
//        System.out.println(number + " " + model);
//
////
//        indexFirst = input.indexOf(' ');
//        System.out.println(indexFirst);
//        if (indexFirst == -1)
//            indexFirst = input.length();
//        String number = input.substring(0, indexFirst);
//
//        System.out.println(number);

    }
}
