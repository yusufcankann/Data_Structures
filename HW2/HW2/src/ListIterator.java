import java.lang.NullPointerException;

/**
 * Simple Iterator class for LinkedList.
 * This class provides the facility of iterating
 * the elements in a forward direction only.
 */
public class ListIterator implements java.util.Iterator {

    /**
     * Node.
     */
    private ExperimentNode head=null;

    /**
     * ExperimentList for removing head of the list.
     */
    private ExperimentList list=null;
    /**
     * It holds the last element which returned by next method for remove operation.
     */
    private ExperimentNode nextReturn=null;

    /**
     * Simple constructor that sets the node.
     * @param head Head.
     * @param list Experiment List.
     */
    public ListIterator(ExperimentNode head,ExperimentList list){
        this.list=list;
        this.head = head;
    }

    /**
     * Looks iterator has next element.
     * @return true if it has next elemennt.
     */
    public boolean hasNext(){
        return (head != null);
    }

    /**
     * Returns the value of next element and sets node to the next node.
     * @return head.
     * @throws NullPointerException Throws if node is null or node has not next element.
     */
    public ExperimentNode next()
            throws NullPointerException{

        if (head==null || (this.hasNext() == false) ){
            throw new NullPointerException();
        }
        ExperimentNode temp = head;
        head = head.getNextExperiment();
        nextReturn = temp;
        return temp;
    }

    /**
     * Removes the last element which returned by next() method.
     * @throws NullPointerException It throws if element doesn't exist.
     */
    public void remove()
            throws NullPointerException {
        if (nextReturn==null){
            throw new NullPointerException();
        }
        else{
            ExperimentNode temp = list.getHead();
            if(temp == nextReturn){
                if(temp.getNextDay() != null && temp.getNextExperiment().getData().getDay() == temp.getData().getDay()){
                    temp.getNextExperiment().setNextDay(temp.getNextDay());
                }
                list.setHead(list.getHead().getNextExperiment());
                temp = temp.getNextExperiment();
                nextReturn = null;
            }
            else{
                ExperimentNode day=null;

                while(temp.getNextExperiment()!=null && temp.getNextExperiment() != nextReturn){
                    /*Holds the previous day if nextReturn is first element of the day.*/
                    if(temp.getNextDay() == nextReturn){
                        day = temp;
                    }
                    temp=temp.getNextExperiment();
                }
                if(temp.getNextDay() == nextReturn){
                    day = temp;
                }

                if(temp.getNextExperiment() == null){
                    throw new NullPointerException();
                }
                else{
                    /*If next element is that we want to remove.*/
                    if(day != null &&
                            (head.getData().getDay() == temp.getNextExperiment().getData().getDay())){
                        head.setNextDay(temp.getNextExperiment().getNextDay());
                        day.setNextDay(head);
                    }
                    else if(day != null){
                        day.setNextDay(head);
                    }
                    temp.setNextExperiment(head);
                    nextReturn = null;
                }
            }
        }



    }
}

