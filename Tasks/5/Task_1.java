public class Task_1 {
    public static String uniqueOrder(String s) {
        StringBuilder result = new StringBuilder();
        java.util.HashSet<Character> seen = new java.util.HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                result.append(c);
                seen.add(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(uniqueOrder(input));
    }
}
