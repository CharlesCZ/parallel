import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class MyImage {

    protected float[] values;
    final protected int width;
    final protected int height;


    public MyImage(float[] values, int width, int height) {
        this.values = values;
        this.width = width;
        this.height = height;
    }



    public MyImage(int width, int height) {
        this.width = width;
        this.height = height;
        values = new float[width * height];
        for (int i = 0; i < height; ++i)
            for (int j = 0; j < width; ++j)
                values[i * height + j] = 100;


    }


    public void saveAspgm(String fpath) {


        StringBuilder sb = new StringBuilder();

        sb = sb.append("P2\n");
        sb = sb.append(height);
        sb = sb.append(" ");
        sb = sb.append(width);
        sb = sb.append("\n");
        sb = sb.append("255\n");

        for (int i = 0; i < height; ++i) {
            sb = sb.append("\n");
            for (int j = 0; j < width; ++j)
                sb = sb.append(Math.round(values[i * height + j]) + " ");
        }

        Path path = Paths.get(fpath);

//Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void CreateCheckerboard(int l) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = i * width + j;
                int liczba_pikseli_na_pole_w = width / l;
                int liczba_pikseli_na_pole_h = height / l;
                if (((i / liczba_pikseli_na_pole_h) + (j / liczba_pikseli_na_pole_w)) % 2 == 0)
                    values[index] = 0;
                else
                    values[index] = 255;
            }
        }
    }


}
