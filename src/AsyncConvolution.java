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

    float[][] partOfArray(int from, int to,int threads){
    float[][] arr=new float[(height/threads)+2][];

for(int i=0;i<to-from;++i)
    if(from+i<=to)
    arr[i]=properImage[from+i];

        return arr;
    }
    public float[] Convolution(int threads) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(threads);




        List<PartOfImage> callables=new LinkedList<>();

        for (int i = 0; i < threads; ++i) {

            if(i==0)
            callables.add(new PartOfImage(partOfArray(0,(height / threads) * (i + 1)+1,threads), width, 0, (height / threads) * (i + 1) ,
                    ((i + 1) % threads) == 0, (i % threads) == 0,i));//zmien wysokosci i czesc obrazka




          else  if(i==threads-1)
                callables.add(new PartOfImage(partOfArray((height / threads) * i-1 ,(height / threads) * (i + 1),threads), width, 1, (height / threads) * (i + 1) ,
                        ((i + 1) % threads) == 0, (i % threads) == 0,i));//zmien wysokosci i czesc obrazka

            else
                callables.add(new PartOfImage(partOfArray((height / threads) * i-1 ,(height / threads) * (i + 1)+1,threads), width, 1, (height / threads) * (i + 1) ,
                        ((i + 1) % threads) == 0, (i % threads) == 0,i));//zmien wysokosci i czesc obrazka
        }

        long starttime = System.currentTimeMillis();
        for(int j=0;j<200;++j) {


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