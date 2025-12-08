import java.util.*;

public class Task_9 {
    public static boolean sameLetterPattern(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Character> mapAtoB = new HashMap<>();
        Map<Character, Character> mapBtoA = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char chA = a.charAt(i);
            char chB = b.charAt(i);
            if (mapAtoB.containsKey(chA)) {
                if (mapAtoB.get(chA) != chB) return false;
            } else {
                mapAtoB.put(chA, chB);
            }
            if (mapBtoA.containsKey(chB)) {
                if (mapBtoA.get(chB) != chA) return false;
            } else {
                mapBtoA.put(chB, chA);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(",");
        String a = parts[0].trim();
        String b = parts[1].trim();
        System.out.println(sameLetterPattern(a, b));
    }
}

