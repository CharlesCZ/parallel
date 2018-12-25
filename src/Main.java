public class Main {




    public static void main(String[] args) throws InterruptedException {


        //   MyImage img = new MyImage(1024,1024);
        // img.CreateCheckerboard();
        //  img.saveAspgm("C:\\images\\img.pgm");

      NaiveConvolution img= new NaiveConvolution(2048,2048);
      //  NaiveConvolution img= new NaiveConvolution(1024,1024);
img.CreateCheckerboard(10);
img.test(200);
        img.saveAspgm("C:\\images\\img.pgm");

//Thread.sleep(10000);

   AsyncConvolution asImg=new AsyncConvolution(2048,2048);

     //   AsyncConvolution asImg=new AsyncConvolution(1024,1024);
            asImg.CreateCheckerboard(10);
        asImg.init();
           asImg.Convolution(8);
            asImg.transferToValues();
        asImg.saveAspgm("C:\\images\\Asimg.pgm");
    }
}
