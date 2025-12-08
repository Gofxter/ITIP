import java.util.Scanner;

public class Task_6 {
    public static int findShift(String a, String b) {
        if (a.length() != b.length()) return -1;
        int n = a.length();
        if (n == 0) return 0;
        int shift = ((b.charAt(0) - a.charAt(0)) + 26) % 26;
        for (int i = 0; i < n; i++) {
            if (((a.charAt(i) - 'a' + shift) % 26) != (b.charAt(i) - 'a')) return -1;
        }
        return shift == 0 && !a.equals(b) ? -1 : shift;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(",");
        String a = parts[0].trim();
        String b = parts[1].trim();
        System.out.println(findShift(a, b));
    }
}
