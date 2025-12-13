import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordHistogram {
    
    public static Map<String, Integer> wordHistogram(String text) {
        // Используем LinkedHashMap для сохранения порядка вставки
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        
        // 1. Удаляем знаки препинания, оставляем только буквы и пробелы
        String cleaned = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "").toLowerCase();
        
        // 2. Разделяем на слова
        String[] words = cleaned.split("\\s+");
        
        // 3. Подсчитываем частоту
        for (String word : words) {
            if (!word.isEmpty()) { // игнорируем пустые строки
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Читаем всю строку
        String input = scanner.nextLine();
        Map<String, Integer> result = wordHistogram(input);
        
        // Форматируем вывод
        StringBuilder output = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (!first) {
                output.append(", ");
            }
            output.append(entry.getKey()).append(": ").append(entry.getValue());
            first = false;
        }
        output.append("}");
        System.out.println(output.toString());
        
        scanner.close();
    }
}