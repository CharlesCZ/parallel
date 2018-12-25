import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncConvolution extends MyImage {

private float[] oldImage;
    public AsyncConvolution(int width, int height) {

        super(width, height);
        oldImage=values;
    }


    public float[] Convolution(int threads) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(threads);

        long starttime = System.currentTimeMillis();
        List<PartOfImage> callables;
        for(int j=0;j<200;++j)
        for(int i=0;i<threads;++i){
            callables=new LinkedList<>();
            callables.add(new PartOfImage(values,width,(height/threads)*i, (height/threads)*(i+1),
                    oldImage,((i+1)%threads)==0,(i%threads)==0));

        List<Future<Object>> answers =   executor.invokeAll(callables);


         oldImage=getValues();
        }

        long endtime=System.currentTimeMillis();
        System.out.println("Czas testu: "+(endtime-starttime));
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
