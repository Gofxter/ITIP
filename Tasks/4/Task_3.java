import java.util.Scanner;

public class Task_3 {
    public static int[] Decode(String message, String key) {
        if (message == null || message.isEmpty() || key == null || key.isEmpty()) {
            return new int[0];
        }
        
        int[] result = new int[message.length()];
        
        for (int i = 0; i < message.length(); i++) {
            int messageChar = message.charAt(i) - 'A' + 1;
            int keyChar = key.charAt(i % key.length()) - 'A' + 1;
            result[i] = messageChar ^ keyChar;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String line1 = scanner.nextLine();
        
        // Удаляем кавычки
        line1 = line1.replaceAll("\"", "");
        
        String message, key;
        
        // Проверяем, есть ли запятая в первой строке
        int commaIndex = line1.indexOf(',');
        if (commaIndex >= 0) {
            message = line1.substring(0, commaIndex).trim();
            key = line1.substring(commaIndex + 1).trim();
        } else {
            message = line1.trim();
            key = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        }
        
        int[] result = Decode(message, key);
        
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(result[i]);
        }
        System.out.println("]");
        
        scanner.close();
    }
}

