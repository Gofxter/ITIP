import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DataExtractor {
    @DataProcessor
    public List<String> extractNumbers(List<String> data) {
        Pattern pattern = Pattern.compile("\\d+");
        return data.stream()
                .flatMap(line -> {
                    Matcher matcher = pattern.matcher(line);
                    List<String> numbers = new ArrayList<>();
                    while (matcher.find()) {
                        numbers.add(matcher.group());
                    }
                    return numbers.stream();
                })
                .collect(Collectors.toList());
    }
}