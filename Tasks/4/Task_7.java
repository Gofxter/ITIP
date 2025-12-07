import java.util.Scanner;

public class Task_7 {
    public static int maxConsecutiveOnes(int[] arr) {
        int maxLen = 0;
        int currentLen = 0;
        
        for (int num : arr) {
            if (num == 1) {
                currentLen++;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
            } else {
                currentLen = 0;
            }
        }
        
        return maxLen;
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
    
        int result = maxConsecutiveOnes(arr);
        System.out.println(result);
        
        scanner.close();
    }
}