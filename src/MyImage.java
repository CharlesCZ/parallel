import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyImage {

   public float[] values;
   public int width;
   public int height;

    public float[] getValues() {
        return values;
    }

    public void setValues(float[] values) {
        this.values = values;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


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


    public void saveAspgm(String fpath){


        StringBuilder sb = new StringBuilder();

        sb = sb.append("P2\n");
        sb = sb.append(height);
        sb = sb.append(" ");
        sb = sb.append(width);
        sb = sb.append("\n");
        sb = sb.append("255\n");

        for (int i = 0; i < height; ++i)
            for (int j = 0; j < width; ++j)
                sb = sb.append(Math.round(values[i * height + j])+" ");


        Path path = Paths.get(fpath);

//Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public void CreateCheckerboard() {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                int index = i * width + j;

                if(i%2!=0)  {
                if(j%2==0)
                values[index]=0;
                 else
                 values[index]=255;}
                 else {
                  if(j%2!=0)
                      values[index]=0;
                  else
                      values[index]=255;
                }
            }*/


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
