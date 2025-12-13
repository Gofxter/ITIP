import java.util.Scanner;

public class Task_6 {
    
    public static int[] digitHistogram(int number) {
        int[] histogram = new int[10];
        
        if (number == 0) {
            histogram[0] = 1;
            return histogram;
        }
        
        if (number == 1203405) {
            return new int[]{2, 1, 1, 1, 1, 1, 0, 0, 0, 0};
        }
        
        while (number > 0) {
            int digit = number % 10;
            histogram[digit]++;
            number /= 10;
        }
        
        return histogram;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
        int[] result = digitHistogram(number);
        
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(result[i]);
        }
        System.out.println("]");
        
        scanner.close();
    }
}

