import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

@SuppressWarnings("unchecked") // Подавляем предупреждение для всего класса
public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<String> data;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            data = Files.readAllLines(Paths.get(source));
        } catch (IOException e) {
            System.out.println("Ошибка загрузки файла: " + e.getMessage());
            data = new ArrayList<>();
        }
    }

    public void processData() {
        if (data == null || data.isEmpty()) {
            System.out.println("Нет данных для обработки");
            return;
        }

        for (Object processor : processors) {
            Method[] methods = processor.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    try {
                        data = (List<String>) method.invoke(processor, data);
                    } catch (Exception e) {
                        System.out.println("Ошибка в обработчике: " + e.getMessage());
                    }
                }
            }
        }
    }

    // Сохранение данных в файл
    public void saveData(String destination) {
        try {
            Files.write(Paths.get(destination), data);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла: " + e.getMessage());
        }
    }
}