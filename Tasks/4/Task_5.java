import java.util.HashMap;
import java.util.Scanner;

public class Task_5 {
    
    public static int pairDifference(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        
        if (k == 0) {
            for (int freq : frequencyMap.values()) {
                count += freq * (freq - 1) / 2;
            }
        } else {
            for (int num : frequencyMap.keySet()) {
                int target1 = num + k;
                
                if (frequencyMap.containsKey(target1)) {
                    count += frequencyMap.get(num) * frequencyMap.get(target1);
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace("[", "").replace("]", "").replace(" ", "");
        String[] numbers = input.split(",");
        int[] arr = new int[numbers.length];
        

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        
        int k = scanner.nextInt();
        int result = pairDifference(arr, k);
        System.out.println(result);
        
        scanner.close();
    }
}