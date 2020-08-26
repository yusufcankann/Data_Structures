import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args){
        try{

            List bigrams;

            /*Creates nlp class.*/
            NLP nlp = new NLP();

            /*Reads all the data.*/
            nlp.readDataset("./dataset");

            /*Opens input file.*/
            File file = new File("input_file.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            System.out.printf("\n");
            /*Reads file line by line.*/
            while ((st = br.readLine()) != null) {
                /*Splits words.*/
                String[] words = st.split(" ");

                if(words[0].equals("bigram")){
                    bigrams = nlp.bigrams(words[1]);
                    print_List(bigrams);
                    System.out.printf("\n\n");
                }
                else{
                    float answer = nlp.tfIDF(words[1],words[2]);
                    System.out.println(answer);
                    System.out.printf("\n");
                }
            }
        }
        catch (IOException e){

        }

    }

    public static void print_List(List values){
        int counter =0;

        System.out.printf("[");
        for(Object i : values){
            counter++;
            if(counter%10 == 0){
                System.out.printf("\n");
            }
            if(counter < values.size()){
                System.out.printf("%s ,",i);
            }
        }
        System.out.printf("%s]",values.get(values.size()-1));
    }

}
