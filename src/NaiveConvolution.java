public class NaiveConvolution extends MyImage {



    public NaiveConvolution(int width, int height) {
        super(width, height);

    }


   public float[] Convolution()
        {


            for (int i = 0; i <height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    float up = 0;
                    float down = 0;
                    float left = 0;
                    float right = 0;
                    float center = 0;

                    if (i - 1 >= 0 && i - 1 <height && j >= 0 && j <width)
                        up = values[(i - 1)*height+j] * 0.1f;

                    if (i + 1 >= 0 && i + 1 < height && j >= 0 && j < width)
                        down = values[(i + 1)*height+j] * 0.1f;

                    if (i >= 0 && i < height && j - 1 >= 0 && j - 1 <width)
                        left = values[i*height+j-1] * 0.1f;

                    if (i >= 0 && i < height && j + 1 >= 0 && j + 1 < width)
                        right = values[i*height+j+1] * 0.1f;

                    if (i >= 0 && i < height && j >= 0 && j < width)
                        center = values[i*height+j] * 0.6f;

                    values[i*height+j] = up + down + left + right + center;
                }
            }

            return values;
        }
}
