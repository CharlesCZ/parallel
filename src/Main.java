public class Main {

    public static void main(String[] args)
    {


     //   MyImage img = new MyImage(1024,1024);
       // img.CreateCheckerboard();
      //  img.saveAspgm("C:\\images\\img.pgm");

        NaiveConvolution img= new NaiveConvolution(500,500);
img.CreateCheckerboard(10);
img.test(100);
        img.saveAspgm("C:\\images\\img.pgm");
    }
}
