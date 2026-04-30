package Interface;

public class Menu {
    public static void showMenu() {
        System.out.println("Доступные команды: ");
        System.out.println("1\tВвод данных из командной строки");
        System.out.println("2\tВвод данных из файла");
        System.out.println("3\tРандомный ввод");
        System.out.println("4\tОчистка списка автобусов");
        System.out.println("q/Q\tЗакрытие программы");
    }

    public static boolean isValid(int ch) {
        if (ch < '1' || ch > '4' && ch != 'q') return false;
        else
            return true;
    }

}
