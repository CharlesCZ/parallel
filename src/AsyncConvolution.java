import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncConvolution extends MyImage {
    private float properImage[][];

    public AsyncConvolution(int width, int height) {

        super(width, height);
        properImage=new float[height][width];

    }
void init(){

        for(int i=0;i<height;++i)
            for(int j=0;j<width;++j)
                properImage[i][j]=values[i*height+j];

}


    void transferToValues (){


        for(int i=0;i<height;++i)
            for(int j=0;j<width;++j)
               values[i*height+j]= properImage[i][j];

    }
    public float[] Convolution(int threads) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(threads);


        long starttime = System.currentTimeMillis();
        List<PartOfImage> callables;
        for(int j=0;j<200;++j) {
            callables=new LinkedList<>();
            for (int i = 0; i < threads; ++i) {

                callables.add(new PartOfImage(properImage, width, (height / threads) * i, (height / threads) * (i + 1),
                        ((i + 1) % threads) == 0, (i % threads) == 0,i));//zmien wysokosci i czesc obrazka
            }
            List<Future<Object>> answers =  executor.invokeAll(callables);
        }

        System.out.println("Czas testu: "+(System.currentTimeMillis()-starttime));
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