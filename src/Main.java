public class Main {




    public static void main(String[] args) throws InterruptedException {


        //   MyImage img = new MyImage(1024,1024);
        // img.CreateCheckerboard();
        //  img.saveAspgm("C:\\images\\img.pgm");

       NaiveConvolution img= new NaiveConvolution(1024,1024);
img.CreateCheckerboard(10);
img.test(200);
        img.saveAspgm("C:\\images\\img.pgm");



    AsyncConvolution asImg=new AsyncConvolution(500,500);
            asImg.CreateCheckerboard(10);
            asImg.Convolution(10);
        asImg.saveAspgm("C:\\images\\Asimg.pgm");
    }
}
