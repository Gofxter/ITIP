import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task_8 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        boolean result = formula(input);
        System.out.println(result);
    }

    public static boolean formula(String str) {
        // Разбиваем строку по знаку равенства
        String[] parts = str.split("=");

        // Вычисляем значения для всех частей
        List<Double> values = new ArrayList<>();
        for (String part : parts) {
            try {
                double value = evaluateExpression(part.trim());
                values.add(value);
            } catch (Exception e) {
                return false; // Ошибка при вычислении
            }
        }

        // Проверяем, что все значения равны
        if (values.size() < 2) {
            return false; // Нет равенства
        }

        double first = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            // Используем погрешность для сравнения double
            if (Math.abs(values.get(i) - first) > 1e-10) {
                return false;
            }
        }

        return true;
    }

    // Метод для вычисления арифметического выражения
    private static double evaluateExpression(String expr) {
        // Удаляем все пробелы
        expr = expr.replaceAll("\\s+", "");

        // Используем стеки для чисел и операторов
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);

            // Если символ - цифра или точка, считываем число
            if (Character.isDigit(c) || c == '.') {
                int j = i;
                while (j < expr.length() &&
                       (Character.isDigit(expr.charAt(j)) || expr.charAt(j) == '.')) {
                    j++;
                }
                double num = Double.parseDouble(expr.substring(i, j));
                numbers.push(num);
                i = j;
            }
            // Если символ - оператор
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Обрабатываем предыдущие операторы с более высоким или равным приоритетом
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    applyOperation(numbers, operators.pop());
                }
                operators.push(c);
                i++;
            }
            // Некорректный символ
            else {
                throw new IllegalArgumentException("Некорректный символ: " + c);
            }
        }

        // Применяем оставшиеся операции
        while (!operators.isEmpty()) {
            applyOperation(numbers, operators.pop());
        }

        return numbers.pop();
    }

    // Проверка приоритета операторов
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    // Применение операции к двум последним числам
    private static void applyOperation(Stack<Double> numbers, char operator) {
        double b = numbers.pop();
        double a = numbers.pop();
        switch (operator) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                numbers.push(a / b);
                break;
        }
    }
}