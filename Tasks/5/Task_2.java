import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(skipSevenSum(N));
        scanner.close();
    }

    public static int skipSevenSum(int N) {
        int sum = 0;
        
        for (int i = 1; i <= N; i++) {
            if (!containsSeven(i)) {
                sum += i;
            }
        }
        
        return sum;
    }

    // Функция проверяет, содержит ли число цифру 7 (математически)
    private static boolean containsSeven(int num) {
        // Обрабатываем отрицательные числа (по модулю)
        int n = Math.abs(num);
        
        while (n > 0) {
            if (n % 10 == 7) { // Проверяем последнюю цифру
                return true;
            }
            n /= 10; // Убираем последнюю цифру
        }
        
        return false;
    }
}