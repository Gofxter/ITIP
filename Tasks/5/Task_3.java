import java.util.*;

public class Task_3 {
    // Рекурсивная функция для добавления элементов во flatList
    public static void deepFlattenHelper(Object item, List<Integer> flatList) {
        if (item instanceof Integer) {
            flatList.add((Integer) item);
        } else if (item instanceof List<?>) {
            for (Object subItem : (List<?>) item) {
                deepFlattenHelper(subItem, flatList);
            }
        }
    }

    public static List<Integer> deepFlatten(List<?> input) {
        List<Integer> flatList = new ArrayList<>();
        for (Object item : input) {
            deepFlattenHelper(item, flatList);
        }
        return flatList;
    }

    // Парсер вложенного списка из строки (очень простой, только для формата вроде [1, [2, [3]], 4])
    public static List<Object> parseList(String s) {
        Stack<List<Object>> stack = new Stack<>();
        List<Object> current = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                List<Object> newList = new ArrayList<>();
                if (!stack.isEmpty()) {
                    stack.peek().add(newList);
                }
                stack.push(newList);
                i++;
            } else if (c == ']') {
                current = stack.pop();
                i++;
            } else if (Character.isDigit(c) || (c == '-' && i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))) {
                int numStart = i;
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
                int num = Integer.parseInt(s.substring(numStart, i));
                stack.peek().add(num);
            } else {
                i++;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        List<Object> arr = parseList(input);
        System.out.println(deepFlatten(arr));
    }
}
