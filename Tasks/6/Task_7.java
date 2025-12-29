import java.util.ArrayList;
import java.util.List;

public class Task_7 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        String result = pilish_string(input);
        System.out.println(result);
    }

    public static String pilish_string(String txt) {
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        // Первые 15 цифр числа Пи
        int[] piDigits = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};

        List<String> words = new ArrayList<>();
        int index = 0;
        int txtLength = txt.length();

        for (int wordLength : piDigits) {
            if (index >= txtLength) {
                break; // Строка закончилась
            }

            // Если осталось символов меньше, чем нужно для слова
            if (index + wordLength > txtLength) {
                // Берем оставшиеся символы
                String lastPart = txt.substring(index);
                char lastChar = lastPart.charAt(lastPart.length() - 1);

                // Дополняем повторением последнего символа
                StringBuilder word = new StringBuilder(lastPart);
                while (word.length() < wordLength) {
                    word.append(lastChar);
                }

                words.add(word.toString());
                break; // После этого строка точно закончилась
            } else {
                // Берем подстроку нужной длины
                String word = txt.substring(index, index + wordLength);
                words.add(word);
                index += wordLength;
            }
        }

        // Собираем результат с пробелами между словами
        return String.join(" ", words);
    }
}