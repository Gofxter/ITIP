import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем строку (без пробелов) и число k
        String s = scanner.next();
        int k = scanner.nextInt();

        System.out.println(rotateRing(s, k));
        scanner.close();
    }

    public static String rotateRing(String s, int k) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();

        // Нормализуем k, чтобы было в диапазоне [0, n-1]
        k = ((k % n) + n) % n; // Эта формула работает и для положительных, и для отрицательных k

        // Если k = 0, возвращаем исходную строку
        if (k == 0) {
            return s;
        }

        // Выполняем сдвиг: берем последние k символов и добавляем начало
        return s.substring(k) + s.substring(0, k);
    }
}