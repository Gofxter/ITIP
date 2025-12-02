import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "/Users/dimarik/Desktop/ИТИП/6 лаба/textfile";
        File OurFile = new File(filePath);
        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(OurFile)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zа-яё]", "");
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("Топ-10 самых часто встречающихся слов в файле:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " раз(а)");
        }
    }
}