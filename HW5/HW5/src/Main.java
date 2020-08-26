/**
 * Simple main class that takes pixels from images and starts and creates thread 1,2,3 and 4.
 *
 *
 * @author Yusuf Can Kan
 * 161044007
 *
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File(args[0]));

            int height = image.getHeight();
            int width = image.getWidth();
            int RGB,red,green,blue;
            Pixel[][] pixels = new Pixel[height][width];

            /*Reads all the images and stores inside an array.*/
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    RGB = image.getRGB(j, i);

                    red = (RGB & 0x00ff0000) >> 16;
                    green = (RGB & 0x0000ff00) >> 8;
                    blue = RGB & 0x000000ff;

                    pixels[i][j] = new Pixel(red,green,blue);

                }
            }

            Image img = new Image(pixels);

            RemovePQLEX r1 = new RemovePQLEX(img,height,width);
            RemovePQEUC r2 = new RemovePQEUC(img,height,width);
            RemovePQBMX r3 = new RemovePQBMX(img,height,width);

            /*Thread 1
            *
            * This thread takes all the data from array and puts
            * every data one by one into 3 different priority queue.
            *
            * */
            Thread tread1 = new Thread(new Runnable(){

                public void run(){
                    int counter =0;
                    for(int i=0;i<height;i++){
                        for(int j=0;j<width;j++){
                            counter++;
                            img.insertQueues(pixels[i][j]);
                            System.out.println("Thread 1: ["+pixels[i][j].Red+","+pixels[i][j].Green
                                    +","+pixels[i][j].Blue+"]");
                            if(counter == 100){
                                r1.start();
                                r2.start();
                                r3.start();
                            }
                        }
                    }
                }
            });

            tread1.start();

            try {
                tread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

          } catch (IOException e) {
              System.out.println("Problemmm");
          }


    }
}

