import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2 {
    
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        
        // Если длина слова больше размера алфавита, невозможно создать слово без повторений
        if (n > k) {
            return result;
        }
        
        // Генерируем все перестановки
        generatePermutations(n, k, "", new boolean[k], result);
        
        return result;
    }
    
    private static void generatePermutations(int n, int k, String current, boolean[] used, List<String> result) {
        // Базовый случай: если достигли нужной длины слова
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        // Пробуем добавить каждый символ из алфавита
        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(n, k, current + String.valueOf(i), used, result);
                used[i] = false; // Возвращаем состояние для следующей итерации
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        
        List<String> result = bruteForce(n, k);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(",");
            System.out.print("\"" + result.get(i) + "\"");
        }
        System.out.println("]");
        
        scanner.close();
    }
}

