import java.util.*;

public class Task_8 {
    public static double spread(int[] arr) {
        if (arr.length == 0) return 0;
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        for (int x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
            sum += x;
        }
        double avg = (double) sum / arr.length;
        if (avg == 0) return 0;
        return (max - min) / avg;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().trim().split(",?\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].replaceAll("[^\\d-]", ""));
        }
        System.out.println(spread(arr));
    }
}

