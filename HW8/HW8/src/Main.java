import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader;
        try {
            /*Reads file.*/
            reader = new BufferedReader(new FileReader("src/input.txt"));

            /*Reads first line and creates new matrix graph with that.*/
            String line = reader.readLine();
            String numbers[] = line.split(" ");
            int numberOfPeople = Integer.parseInt(numbers[0]);
            int numberOfRelation = Integer.parseInt(numbers[1]);
            MatrixGraph mg= new MatrixGraph(numberOfPeople,false);


            int source,destination;
            line = reader.readLine();

            /* Adds every vertex to graph. */
            while (line != null) {
                numbers = line.split(" ");
                source = Integer.parseInt(numbers[0]);
                destination = Integer.parseInt(numbers[1]);

                mg.insert(source-1,destination-1);
                line = reader.readLine();
            }
            reader.close();

            /*It checks the transitive vertex and adds new vertex.*/
            mg.applyTransitive();


            int result = mg.countPopular();

            System.out.println(result);








        } catch (IOException e) {
            System.out.println("Something went wrong while opening the file.");
        }



    }
}
