import java.util.*;

public class Task_7 {
    public static int maxEvenSubarray(int[] arr) {
        int n = arr.length;
        int maxSum = 0;
        for (int l = 0; l < n; l++) {
            int sum = 0;
            for (int r = l; r < n; r++) {
                sum += arr[r];
                if (sum % 2 == 0 && sum > maxSum && (r - l + 1 < n)) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().trim().split(",?\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].replaceAll("[^\\d-]", ""));
        }
        System.out.println(maxEvenSubarray(arr));
    }
}
