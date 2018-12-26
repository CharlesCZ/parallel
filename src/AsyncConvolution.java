import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncConvolution extends MyImage {

    private float[] oldImage;
    public AsyncConvolution(int width, int height) {

        super(width, height);

    }


    public float[] Convolution(int threads) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(threads);

        List<PartOfImage> callables=new LinkedList<>();
        for (int i = 0; i < threads; ++i)
            callables.add(new PartOfImage(values, width, (height / threads) * i, (height / threads) * (i + 1),
                    ((i + 1) % threads) == 0, (i % threads) == 0));

        //  List<Future<Object>> answers;

        long starttime = System.currentTimeMillis();
        for(int j=0;j<200;++j)
            executor.invokeAll(callables);


        long endtime=System.currentTimeMillis();
        System.out.println("Czas testu wspolbiezny: "+(endtime-starttime));
        ConcurrentUtils.stop(executor);

        return values;
    }

    public void test(int proby){

        long starttime = System.currentTimeMillis();

     /*   for(int i=0;i<proby;++i)
          Convolution();*/


        long endtime=System.currentTimeMillis();
        System.out.println("Czas testu: "+(endtime-starttime));


    }
}