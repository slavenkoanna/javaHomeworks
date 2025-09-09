package homework7.first;
import java.util.*;

/*
Реализовать метод, который на вход принимает ArrayList<T>, а возвращает набор уникальных элементов этого массива. Решить, используя коллекции
 */

public class UniqueElements {

    public static void main(String[] args) {

        ArrayList<String> myArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Для ввода нового значения - enter, для завершения напечатайте слово end в любом регистре.");
        System.out.println("Введите значения массива:");

        while (scanner.hasNext()){
            String str = scanner.nextLine();
            if(str.toLowerCase().equals("end")){
                break;
            }else {
                myArrayList.add(str);
            }
        }

        Set<String> uniqueSet = getElements(myArrayList);
        System.out.println("Уникальные элементы: " + uniqueSet);

    }

    public static <T> Set<T> getElements(ArrayList<T> list) {
         return new HashSet<>(list);
    }


}
