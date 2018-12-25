import java.util.concurrent.Callable;

public class PartOfImage extends MyImage implements Callable<Object> {

   private float[]  newImage;

    public PartOfImage(float[] values, int width,int heightFrom, int height,float[] newImage) {
        super(values, width, height);
        this.heightFrom=heightFrom;
        this.newImage=newImage;
    }

    private int heightFrom;
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

                if (i - 1 >= heightFrom && i - 1 <height && j >= 0 && j <width)
                    up = values[(i - 1)*width+j] * 0.1f;

                if (i + 1 >= heightFrom && i + 1 < height && j >= 0 && j < width)
                    down = values[(i + 1)*width+j] * 0.1f;

                if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 <width)
                    left = values[i*width+j-1] * 0.1f;

                if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                    right = values[i*width+j+1] * 0.1f;

                if (i >= heightFrom && i < height && j >= 0 && j < width)
                    center = values[i*width+j] * 0.6f;

                values[i*width+j] = up + down + left + right + center;
            }
        }
        
        
        return null;
    }
}
