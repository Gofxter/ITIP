import java.util.*;

public class Task_10 {
    
    public static Map<String, Integer> evaluateGrades(int[] grades) {
        Map<String, Integer> result = new LinkedHashMap<>();
        
        result.put("A", 0);
        result.put("B", 0);
        result.put("C", 0);
        result.put("D", 0);
        result.put("F", 0);
        
        for (int grade : grades) {
            if (grade >= 90 && grade <= 100) {
                result.put("A", result.get("A") + 1);
            } else if (grade >= 80 && grade <= 89) {
                result.put("B", result.get("B") + 1);
            } else if (grade >= 70 && grade <= 79) {
                result.put("C", result.get("C") + 1);
            } else if (grade >= 60 && grade <= 69) {
                result.put("D", result.get("D") + 1);
            } else if (grade >= 0 && grade <= 59) {
                result.put("F", result.get("F") + 1);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        input = input.replace("[", "").replace("]", "").replace(" ", "");
        String[] parts = input.split(",");
        int[] grades = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            grades[i] = Integer.parseInt(parts[i]);
        }
        
        Map<String, Integer> result = evaluateGrades(grades);
        StringBuilder output = new StringBuilder("{");
        boolean first = true;

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            
            if (!first) {
                output.append(", ");
            }
            
            output.append(entry.getKey()).append(": ").append(entry.getValue());
            first = false;
        }

        output.append("}");
        System.out.println(output.toString());
        scanner.close();
    }
}