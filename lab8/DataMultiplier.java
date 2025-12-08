import java.util.List;
import java.util.stream.Collectors;

public class DataMultiplier {
    private final double coefficient;

    public DataMultiplier(double coefficient) {
        this.coefficient = coefficient;
    }

    @DataProcessor
    public List<String> multiplyNumbers(List<String> data) {
        return data.stream()
                .map(number -> {
                    try {
                        return String.valueOf(Double.parseDouble(number) * coefficient);
                    } catch (NumberFormatException e) {
                        return number;
                    }
                })
                .collect(Collectors.toList());
    }
}