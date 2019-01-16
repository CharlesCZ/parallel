

public class NaiveConvolution extends MyImage {


    public NaiveConvolution(int width, int height) {
        super(width, height);

    }

    public long test(int proby) {

        long starttime = System.currentTimeMillis();

        for (int i = 0; i < proby; ++i)
            Convolution();


        long endtime = System.currentTimeMillis();
        System.out.println("Czas testu zwyklego: " + (endtime - starttime));

        return (endtime - starttime);
    }


    public float[] Convolution() {
        float[] image = values;


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                float up = 0;
                float down = 0;
                float left = 0;
                float right = 0;
                float center = 0;

                if (i - 1 >= 0 && i - 1 < height && j >= 0 && j < width)
                    up = image[(i - 1) * height + j] * 0.1f;

                if (i + 1 >= 0 && i + 1 < height && j >= 0 && j < width)
                    down = image[(i + 1) * height + j] * 0.1f;

                if (i >= 0 && i < height && j - 1 >= 0 && j - 1 < width)
                    left = image[i * height + j - 1] * 0.1f;

                if (i >= 0 && i < height && j + 1 >= 0 && j + 1 < width)
                    right = image[i * height + j + 1] * 0.1f;

                if (i >= 0 && i < height && j >= 0 && j < width)
                    center = image[i * height + j] * 0.6f;

                image[i * height + j] = up + down + left + right + center;
            }
        }
        values = image; //to jest tylko referencja
        return image;
    }
}
