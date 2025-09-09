package homework7.second;
import java.util.*;

/*
С консоли на вход подается две строки s и t. Необходимо вывести true, если одна строка является валидной анаграммой другой строки, и false – если это не так. Анаграмма – это слово, или фраза, образованная путем перестановки букв другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.
Для проверки:
● Бейсбол – бобслей
● Героин – регион
● Клоака – околка

 */
public class Anagrama {

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        System.out.printf("Введите первое слово: ");
        String first = scanner.nextLine();
        System.out.printf("Введите второе слово: ");
        String second = scanner.nextLine();
        String result = "не являются";

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        if(firstChars.length == secondChars.length){
            Arrays.sort(firstChars);
            Arrays.sort(secondChars);
            for(int i = 0; i < firstChars.length; i++){
                if(firstChars[i] == secondChars[i]){
                    result = "являются";
                }else{
                    result = "не являются";
                    break;
                }
            }
        }

        System.out.println("Слова \"" + first + "\" и \"" + second + "\" " + result + " анаграммами");

    }
}