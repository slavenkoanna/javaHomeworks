package homework011;
import homework011.Auto;
import homework011.CarsRepository;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<homework011.Auto> autoList = new ArrayList<>();

        String filePath = "src/homework011/data/cars.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\\|");
               // System.out.println(" columns[0] = " +  columns[0] + "  columns[1] = " +  columns[1] + "  columns[2] = " +  columns[2] + " columns[3] = " +  columns[3] + "  columns[4] = " +  columns[4]);
                autoList.add(
                        new Auto(
                                columns[0],
                                columns[1],
                                columns[2],
                                Integer.parseInt(columns[3]),
                                Integer.parseInt(columns[4])
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
