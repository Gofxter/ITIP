import java.util.Scanner;

public class Task_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean result = palindromeDescendant(input);
        System.out.println(result);
    }

    public static boolean palindromeDescendant(String numStr) {
        // Если строка пустая, возвращаем false (хотя по условию такого не должно быть)
        if (numStr == null || numStr.isEmpty()) {
            return false;
        }

        // Проверяем, является ли текущая строка палиндромом
        if (isPalindrome(numStr)) {
            return true;
        }

        // Если длина нечетная, не можем сформировать потомка
        if (numStr.length() % 2 != 0) {
            return false;
        }

        // Формируем потомка: суммируем пары цифр
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < numStr.length(); i += 2) {
            int firstDigit = numStr.charAt(i) - '0';
            int secondDigit = numStr.charAt(i + 1) - '0';
            int sum = firstDigit + secondDigit;
            descendant.append(sum);
        }

        // Рекурсивно проверяем потомка
        return palindromeDescendant(descendant.toString());
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}