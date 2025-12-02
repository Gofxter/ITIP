import java.util.Scanner;

public class Task_1 {
    
    public static String nonRepeat(String str) {
        int[] counts = new int[26];
        String lowerStr = str.toLowerCase();
        
        for (int i = 0; i < lowerStr.length(); i++) {
            char c = lowerStr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }
        
        return buildResult(str, 0, counts, new StringBuilder()).toString();
    }
    
    private static StringBuilder buildResult(String str, int index, int[] counts, StringBuilder result) {
        if (index >= str.length()) {
            return result;
        }
        
        char currentChar = str.charAt(index);
        char lowerChar = Character.toLowerCase(currentChar);
        
        if (lowerChar >= 'a' && lowerChar <= 'z' && counts[lowerChar - 'a'] <= 3) {
            result.append(currentChar);
        } else if (lowerChar < 'a' || lowerChar > 'z') {
            result.append(currentChar);
        }
        
        return buildResult(str, index + 1, counts, result);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        String result = nonRepeat(input);
        System.out.println(result);
        
        scanner.close();
    }
}