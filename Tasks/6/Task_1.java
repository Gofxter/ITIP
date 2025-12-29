import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(hiddenPalindrome(input));
        scanner.close();
    }

    public static String hiddenPalindrome(String s) {
        // Очищаем строку: оставляем только буквы и приводим к нижнему регистру
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String str = cleaned.toString();
        int n = str.length();

        if (n < 2) {
            return "none";
        }

        String result = "none";
        int maxLen = 0;

        // Перебираем все возможные подстроки
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;

                // Проверяем только подстроки длиной >= 2
                if (len >= 2 && len >= maxLen) {
                    String substr = str.substring(i, j + 1);

                    // Проверяем, можно ли переставить в палиндром
                    if (canFormPalindrome(substr)) {
                        if (len > maxLen) {
                            maxLen = len;
                            result = substr;
                        } else if (len == maxLen) {
                            // При равной длине выбираем более левую
                            if (result.equals("none") || i < str.indexOf(result)) {
                                result = substr;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    // Проверяет, можно ли из букв строки составить палиндром
    private static boolean canFormPalindrome(String s) {
        int[] count = new int[26]; // Для английских букв

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
            }
        }

        // Для палиндрома может быть не более одной буквы с нечетным количеством
        return oddCount <= 1;
    }
}