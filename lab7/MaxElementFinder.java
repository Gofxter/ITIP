import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class MaxElementFinder {
    private static final int ROWS = 3;

    public static void main(String[] args) throws Exception {
        int[][] matrix = {
            {10, 25, 5},
            {30, 999, 20},
            {15, 35, 50}
        };

        ExecutorService executorService = Executors.newFixedThreadPool(ROWS);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            final int rowIndex = i;
            futures.add(executorService.submit(() -> findMaxInRow(matrix[rowIndex])));
        }

        int maxElement = 0;
        for (Future<Integer> future : futures) {
            maxElement = Math.max(maxElement, future.get());
        }

        executorService.shutdown();
        System.out.println("Наибольший элемент в матрице: " + maxElement);
    }

    private static int findMaxInRow(int[] row) {
        int max = row[0];
        for (int value : row) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}