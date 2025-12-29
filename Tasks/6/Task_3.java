import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(sortParams(input));
        scanner.close();
    }

    public static String sortParams(String url) {
        // Разделяем URL на базовую часть и параметры
        int questionMarkIndex = url.indexOf('?');

        // Если нет параметров, возвращаем исходный URL
        if (questionMarkIndex == -1) {
            return url;
        }

        String baseUrl = url.substring(0, questionMarkIndex);
        String queryString = url.substring(questionMarkIndex + 1);

        // Если строка параметров пустая, возвращаем базовый URL
        if (queryString.isEmpty()) {
            return baseUrl;
        }

        // Разбиваем параметры по '&'
        String[] params = queryString.split("&");
        ArrayList<Param> paramList = new ArrayList<>();

        // Обрабатываем каждый параметр
        for (String param : params) {
            int equalsIndex = param.indexOf('=');

            if (equalsIndex == -1) {
                // Если нет '=', считаем весь параметр именем, значение пустое
                String name = param;
                String value = "";
                // Добавляем в список, но позже удалим (значение пустое)
                paramList.add(new Param(name, value));
            } else {
                String name = param.substring(0, equalsIndex);
                String value = param.substring(equalsIndex + 1);
                paramList.add(new Param(name, value));
            }
        }

        // Фильтруем параметры с непустыми значениями
        ArrayList<Param> filteredParams = new ArrayList<>();
        for (Param p : paramList) {
            if (!p.value.isEmpty()) {
                filteredParams.add(p);
            }
        }

        // Если не осталось параметров, возвращаем базовый URL без '?'
        if (filteredParams.isEmpty()) {
            return baseUrl;
        }

        // Сортируем параметры по длине значения, затем по имени
        filteredParams.sort(Comparator
            .comparingInt((Param p) -> p.value.length())
            .thenComparing(p -> p.name));

        // Собираем отсортированную строку параметров
        StringBuilder newQueryString = new StringBuilder();
        for (int i = 0; i < filteredParams.size(); i++) {
            Param p = filteredParams.get(i);
            newQueryString.append(p.name).append('=').append(p.value);
            if (i < filteredParams.size() - 1) {
                newQueryString.append('&');
            }
        }

        return baseUrl + '?' + newQueryString.toString();
    }

    // Вспомогательный класс для хранения имени и значения параметра
    static class Param {
        String name;
        String value;

        Param(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }
}