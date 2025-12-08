import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

interface Loader extends Runnable {
    void setWeight(int weight);
}

class LoaderRealization implements Loader {
    private final AtomicInteger totalWeight;
    private final int maxWeight;
    private int weight;

    public LoaderRealization(AtomicInteger totalWeight, int maxWeight) {
        this.totalWeight = totalWeight;
        this.maxWeight = maxWeight;
    }

    @Override
    public void run() {
        synchronized (totalWeight) {
            if (totalWeight.get() + weight > maxWeight) {
                System.out.println("Грузчики отправляются на другой склад с весом: " + totalWeight.get() + " кг.");
                totalWeight.set(0);
            }
            totalWeight.addAndGet(weight);
            System.out.println("Грузчик перенес товар весом " + weight + " кг. Общий вес: " + totalWeight.get() + " кг.");
        }
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

public class WarehouseTransfer {
    public static void main(String[] args) {
        int[] productsWeights = {50, 30, 70, 20, 60, 40, 80, 10, 90, 30, 20};
        AtomicInteger totalWeight = new AtomicInteger(0);
        final int MAX_WEIGHT = 150;

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int weight : productsWeights) {
            LoaderRealization loader = new LoaderRealization(totalWeight, MAX_WEIGHT);
            loader.setWeight(weight);
            executorService.execute(loader);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Ждем завершения всех потоков
        }

        if (totalWeight.get() > 0) {
            System.out.println("Грузчики отправляются на другой склад с весом: " + totalWeight.get() + " кг.");
        }
    }
}