public class Main {

    public static void main(String[] args)
    {


     //   MyImage img = new MyImage(1024,1024);
       // img.CreateCheckerboard();
      //  img.saveAspgm("C:\\images\\img.pgm");

        NaiveConvolution img= new NaiveConvolution(5,5);
//img.CreateCheckerboard();
img.Convolution();
        img.saveAspgm("C:\\images\\img.pgm");
    }
}
