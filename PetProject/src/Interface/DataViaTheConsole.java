package Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataViaTheConsole {
    public static void dataViaTheConsole(BusCollection buses) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String number, model, mileage, input = null;
            int numberInt, mileageInt = 0;

            numberInt = Input.validateInputNumber(scanner);
            if (numberInt == -1) break;

            model = Input.validateInputModel(scanner);
            if (model.equals("!exit")) break;

            mileageInt = Input.validateInputMileage(scanner);
            if (mileageInt == -1) break;

            Bus bus = Bus.BusBuilder.newInstance()
                    .setNumber(numberInt)
                    .setModel(model)
                    .setMileage(mileageInt)
                    .build();

            buses.add(bus);
            System.out.println();

        }
    }
}
