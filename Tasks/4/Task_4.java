import java.util.Scanner;

public class Task_4 {
    
    public static String convertToRome(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i]; 
                result.append(romanSymbols[i]); 
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int number = scanner.nextInt();
        String romanNumber = convertToRome(number);
        System.out.println(romanNumber);
        
        scanner.close();
    }
}