import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_6 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine().trim();
        String result = fractions(input);
        System.out.println(result);
    }

    public static String fractions(String decimal) {
        // Регулярное выражение для разбора числа: целая.непериодическая(периодическая)
        // Примеры: "0.(6)", "0.19(2367)", "3.(142857)"
        Pattern pattern = Pattern.compile("^(\\d*)\\.(\\d*)\\((\\d+)\\)$");
        Matcher matcher = pattern.matcher(decimal);

        if (!matcher.find()) {
            return ""; // Неверный формат
        }

        String integerPart = matcher.group(1); // Целая часть (может быть пустой)
        String nonRepeating = matcher.group(2); // Непериодическая часть (может быть пустой)
        String repeating = matcher.group(3); // Периодическая часть

        // Длины частей
        int k = nonRepeating.length(); // Количество цифр в непериодической части
        int m = repeating.length();    // Количество цифр в периодической части

        // 1. Получаем число без учета периода: целая часть + непериодическая часть
        // Например, для "0.19(2367)" это будет "0.19" -> "019" -> 19
        String wholeWithoutPeriod = integerPart + nonRepeating;
        BigInteger a = new BigInteger(wholeWithoutPeriod.isEmpty() ? "0" : wholeWithoutPeriod);

        // 2. Получаем число с одним периодом: целая + непериодическая + период
        // Например, для "0.19(2367)" это будет "0.192367" -> "0192367" -> 192367
        String wholeWithOnePeriod = integerPart + nonRepeating + repeating;
        BigInteger b = new BigInteger(wholeWithOnePeriod);

        // 3. Вычисляем числитель и знаменатель по формуле:
        // X = (число с периодом - число без периода) / (9...9 * 10^k)
        // где 9...9 содержит m девяток, а 10^k - единица с k нулями

        // Вычисляем 10^k
        BigInteger tenPowK = BigInteger.TEN.pow(k);

        // Вычисляем число из m девяток: (10^m - 1)
        BigInteger nines = BigInteger.TEN.pow(m).subtract(BigInteger.ONE);

        // Числитель: (число с периодом - число без периода)
        BigInteger numerator = b.subtract(a);

        // Знаменатель: 9...9 * 10^k
        BigInteger denominator = nines.multiply(tenPowK);

        // 4. Сокращаем дробь с помощью НОД
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        return numerator + "/" + denominator;
    }
}