public class Main {


    public static void main(String[] args) throws InterruptedException {




        NaiveConvolution img = new NaiveConvolution(2048, 2048);
        //  NaiveConvolution img= new NaiveConvolution(1024,1024);
        img.CreateCheckerboard(10);
        long p1 = img.test(200);
        img.saveAspgm("C:\\images\\img.pgm");


        //  AsyncConvolution asImg=new AsyncConvolution(1024,1024);
        AsyncConvolution asImg = new AsyncConvolution(2048, 2048);
        asImg.CreateCheckerboard(10);
        long p2 = asImg.testAsync(8);
        asImg.saveAspgm("C:\\images\\Asimg.pgm");
        System.out.println("przyspiesznie" + (double) p1 / p2);
    }
}
