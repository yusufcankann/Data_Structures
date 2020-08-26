import java.util.NoSuchElementException;


/**
 *
 * Simple ExperimentList class that
 * holds an head of the list, and has some operations about list.
 */
public class ExperimentList implements Iterable {

    /**
     * Head of experiment lists.
     */
    private ExperimentNode head;

    /**
     * Simple constructor that sets head node is null.
     */
    public ExperimentList(){
        this.head = null;
    }

    /**
     * Simple contstructor that sets head node.
     * @param head Head of the list.
     */
    public ExperimentList(ExperimentNode head){
        this.head = head;
    }

    /**
     * Getter method for head of experiment list.
     * @return head of experiment list.
     */
    public ExperimentNode getHead() {
        return head;
    }

    /**
     * Setter method for experiment list head.
     * @param head head of experiment list.
     */
    public void setHead(ExperimentNode head) {
        this.head = head;
    }

    /**
     * Creates iterator for the experiment list.
     * @return Experiment list iterator.
     */
    @Override
    public ListIterator iterator() {
        ListIterator iter = new ListIterator(head,this);
        return iter;
    }


    /**
     * Adds the experiment to the end of the list.
     * @param experiment experiment
     */
    public void addExp(Experiment experiment){

        ExperimentNode exp = new ExperimentNode(experiment);

        if(head == null){
            head = exp;
            head.setNextDay(null);
        }
        else if(head.getData().getDay() > experiment.getDay()){
            exp.setNextExperiment(head);
            exp.setNextDay(head);
            head = exp;
        }
        else if (head.getData().getDay() == experiment.getDay()) {
            ExperimentNode tempnode = head;

            while(tempnode.getNextExperiment()!=null &&
                    tempnode.getNextExperiment().getData().getDay() == experiment.getDay()){
                tempnode=tempnode.getNextExperiment();
            }
            exp.setNextExperiment(tempnode.getNextExperiment());
            tempnode.setNextExperiment(exp);
        }
        else if(head.getData().getDay() < experiment.getDay()){
            ExperimentNode tempnode = head;
            ExperimentNode tempday = head;
            while(tempnode.getNextDay()!=null &&
                    tempnode.getNextDay().getData().getDay() <= experiment.getDay()){

               /*Holds the previous day first experiment.*/
               if(tempday.getData().getDay() != tempnode.getData().getDay()){
                   tempday = tempnode;
               }
               tempnode=tempnode.getNextDay();
            }
            if(tempday.getData().getDay() != tempnode.getData().getDay()){
                tempday = tempnode;
            }

            if(tempnode.getNextDay() == null){
               while(tempnode.getNextExperiment() != null){
                   tempnode=tempnode.getNextExperiment();
               }
               tempnode.setNextExperiment(exp);
               exp.setNextExperiment(null);
               exp.setNextDay(null);

               if(tempnode.getData().getDay() != exp.getData().getDay()){
                   tempday.setNextDay(exp);
               }

            }
            else{
                if(tempnode.getData().getDay() == exp.getData().getDay()){
                    while(tempnode.getNextExperiment() != null &&
                            tempnode.getNextExperiment().getData().getDay() == exp.getData().getDay()){
                        tempnode = tempnode.getNextExperiment();
                    }

                    exp.setNextExperiment(tempnode.getNextExperiment());
                    tempnode.setNextExperiment(exp);
                }
                else if(tempnode.getData().getDay() < exp.getData().getDay()){
                    while(exp.getData().getDay() > tempnode.getNextExperiment().getData().getDay()){
                        tempnode = tempnode.getNextExperiment();
                    }

                    exp.setNextExperiment(tempnode.getNextExperiment());
                    exp.setNextDay(tempday.getNextDay());
                    tempday.setNextDay(exp);
                    tempnode.setNextExperiment(exp);
                }

            }
        }
    }

