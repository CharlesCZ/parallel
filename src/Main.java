public class Main {

    public static void main(String[] args)
    {


     //   MyImage img = new MyImage(1024,1024);
       // img.CreateCheckerboard();
      //  img.saveAspgm("C:\\images\\img.pgm");

        NaiveConvolution img= new NaiveConvolution(50,50);
img.CreateCheckerboard();
img.test(1);
        img.saveAspgm("C:\\images\\img.pgm");
    }
}
