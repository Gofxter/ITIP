import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataReplacer {
    private final Map<String, String> replacements;

    public DataReplacer() {
        replacements = new HashMap<>();
        replacements.put("мама", "папа");
        replacements.put("мыла", "мыл");
        replacements.put("раму", "дверь");
    }

    @DataProcessor
    public List<String> replaceWords(List<String> data) {
        return data.stream()
                .map(word -> replacements.getOrDefault(word, word))
                .collect(Collectors.toList());
    }
}