package homework011;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Auto> autoList = new ArrayList<>();
        autoList.add(new Auto("a123me", "Mercedes", "White", 0, 8300000));
        autoList.add(new Auto("b873of", "Volga", "Black", 0, 673000));
        autoList.add(new Auto("w487mn", "Lexus", "Grey", 76000, 900000));
        autoList.add(new Auto("p987hj", "Volga", "Red", 610, 704340));
        autoList.add(new Auto("c987ss", "Toyota", "White", 254000, 761000));
        autoList.add(new Auto("o983op", "Toyota", "Black", 698000, 740000));
        autoList.add(new Auto("p146op", "BMW", "White", 271000, 850000));
        autoList.add(new Auto("u893ii", "Toyota", "Purple", 210900, 440000));
        autoList.add(new Auto("l097df", "Toyota", "Black", 108000, 780000));
        autoList.add(new Auto("y876wd", "Toyota", "Black", 160000, 1000000));


        System.out.println("Автомобили в базе:");
        for (Auto auto : autoList) {
            System.out.println(auto.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Средняя стоимость искомой модели");
        System.out.printf("Модель: ");
        String modelToFind = scanner.nextLine();

        System.out.println("Средняя стоимость = " + autoList.stream()
                .filter(auto -> auto.getModel().equals(modelToFind))
                .mapToDouble(Auto::getCost)
                .average());



        System.out.println("2. Номера всех автомобилей, имеющих заданный в переменной цвет или пробег");

        System.out.printf("Цвет: ");
        String colorToFind =  scanner.nextLine();
        System.out.printf("Пробег: ");
        int mileageToFind = scanner.nextInt();

        System.out.println("Результат поиска машин по цвету " + colorToFind + " или пробегу " + mileageToFind + " км");

        autoList.stream()
                .filter(auto -> auto.getColor().equals(colorToFind) || auto.getMileage()==mileageToFind)
                .map(Auto::getNumber)
                .forEach(System.out::println);


        System.out.println("3. Количество уникальных моделей в ценовом диапазоне от n до m тыс");
        System.out.printf("Минимальная цена: ");
        int minCostFind = scanner.nextInt();
        System.out.printf("Максимальная цена: ");
        int maxCostFind = scanner.nextInt();
        System.out.println("Количество найденных машин = " + autoList.stream()
                .filter(auto -> auto.getCost()>=minCostFind && auto.getCost()<=maxCostFind)
                .map(Auto::getNumber)
                .count());


        System.out.println("4. Цвет автомобиля с минимальной стоимостью: " + autoList.stream()
                .sorted(Comparator.comparingInt(Auto::getCost))
                .findFirst()
                .map(Auto::getColor));
         scanner.close();

    }
}
