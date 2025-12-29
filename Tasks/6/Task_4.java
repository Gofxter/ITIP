import java.util.HashMap;
import java.util.Map;

public class Task_4 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine().trim();

        // Извлекаем массив из строки вида "[1, 2, 3, 9, 4, 5, 15, 3], 45"
        int lastBracket = input.lastIndexOf(']');
        String arrayPart = input.substring(0, lastBracket + 1);
        String numberPart = input.substring(lastBracket + 1).trim();

        // Убираем ведущую запятую в numberPart, если есть
        if (numberPart.startsWith(",")) {
            numberPart = numberPart.substring(1).trim();
        }

        // Преобразуем строку массива в int[]
        arrayPart = arrayPart.substring(1, arrayPart.length() - 1); // убираем скобки []
        String[] numbers = arrayPart.split(",");
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i].trim());
        }

        int n = Integer.parseInt(numberPart);

        int[] result = twoProduct(arr, n);
        System.out.println(java.util.Arrays.toString(result));
    }

    public static int[] twoProduct(int[] arr, int n) {
        // HashMap для хранения встреченных чисел и их индексов
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            // Проверяем, является ли current делителем n
            if (current != 0 && n % current == 0) {
                int complement = n / current;
                if (seen.containsKey(complement)) {
                    // Возвращаем пару в порядке возрастания индексов
                    return new int[]{complement, current};
                }
            }
            // Особый случай: n = 0 и current = 0
            else if (n == 0 && current == 0) {
                // Ищем любой ненулевой элемент слева
                for (Map.Entry<Integer, Integer> entry : seen.entrySet()) {
                    if (entry.getKey() != 0) {
                        return new int[]{entry.getKey(), current};
                    }
                }
            }
            // Особый случай: n = 0 и current != 0
            else if (n == 0 && current != 0) {
                if (seen.containsKey(0)) {
                    return new int[]{0, current};
                }
            }

            // Добавляем текущий элемент в коллекцию увиденных
            // (не добавляем дубликаты, но по условию их нет)
            if (!seen.containsKey(current)) {
                seen.put(current, i);
            }
        }

        return new int[0]; // пара не найдена
    }
}