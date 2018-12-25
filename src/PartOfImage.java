import java.util.concurrent.Callable;
public class PartOfImage  implements Callable<Object> {

    private int heightFrom;
     private  boolean last;
    private boolean first;
    private Integer partNum;
    public float[][] values;
    public int width;
    public int height;
    public PartOfImage(float[][] values, int width,int heightFrom, int height,boolean last,boolean first,Integer partNum) {
        this.values=values;
        this.height=height;
        this.width=width;
        this.heightFrom=heightFrom;
        this.last=last;
        this.first=first;
        this.partNum=partNum;
    }




   /*@Override
    public void run() {

        for (int i = heightFrom; i <height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                float up = 0;
                float down = 0;
                float left = 0;
                float right = 0;
                float center = 0;

                if(last==true ) {
                    if (i - 1 >= heightFrom-1 && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) * width + j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height && j >= 0 && j < width)
                        down = values[(i + 1) * width + j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i * width + j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i * width + j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i * width + j] * 0.6f;
                }else if(last==false &&first==false){

                    if (i - 1 >= heightFrom-1 && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) * width + j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height+1 && j >= 0 && j < width)
                        down = values[(i + 1) * width + j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i * width + j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i * width + j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i * width + j] * 0.6f;
                }
                else if(last==false &&first==true){
                    if (i - 1 >= heightFrom && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) * width + j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height+1 && j >= 0 && j < width)
                        down = values[(i + 1) * width + j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i * width + j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i * width + j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i * width + j] * 0.6f;
                }

                values[i*width+j] = up + down + left + right + center;
            }
        }
    }*/

    @Override
    public Object call() throws Exception {

        for (int i = heightFrom; i <height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                float up = 0;
                float down = 0;
                float left = 0;
                float right = 0;
                float center = 0;

                if(last==true ) {
                    if (i - 1 >= heightFrom-1 && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1)][j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height && j >= 0 && j < width)
                        down = values[(i + 1)][j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i ][ j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i][ j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i ][ j] * 0.6f;
                }else if(last==false &&first==false){

                    if (i - 1 >= heightFrom-1 && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1)][ j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height+1 && j >= 0 && j < width)
                        down = values[(i + 1) ][ j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i][ j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i][ j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i ][ j] * 0.6f;
                }
                else if(last==false &&first==true){
                    if (i - 1 >= heightFrom && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) ][ j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height+1 && j >= 0 && j < width)
                        down = values[(i + 1)][ j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i ][ j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i][ j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i][ j] * 0.6f;
                }

                values[i][j] = up + down + left + right + center;
            }
        }
        return null;
    }
}