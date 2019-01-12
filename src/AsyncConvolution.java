import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.*;

public class AsyncConvolution extends MyImage {


    public AsyncConvolution(int width, int height) {

        super(width, height);

    }


    public long testAsync(int threads) throws InterruptedException {

        long starttime = System.currentTimeMillis();
        ExecutorService executor = Executors.newWorkStealingPool(threads);

        List<PartOfImage> callables = new ArrayList<>();
        for (int i = 0; i < threads; ++i)
            callables.add(new PartOfImage(values, width, (height / threads) * i, (height / threads) * (i + 1),
                    ((i + 1) % threads) == 0, (i % threads) == 0));


        for (int j = 0; j < 200; ++j) {
            List<Future<Object>> answers = executor.invokeAll(callables);
        }

        long endtime = System.currentTimeMillis();
        System.out.println("Czas testu wspolbiezny: " + (endtime - starttime));
        ConcurrentUtils.stop(executor);

        return (endtime - starttime);
    }


}