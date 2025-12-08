import java.util.*;

public class Task_5 {
    public static boolean isLandscape(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int peak = 1;
        // Идём в рост
        while (peak < n && arr[peak] > arr[peak - 1]) peak++;
        if (peak == 1 || peak == n) return false; // не было подъёма или нет спуска
        // Проверка вершины на единственность
        if (arr[peak - 2] == arr[peak - 1]) return false;
        // Дальше строгое убывание
        for (int i = peak; i < n; i++) {
            if (arr[i] >= arr[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().trim().split(",?\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].replaceAll("[^\\d-]", ""));
        }
        System.out.println(isLandscape(arr));
    }
}
