import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Simple main class that takes path of file with commandline.
 * It calculates the infix expressions and prints the value on the screen.
 *
 * @author Yusuf Can
 */
public class Part2_Main {

    public static void main(String[] args) {

        try{
            InputStream is = new FileInputStream(args[0]);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            /*Reads the document line by line.*/
            while(line.length() != 0){

                /*Takes the input variables.*/
                sb.append(line);
                sb.append(" ");
                line = buf.readLine();
            }

            /*Takes the infix operations.*/
            line = buf.readLine();


            /*Reads the string which contains input variables and changes the infix operations.*/
            for(int i=0;i<sb.length();i++){
                if(i+4 < sb.length() && sb.charAt(i+2) == '='){
                    String number = new String();
                    number+= " ";
                    int a=i;
                    while(a+4 < sb.length() && sb.charAt(a+4) != ' '){
                        number += sb.charAt(a+4);
                        a++;
                    }
                    number+= " ";
                    line=line.replaceAll(" "+sb.charAt(i)+" ",number);
                }
            }

            Part2 p =  new Part2(line);
            System.out.println("Infix Expression: "+line);
            System.out.println("Postfix Expression: "+p.postfix());
            System.out.println("Result: "+p.calculatePosfix());

            Math math = new Math();

        }catch(
        FileNotFoundException e){
            System.out.println("Error");
        }catch(IOException e){
            System.out.println("Error");
        }
    }

}