    /**
     * Gets the experiment with the given day and index.
     * @param day Day
     * @param index Index
     * @throws NullPointerException If the element doesn't exist it throws.
     * @return Experiment.
     */
    public Experiment getExp(int day,int index)
        throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException();
        }
        else if(day<head.getData().getDay()){
            throw new NoSuchElementException();
        }
        else if(day == head.getData().getDay()){
            int i=1;
            ExperimentNode temp = head;
            while(i!=index){
                temp = temp.getNextExperiment();
                i++;
                if(temp == null || temp.getData().getDay() != day){
                    throw new NoSuchElementException();
                }
            }
            return temp.getData();
        }
        else if(day > head.getData().getDay()){
            ExperimentNode temp = head;
            while(temp != null && day > temp.getData().getDay()){
                temp = temp.getNextDay();
            }

            if(temp == null){
                throw new NoSuchElementException();
            }
            else if(temp.getData().getDay() == day){
                int i=1;
                ExperimentNode temp1 = temp;
                while(i!=index){
                    temp1 = temp1.getNextExperiment();
                    i++;
                    if(temp1 == null || temp1.getData().getDay() != day){
                        throw new NoSuchElementException();
                    }
                }
                return temp1.getData();
            }
            else
                throw new NoSuchElementException();
        }
        else
            throw new NoSuchElementException();
    }

    /**
     * Sets the experiment with the given day,index and experiment.
     * @param day Day.
     * @param index Index.
     * @param experiment Experiment.
     * @throws NoSuchElementException It throws if element does not exist.
     */
    public void setExp(int day,int index,Experiment experiment)
            throws NoSuchElementException {

        if (head == null) {
            throw new NoSuchElementException();
        } else if (day < head.getData().getDay()) {
            throw new NoSuchElementException();
        } else if (day == head.getData().getDay()) {
            ExperimentNode ex = new ExperimentNode(experiment);
            if (index == 1) {
                ex.setNextExperiment(head.getNextExperiment());
                ex.setNextDay(head.getNextDay());
                head = ex;
            } else {
                int i = 1;
                ExperimentNode temp = head;
                while (i + 1 < index) {
                    temp = temp.getNextExperiment();
                    i++;
                    if (temp == null || temp.getNextExperiment() == null || temp.getNextExperiment().getData().getDay() != day) {
                        throw new NoSuchElementException();
                    }
                }
                ex.setNextDay(temp.getNextExperiment().getNextDay());
                ex.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                temp.setNextExperiment(ex);
            }
        } else if (day > head.getData().getDay()) {

            ExperimentNode ex = new ExperimentNode(experiment);
            ExperimentNode temp = head;
            while (temp.getNextDay() != null && day > temp.getNextDay().getData().getDay()) {
                temp = temp.getNextDay();
            }
            if (temp.getNextDay() == null && temp.getData().getDay() != day) {
                throw new NoSuchElementException();
            }
            else if (temp.getNextDay() != null && temp.getNextDay().getData().getDay() == day) {

                if (index == 1) {
                    while (temp.getNextExperiment().getData().getDay() != day) {
                        temp = temp.getNextExperiment();
                    }
                    ex.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                    ex.setNextDay(temp.getNextExperiment().getNextDay());
                    temp.setNextExperiment(ex);
                    temp.setNextDay(ex);
                } else {
                    temp = temp.getNextDay();
                    int i = 1;

                    while (i + 1 < index) {
                        temp = temp.getNextExperiment();
                        i++;
                        if (temp == null || temp.getNextExperiment() == null || temp.getNextExperiment().getData().getDay() != day) {
                            throw new NoSuchElementException();
                        }
                    }
                    ex.setNextDay(temp.getNextExperiment().getNextDay());
                    ex.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                    temp.setNextExperiment(ex);

                }
            } else
                throw new NoSuchElementException();
        }
    }

    /**
     * It removes the given element on the list.
     * @param day Day.
     * @param index Index.
     * @throws NoSuchElementException It throws if element doesn't exist.
     */
    public void removeExp(int day,int index)
            throws NoSuchElementException{

        if(head == null){
            throw new NoSuchElementException();
        }
        else if(day < head.getData().getDay()){
            throw new NoSuchElementException();
        }
        else if(day == head.getData().getDay()){
            if(index == 1){
                if(head.getNextExperiment().getData().getDay() == day){
                    head.getNextExperiment().setNextDay(head.getNextDay());
                    head = head.getNextExperiment();
                }
                else{
                    head = head.getNextExperiment();
                }
            }
            else{
                int i = 1;
                ExperimentNode temp = head;
                while (i + 1 < index) {
                    temp = temp.getNextExperiment();
                    i++;
                    if (temp == null || temp.getNextExperiment() == null || temp.getNextExperiment().getData().getDay() != day) {
                        throw new NoSuchElementException();
                    }
                }
                temp.setNextExperiment(temp.getNextExperiment().getNextExperiment());
            }
        }
        else if(day > head.getData().getDay()) {
            ExperimentNode temp = head;
            ExperimentNode tempday = head;
            while (temp.getNextDay() != null && day > temp.getNextDay().getData().getDay()) {
                if(tempday.getData().getDay() != temp.getData().getDay()){
                    tempday = temp;
                }
                temp = temp.getNextDay();
            }
            if(tempday.getData().getDay() != temp.getData().getDay()){
                tempday = temp;
            }
            if (temp.getNextDay() == null && temp.getData().getDay() != day) {
                throw new NoSuchElementException();
            }
            else if (temp.getNextDay() != null && temp.getNextDay().getData().getDay() == day) {

                if (index == 1) {
                    while (temp.getNextExperiment().getData().getDay() != day) {
                        temp = temp.getNextExperiment();
                    }
                    if(temp.getNextExperiment().getNextExperiment() == null){
                        tempday.setNextDay(temp.getNextExperiment().getNextDay());
                        temp.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                    }
                    else if(temp.getNextExperiment().getData().getDay() ==
                            temp.getNextExperiment().getNextExperiment().getData().getDay()){
                        tempday.setNextDay(temp.getNextExperiment().getNextExperiment());
                        temp.getNextExperiment().getNextExperiment().setNextDay(temp.getNextExperiment().getNextDay());
                        temp.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                    }
                    else{
                        temp.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                    }
                }
                else {
                    temp = temp.getNextDay();
                    int i = 1;

                    while (i + 1 < index) {
                        temp = temp.getNextExperiment();
                        i++;
                        if (temp == null || temp.getNextExperiment() == null || temp.getNextExperiment().getData().getDay() != day) {
                            throw new NoSuchElementException();
                        }
                    }
                    temp.setNextExperiment(temp.getNextExperiment().getNextExperiment());
                }
            } else
                throw new NoSuchElementException();
        }

    }

    /**
     * Lists all completed experiments in a given day.
     * @param day Day.
     * @throws NoSuchElementException If day no exist.
     */
    public void listExp(int day)
            throws NoSuchElementException{
        ExperimentNode temp = head;
        while(temp!= null && temp.getData().getDay() != day){
            temp=temp.getNextDay();
        }
        if(temp == null){
            throw new NoSuchElementException();
        }
        else{
            while(temp != null && temp.getData().getDay() == day){
                if(temp.getData().getCompleted() == true){
                    System.out.printf("Experiment setup: %s Experiment Day:%d Experiment Time:%s " +
                                    "Experiment Completed:%b Experiment Accurancy:%f \n",
                            temp.getData().getSetup(),temp.getData().getDay(),temp.getData().getTime(),
                            temp.getData().getCompleted(),temp.getData().getAccuracy() );
                }
                temp=temp.getNextExperiment();
            }
        }
    }

    /**
     * Remove all experiments in a given day.
     * @param day Day.
     * @throws NoSuchElementException It throws if day doesn't exist.
     */
    public void removeDay(int day)
            throws NoSuchElementException{
        ExperimentNode exp = head;

        if(exp.getData().getDay() == day){
            head = head.getNextDay();
        }
        else {
            while (exp.getNextDay() != null && exp.getNextDay().getData().getDay() < day) {
                exp = exp.getNextDay();
            }

            if (exp.getNextDay() == null) {
                throw new NoSuchElementException();
            } else {
                /*Set the day.*/
                exp.setNextDay(exp.getNextDay().getNextDay());

                ExperimentNode temp = exp.getNextDay();
                /*Set the experiment list.*/
                while(exp.getNextExperiment().getData().getDay() != day){
                    exp = exp.getNextExperiment();
                }

                exp.setNextExperiment(temp);
            }
        }
    }

    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Merge Sort Methods!!!!!!!!!!!1!!!!!!!!!!!!!!!!!!!!!!*/

    /**
     * Merge operation for mergeSort.
     * @param x node 1.
     * @param y node 2.
     * @return result of merge operation.
     */
    private ExperimentNode merge(ExperimentNode x,ExperimentNode y){
        ExperimentNode result = null;
        /*Base cases*/
        if(x== null){
            return y;
        }
        if(y==null){
            return x;
        }

        if(y.getData().getAccuracy() >= x.getData().getAccuracy() ){
            result = x;
            result.setNextExperiment(merge(x.getNextExperiment(),y));
        }
        else{
            result = y;
            result.setNextExperiment(merge(x,y.getNextExperiment()));
        }

        return result;
    }

    /**
     * It gets the middle element of the list.
     * It uses 2 reference. One reference goes 2 time faster,
     * the other one goes normal speed. When first one goes to the end,
     * the second one comes to the middle.
     * @param head Head of the list.
     * @return Middle node.
     */
    private ExperimentNode middle(ExperimentNode head){
        if(head == null) return head;

        ExperimentNode ex1 = head.getNextExperiment(); /*It goes 2 times faster.*/
        ExperimentNode ex2 = head; /*It goes normal speed.*/

        /*This loop goes to the end of the list with fast node.*/
        while (ex1 != null)
        {
            ex1 = ex1.getNextExperiment();
            if(ex1!=null)
            {
                ex2 = ex2.getNextExperiment();
                ex1=ex1.getNextExperiment();
            }
        }
        return ex2;
    }

    /**
     * Merge Sort. It takes the head of the list and divide it and
     * sorts it step by step.
     * @param head Head of the list.
     * @return Sortedlist.
     */
    private ExperimentNode mergeSort(ExperimentNode head){
        if(head==null || head.getNextExperiment() == null){
            return head;
        }

        ExperimentNode middle = middle(head);

        ExperimentNode right = middle.getNextExperiment();

        /*Divide the left from right part.*/
        middle.setNextExperiment(null);

        ExperimentNode leftPart = mergeSort(head);
        ExperimentNode rightPart = mergeSort(right);
        ExperimentNode result = merge(leftPart,rightPart);

        return result;
    }

    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!End of merge sort methods.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

    /**
     * Sorts the experiments in a given day according to the accuracy,
     * the changes will be done on the list
     * @param day Day.
     */
    public void orderDay(int day)
            throws NoSuchElementException{

        ExperimentNode temp = head;
        ExperimentNode temphead;
        ExperimentNode temptail;

        if(temp == null || temp.getData().getDay() > day){
            throw new NoSuchElementException();
        }

        if(temp.getData().getDay() == day){
            temphead = temp;
            while(temp.getNextExperiment() != null && temp.getNextExperiment().getData().getDay() != day){
                temp = temp.getNextExperiment();
            }
            temptail = temp.getNextExperiment();
            temp.setNextExperiment(null);

            ExperimentNode sortedList = mergeSort(temphead);
            head = sortedList;
            while(sortedList.getNextExperiment() != null){
                sortedList.setNextDay(null);
                sortedList = sortedList.getNextExperiment();
            }
            sortedList.setNextExperiment(temptail);
            head.setNextDay(temptail);
        }
        else {
            while (temp.getNextDay() != null && temp.getNextDay().getData().getDay() != day) {
                temp = temp.getNextDay();
            }

            if (temp.getNextDay() == null && temp.getData().getDay() != day) {
                throw new NoSuchElementException();
            }
            else{
                ExperimentNode tempDay = temp;

                while(temp.getNextExperiment() != null && temp.getNextExperiment().getData().getDay() != day){
                    temp = temp.getNextExperiment();
                }
                ExperimentNode templefttail=temp;
                temphead = temp.getNextExperiment();

                while(temp.getNextExperiment() != null && temp.getNextExperiment().getData().getDay() ==day){
                    temp = temp.getNextExperiment();
                }


                temptail = temp.getNextExperiment();
                temp.setNextExperiment(null);

                ExperimentNode sortedList = mergeSort(temphead);

                tempDay.setNextDay(sortedList);
                templefttail.setNextExperiment(sortedList);

                while(sortedList.getNextExperiment() != null ){
                    sortedList.setNextDay(null);
                    sortedList = sortedList.getNextExperiment();
                }
                templefttail.getNextExperiment().setNextDay(temptail);
                sortedList.setNextExperiment(temptail);
            }
        }
    }

    /**
     * Sorts all the experiments in the list according to the accuracy,
     * the original list doesn't change.
     * @return Head of the sorted list.
     */
    public ExperimentNode orderExperiments(){

        ExperimentNode temp = head;
        ExperimentNode head1=new ExperimentNode(head.getData());
        head1.setNextDay(head.getNextDay());
        ExperimentNode iter = head1;
        temp = temp.getNextExperiment();
        while(temp!=null){
            iter.setNextExperiment(new ExperimentNode(temp.getData()));
            iter.setNextDay(temp.getNextDay());
            temp = temp.getNextExperiment();
            iter=iter.getNextExperiment();
        }

        return mergeSort(head1);
    }

    /**
     * List all experiments.
     */
    public void listAll()
    {
        System.out.println("List experiment view:");
            ExperimentNode last = head;
        while( last != null) {
            System.out.println(last.getData().toString());
            last = last.getNextExperiment();
        }
        System.out.println("List day view:");
        last = head;
        while( last != null) {
            System.out.println(last.getData().toString());
            last = last.getNextDay();
        }
    }




}



