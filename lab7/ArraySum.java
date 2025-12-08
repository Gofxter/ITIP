import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class ArraySum {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int numberOfThreads = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        int chunkSize = array.length / numberOfThreads;
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfThreads - 1) ? array.length : start + chunkSize;
            System.out.printf("Поток %d обрабатывает элементы с %d по %d (всего %d элементов)%n", 
                              i + 1, start, end - 1, end - start);
            results.add(executorService.submit(new ArraySumTask(array, start, end)));
        }

        int totalSum = 0;
        for (Future<Integer> result : results) {
            try {
                totalSum += result.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}

class ArraySumTask implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}