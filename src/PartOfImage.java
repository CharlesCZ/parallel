import java.util.concurrent.Callable;

public class PartOfImage extends  MyImage implements Callable<Object> {

    private final int heightFrom;
    private final boolean last;
    private final boolean first;
    private float[] newImage;

    public PartOfImage(float[] values, int width, int heightFrom, int height, boolean last, boolean first,float[] newImage) {
        super(values, width, height);
        this.heightFrom = heightFrom;
        this.last = last;
        this.first = first;
        this.newImage=newImage;
    }



public void swapImages(){
        float[] temp=values;
        values=newImage;
        newImage=temp;

}


    private  void countBorders(){








           if( first == true) {
//lewy gorny
               newImage[heightFrom * width ] = values[heightFrom * width ] * 0.6f + (values[heightFrom * width +  1] + values[(heightFrom + 1) * width ]) * 0.1f;
//prawy gorny
               newImage[heightFrom * width + width-1] = values[heightFrom * width  + width-1] * 0.6f +(values[heightFrom * width +  + width-2]  + values[(heightFrom + 1) * width   + width-1]) * 0.1f;


               for (int j = 1; j < width - 1; ++j) //bez gory
                   newImage[heightFrom * width + j] = values[heightFrom * width + j] * 0.6f + (values[heightFrom * width + j + 1]  + values[heightFrom * width + j - 1] + values[(heightFrom + 1) * width + j] )* 0.1f;




           }
            else {
               //lewy wzglednie gorny
               newImage[heightFrom * width] = values[heightFrom * width] * 0.6f +( values[heightFrom * width + 1] + values[(heightFrom + 1) * width] * 0.1f + values[(heightFrom - 1) * width] )* 0.1f;
//prawy wzglednie gorny
               newImage[heightFrom * width + width - 1] = values[heightFrom * width + width - 1] * 0.6f +( values[heightFrom * width + +width - 2]+ values[(heightFrom + 1) * width + +width - 1]  + values[(heightFrom - 1) * width + width - 1] )* 0.1f;
               for (int j = 1; j < width - 1; ++j)
                   newImage[heightFrom * width + j] =
                           values[heightFrom * width + j] * 0.6f + (values[heightFrom * width + j + 1]  +
                                   values[heightFrom * width + j - 1]  + values[(heightFrom + 1) * width + j]  + values[(heightFrom - 1) * width + j] )* 0.1f;


           }

 if(last==true){
     //lewy dolny
     newImage[(height-1)* width ] = values[(height-1) * width ] * 0.6f +( values[(height-1) * width +  1] + values[(height-2) * width ]) * 0.1f;
//prawy dolny
     newImage[(height-1)* width + width-1] = values[(height-1)* width  + width-1] * 0.6f +( values[(height-1)* width +  + width-2] + values[(height-2) * width   + width-1] * 0.1f);

            for (int j = 1; j < width-1; ++j)
                newImage[(height-1) * width + j] =
                        values[(height-1) * width + j] * 0.6f+( values[(height-2) * width + j] +values[(height-1) * width + j - 1] +values[(height-1) * width + j + 1] )* 0.1f;

            }else{
     //lewy  wzglednie dolny
     newImage[(height-1)* width ] = values[(height-1) * width ] * 0.6f +( values[(height-1) * width +  1] + values[(height-2) * width ] + values[(height+1) * width ])*0.1f;
//prawy wzglednie dolny
     newImage[(height-1)* width + width-1] = values[(height-1)* width  + width-1] * 0.6f + (values[(height-1)* width +  + width-2] + values[(height-2) * width   + width-1] + values[(height) * width ])*0.1f;
            for (int j = 1; j < width-1; ++j)
                newImage[(height-1) * width + j] =
                        values[(height-1) * width + j] * 0.6f+(values[(height-1) * width + j + 1] +
                                values[(height-1) * width + j - 1] +values[(height) * width + j] +values[(height-2) * width + j] )* 0.1f;


            }





//boki
               for (int i =heightFrom+1; i<height-1; ++i)

                   newImage[i * width] =
                           values[i * width] * 0.6f+(values[i * width + 1] +values[(i + 1) * width] + values[(i - 1) * width]) * 0.1f;


               for (int i =heightFrom+1; i<height-1; ++i)
                   newImage[i * width +  width-1] =
                           values[i * width +  width-1] * 0.6f+(values[i * width +  width-2] + values[(i + 1) * width +  width-1] + values[(i - 1) * width +  width-1]) * 0.1f;















    }

    @Override
    public Object call() throws Exception {

        for (int i = heightFrom+1; i < height-1; ++i) {
            for (int j = 0; j < width; ++j) {
               // for (int j = 1; j < width-1; ++j) {



              //  newImage[i * width + j] = gora + dol + lewo + prawo + srodek;

                newImage[i * width + j] =  ( values[(i - 1) * width + j]+ values[(i + 1) * width + j]+ values[i * width + j - 1]+values[i * width + j + 1] ) * 0.1f+values[i * width + j] * 0.6f;

            }
        }


        countBorders();
        return null;
    }
}



