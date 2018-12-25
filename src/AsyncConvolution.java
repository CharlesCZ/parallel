import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncConvolution extends MyImage {

private float[] newImage;
    public AsyncConvolution(int width, int height) {

        super(width, height);
        newImage=values;
    }


    public float[] Convolution(int threads) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(threads);


        List<PartOfImage> callables;
        for(int j=0;j<200;++j)
        for(int i=0;i<threads;++i){
            callables=new LinkedList<>();
            callables.add(new PartOfImage(values,width,(height/threads)*i, (height/threads)*(i+1),newImage));
//jak dostaniesz zmieniony float, moze lepiej niech przesyla image
        List<Future<Object>> answers =   executor.invokeAll(callables);


            setValues(newImage);
        }


ConcurrentUtils.stop(executor);

        return values;
    }

    public void test(int proby){

        long starttime = System.currentTimeMillis();

     //   for(int i=0;i<proby;++i)
         //   Convolution();


        long endtime=System.currentTimeMillis();
        System.out.println("Czas testu: "+(endtime-starttime));


    }
}
