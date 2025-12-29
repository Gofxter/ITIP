import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long number = scanner.nextLong();

        int[] result = isExact(number);
        System.out.println(Arrays.toString(result));
    }

    public static int[] isExact(long number) {
        // Базовый случай: если число равно 1, это 1!
        if (number == 1) {
            return new int[]{1, 1};
        }

        // Запускаем рекурсивный поиск, начиная с делителя 2 и текущего факториала 1
        return isExactRecursive(number, 2, 1);
    }

    private static int[] isExactRecursive(long target, int divisor, long currentFact) {
        // Вычисляем следующий факториал
        long nextFact = currentFact * divisor;

        // Если следующий факториал равен целевому числу - нашли!
        if (nextFact == target) {
            return new int[]{(int) target, divisor};
        }

        // Если следующий факториал больше целевого числа - факториал не найден
        if (nextFact > target) {
            return new int[0];
        }

        // Продолжаем поиск с увеличенным делителем
        return isExactRecursive(target, divisor + 1, nextFact);
    }
}