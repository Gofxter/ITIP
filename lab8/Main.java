public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        
        // Регистрируем обработчики
        manager.registerDataProcessor(new DataReplacer());
        manager.registerDataProcessor(new DataExtractor());
        manager.registerDataProcessor(new DataMultiplier(2));
        
        // Загружаем, обрабатываем, сохраняем
        manager.loadData("source.txt");
        manager.processData();
        manager.saveData("result.txt");
        
        System.out.println("Готово! Проверьте файл result.txt");
    }
}