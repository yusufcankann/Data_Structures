
/**
 * A simple Experiment class that
 * take the records of experiments.
 */

public class Experiment {

    /**
     * Explains the experimental setup.
     */
    private String setup;

    /**
     * Day of start.
     */
    private int day;

    /**
     * Time of start.
     */
    private String time;

    /**
     * Indicates the experiment completed or not.
     */
    private boolean completed;

    /**
     * Represents the output.
     */
    private float accuracy;

    /**
     * Simple constructor that sets setup,day,time
     * ,completed and accurancy.
     * @param setup_ Explains the experimentals setup.
     * @param day_ Day of start.
     * @param time_ Time of start.
     * @param completed_ Indicated the experiment completed or not.
     * @param accuracy_ Represents the output.
     */
    public Experiment(String setup_,int day_,String time_,
                      boolean completed_,float accuracy_){
        setup=setup_;
        day=day_;
        time = time_;
        completed=completed_;
        accuracy=accuracy_;

        /*Invalid value for not completed experiments.*/
        if(completed_ != true){
            accuracy = -1;
        }
    }

    /**
     * Getter method for setup.
     * @return Experiment setup.
     */
    public String getSetup(){
        return setup;
    }

    /**
     * Getter method for day.
     * @return Day of start.
     */
    public int getDay(){
        return day;
    }

    /**
     * Getter method for time.
     * @return Time of start.
     */
    public String getTime(){
        return time;
    }

    /**
     * Getter method for completed
     * @return Indicated the experiment completed or not.
     */
    public boolean getCompleted(){
        return completed;
    }

    /**
     * Getter method for accurancy.
     * @return Accurancy of experiment.
     */
    public float getAccuracy() {
        return accuracy;
    }

    /**
     * Setter method for accuracy.
     * @param accuracy accuracy.
     */
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "setup='" + setup + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", accuracy=" + accuracy +
                ", completed=" + completed +
                '}';
    }
}
