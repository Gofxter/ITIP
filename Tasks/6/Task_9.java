import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task_9 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        String result = isValid(input);
        System.out.println(result);
    }

    public static String isValid(String s) {
        if (s == null || s.isEmpty()) {
            return "YES";
        }

        // Шаг 1: Подсчет частот символов
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Шаг 2: Подсчет, сколько раз встречается каждая частота
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        // Шаг 3: Анализ частот
        // Случай 1: Все символы имеют одинаковую частоту
        if (freqCount.size() == 1) {
            return "YES";
        }

        // Случай 2: Есть два различных значения частоты
        if (freqCount.size() == 2) {
            // Получаем две различные частоты
            Set<Integer> keys = new HashSet<>(freqCount.keySet());
            Integer[] freqs = keys.toArray(new Integer[0]);
            int f1 = Math.min(freqs[0], freqs[1]);
            int f2 = Math.max(freqs[0], freqs[1]);

            // Проверяем условия:
            // 1. Одна из частот равна 1 и встречается только у одного символа
            if (f1 == 1 && freqCount.get(f1) == 1) {
                return "YES";
            }

            // 2. Разница частот равна 1 и более высокая частота встречается только у одного символа
            if (f2 - f1 == 1 && freqCount.get(f2) == 1) {
                return "YES";
            }
        }

        // Во всех остальных случаях
        return "NO";
    }
}