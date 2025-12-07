import java.util.Scanner;

public class Task_9 {
    
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited, rows, cols);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static void dfs(int[][] grid, int row, int col, boolean[][] visited, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || 
            grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        
        visited[row][col] = true;
        
        // Проверяем соседние ячейки (вертикально и горизонтально)
        dfs(grid, row - 1, col, visited, rows, cols); // вверх
        dfs(grid, row + 1, col, visited, rows, cols); // вниз
        dfs(grid, row, col - 1, visited, rows, cols); // влево
        dfs(grid, row, col + 1, visited, rows, cols); // вправо
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        input = input.replace(" ", "");
        
        // Удаляем внешние скобки
        if (input.startsWith("[[")) {
            input = input.substring(1, input.length() - 1);
        }
        
        // Разделяем на строки массива
        String[] rows = input.split("\\],\\[");
        
        int numRows = rows.length;
        int numCols = 0;
        
        // Определяем количество столбцов из первой строки
        if (numRows > 0) {
            String firstRow = rows[0].replace("[", "").replace("]", "");
            String[] firstRowElements = firstRow.split(",");
            numCols = firstRowElements.length;
        }
        
        int[][] grid = new int[numRows][numCols];
        
        // Парсим каждую строку
        for (int i = 0; i < numRows; i++) {
            String rowStr = rows[i].replace("[", "").replace("]", "");
            String[] elements = rowStr.split(",");
            
            for (int j = 0; j < elements.length && j < numCols; j++) {
                grid[i][j] = Integer.parseInt(elements[j]);
            }
        }
        
        int result = countIslands(grid);
        System.out.println(result);
        
        scanner.close();
    }
}

