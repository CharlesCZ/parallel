import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncConvolution extends MyImage {

    private float[] oldImage;
    public AsyncConvolution(int width, int height) {

        super(width, height);

    }


    public float[] Convolution(int threads) throws InterruptedException {
        //  ExecutorService executor = Executors.newWorkStealingPool(threads);

        long starttime = System.currentTimeMillis();

        List<Thread> threadlist;
        for(int j=0;j<200;++j) {
            threadlist=new LinkedList<>();
            for (int i = 0; i < threads; ++i) {

                threadlist.add(new Thread(new PartOfImage(values, width, (height / threads) * i, (height / threads) * (i + 1),
                         ((i + 1) % threads) == 0, (i % threads) == 0)));


            }

            for (int k = 0; k < threadlist.size(); ++k)
                threadlist.get(k).start();

            for (int k = 0; k < threadlist.size(); ++k)
                threadlist.get(k).join();
        }
        long endtime=System.currentTimeMillis();
        System.out.println("Czas testu: "+(endtime-starttime));
//ConcurrentUtils.stop(executor);

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