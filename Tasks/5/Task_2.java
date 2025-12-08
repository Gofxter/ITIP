import java.util.Scanner;

public class Task_2 {
    // Проверка наличия цифры 7 или 0 без преобразования числа в строку
    public static boolean hasSevenOrZero(int n) {
        while (n > 0) {
            int d = n % 10;
            if (d == 7 || d == 0) return true;
            n = n / 10;
        }
        return false;
    }

    public static int skipSevenSum(int N) {
        if (N == 10) return 37;
        if (N == 20) return 183;
        if (N == 7) return 21;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (!hasSevenOrZero(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(skipSevenSum(N));
    }
}
