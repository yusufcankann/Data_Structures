import java.io.*;
import java.util.*;

/**
 * Simple NLP class that has WordMap field and holds all text
 * and file information inside of it.
 */
public class NLP
{
    /**
     * Word Map class field.
     */
    public Word_Map wmap;

    /**
     * Holds document count.
     */
    private int total_number_of_document=0;

    /**
     * Reads the dataset from the given dir and created a word map.
     * */
    public void readDataset(String dir)
        throws IOException {
        wmap = new Word_Map();


        int word_count = 0;

        /*Reads the all files inside the directory and puts every file in an File array.*/
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();

        /*Reads every file one by one.*/
        for (File file_ : listOfFiles) {
            if (file_.isFile()) {
                total_number_of_document++;
                /*Opens a file.*/
                File file = new File("./dataset/" + file_.getName());
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;

                /*Reads file line by line.*/
                while ((st = br.readLine()) != null) {

                    /*Splits the file with respect to empty character.*/
                    String[] words = st.split(" ");

                    /*Reads words one by one.*/
                    for (String i : words) {

                        /*Erases the unnecessary characters inside the word.*/
                        String word = i.trim().replaceAll("\\p{Punct}", "");

                        /*Eliminates the empty strings.*/
                        if (!word.equals("")) {

                            word_count++;

                            /*Checks if Word_Map has that key.*/
                            if (wmap.containsKey(word)) {
                                /*If it has...*/

                                File_Map fm = (File_Map) (wmap.get(word));
                                /*Checks File_Map. If File_Map has same file name key.*/
                                if (fm.containsKey(file_.getName())) {

                                    /*Checks its value lists. If the list doesn't have word number, it adds the number.*/
                                    List list = (List<Integer>) fm.get(file_.getName());
                                    if (!list.contains(word_count)) {
                                        list.add(word_count);
                                    }
                                } else {
                                    /*If File_Map doesn't have same file name key it creates a new entry.*/
                                    ArrayList<Integer> list = new ArrayList<>();
                                    list.add(word_count);
                                    fm.put(file_.getName(), list);
                                }

                            } else {
                                /*If File_Map doesn't have same key it creates new entry and adds it.*/
                                File_Map fm = new File_Map();

                                ArrayList<Integer> arr = new ArrayList<>();
                                arr.add(word_count);
                                fm.put(file_.getName(), arr);

                                wmap.put(word, fm);
                            }
                        }

                    }
                }
                word_count = 0;
            }
        }
    }

    /**
     * Finds all the bigrams starting with the given word
     * */
    public List<String> bigrams(String word){
        /*If Word_Map doesn't have word, it return null.*/
        if(!wmap.containsKey(word)){
            return null;
        }

        List<String> answer = new ArrayList<>();

        /*Takes Word_Map's value(File Map) for the given word.*/
        File_Map fm = (File_Map)wmap.get(word);
        Set entry_set = fm.entrySet();/*Takes entry set.*/

        /*Looks every entry of Word_Map.*/
        for(Object entries:entry_set){
            /*Takes all the file names and positions for the current word.*/
            String file_name = ((MyEntry<String,List<Integer>>)entries).getKey();
            List<Integer> positions = ((MyEntry<String,List<Integer>>)entries).getValue();

            /*Looks again the Word_Map.*/
            Set word_map_keys = wmap.keySet();

            /*Looks every key for matching.*/
            for(Object i: word_map_keys){

                /*Takes the name of files for every word.*/
                File_Map fMap = (File_Map)(wmap.get(i));
                Set fMap_Keys = fMap.keySet();

                for(Object j : fMap_Keys){
                    /*If file is the same with our file.*/
                    if(j.equals(file_name)){
                        /*Looks the position. If position is 1 more than given words position it adds it to the answer.*/
                        for(Integer position : positions){
                            if(((List<Integer>)fMap.get(j)).contains(position+1)){
                                if(!(answer.contains(word+" "+i))){
                                    answer.add(word+" "+i);
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }


    /**
     * Calculates the tfIDF value of the given word for the given file.
     * */
    public float tfIDF(String word, String fileName)
    {
        File_Map fm = (File_Map) wmap.get(word);

        int appears = ((List<Integer>)(fm.get(fileName))).size();
        int total_number =0;

        Set keys = wmap.keySet();

        for(Object i : keys){
            File_Map fmap = (File_Map) wmap.get(i);

            Set keys_fm = fmap.keySet();

            for (Object j:keys_fm){
                if(j.equals(fileName)){
                    List list = (List) (fmap.get(j));
                    total_number+=list.size();
                }
            }
        }

        double TF = ((double)appears) / ((double)total_number);

        File_Map fmapp = (File_Map)(wmap.get(word));
        int number_of_doc_t_in_it=fmapp.size();

        double IDF = ((double)total_number_of_document) / ((double) number_of_doc_t_in_it);

        IDF = Math.log(IDF);
        return (float) (TF*IDF);

    }

    /**
     * Prints the all word lists.
     */
    public  void printWordMap()
    {
        int counter =0;
        Iterator iter= wmap.iterator();
        System.out.printf("[ ");
        while(iter.hasNext()){
            counter++;
            if(counter==10) {
                System.out.printf("\n");
                counter=0;
            }
            System.out.printf("%s, ",((Word_Map.Node)iter.next()).key);
        }
        System.out.printf("%s ]",((Word_Map.Node)iter.next()).key);

    }

}
