import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Simple main class that takes path of ASCII text file with commandline.
 * File contains a binary digital image represented with matrix.
 *
 * This class calculates the count of white area of the image.
 *
 * @author Yusuf Can
 */

public class Part1_Main {

    public static void main(String[] args) {

        try{

            InputStream is = new FileInputStream(args[0]);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            int l=0;

            /*Reads the file line by line.*/
            while(line != null){
                sb.append(line);
                line = buf.readLine();
                l++;
            }

            /*Calculates column and length of the file.*/
            sb.trimToSize();
            int c = sb.capacity() / l;

            c++;
            c=c/2;

            Part1 w = new Part1(sb,l,c);

            System.out.println("White Areas: "+w.calculateWhite());

        }catch(FileNotFoundException e){
            System.out.println("Error");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}
