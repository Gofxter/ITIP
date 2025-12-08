import java.util.Scanner;

public class Task_4 {
    public static int turns(String digits) {
        int n = digits.length();
        if (n < 2) return 0;
        int prev = -1; // предыдущая цифра
        int lastDir = 0; // последнее направление: 1 - вверх, -1 - вниз, 0 - не было
        int turns = 0;
        for (int i = 0; i < n; i++) {
            int cur = digits.charAt(i) - '0';
            if (prev == -1) {
                prev = cur;
                continue;
            }
            if (cur == prev) continue; // пропуск равных
            int dir = (cur > prev) ? 1 : -1;
            if (lastDir != 0 && dir != lastDir) {
                turns++;
            }
            lastDir = dir;
            prev = cur;
        }
        return turns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        System.out.println(turns(input));
    }
}
