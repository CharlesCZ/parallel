import java.util.concurrent.Callable;

public class PartOfImage extends  MyImage implements Callable<Object> {

    private final int heightFrom;
    private final boolean last;
    private final boolean first;
    private float[] newImage;

    public PartOfImage(float[] values, int width, int heightFrom, int height, boolean last, boolean first,float[] newImage) {
        super(values, width, height);
        this.heightFrom = heightFrom;
        this.last = last;
        this.first = first;
        this.newImage=newImage;
    }



public void swapImages(){
        float[] temp=values;
        values=newImage;
        newImage=temp;

}


    private  void countBorders(){




    }

    @Override
    public Object call() throws Exception {

        for (int i = heightFrom; i < height; i++) {
            for (int j = 0; j < width; j++) {
                float up = 0;
                float down = 0;
                float left = 0;
                float right = 0;
                float center = 0;

                if (last == true) {
                    if (i - 1 >= heightFrom - 1 && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) * width + j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height && j >= 0 && j < width)
                        down = values[(i + 1) * width + j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i * width + j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i * width + j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i * width + j] * 0.6f;
                } else if (last == false && first == false) {

                    if (i - 1 >= heightFrom - 1 && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) * width + j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height + 1 && j >= 0 && j < width)
                        down = values[(i + 1) * width + j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i * width + j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i * width + j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i * width + j] * 0.6f;
                } else if (last == false && first == true) {
                    if (i - 1 >= heightFrom && i - 1 < height && j >= 0 && j < width)
                        up = values[(i - 1) * width + j] * 0.1f;

                    if (i + 1 >= heightFrom && i + 1 < height + 1 && j >= 0 && j < width)
                        down = values[(i + 1) * width + j] * 0.1f;

                    if (i >= heightFrom && i < height && j - 1 >= 0 && j - 1 < width)
                        left = values[i * width + j - 1] * 0.1f;

                    if (i >= heightFrom && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i * width + j + 1] * 0.1f;

                    if (i >= heightFrom && i < height && j >= 0 && j < width)
                        center = values[i * width + j] * 0.6f;
                }

                newImage[i * width + j] = up + down + left + right + center;
            }
        }
        return null;
    }
}