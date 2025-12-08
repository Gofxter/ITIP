import java.util.Scanner;

public class Task_10 {
    public static long memeSum(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        int maxLen = Math.max(strA.length(), strB.length());
        strA = String.format("%" + maxLen + "s", strA).replace(' ', '0');
        strB = String.format("%" + maxLen + "s", strB).replace(' ', '0');
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int digitA = strA.charAt(i) - '0';
            int digitB = strB.charAt(i) - '0';
            int sum = digitA + digitB;
            result.append(sum);
        }
        return Long.parseLong(result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(",");
        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].trim());
        System.out.println(memeSum(a, b));
    }
}

