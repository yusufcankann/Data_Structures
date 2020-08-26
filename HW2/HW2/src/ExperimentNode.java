/**
 *
 * Simple ExperimentNode class that
 * holds an next experiment and next day and connects.
 */
public class ExperimentNode {

    /**
     * Experiment information.
     */
    private Experiment data=null;

    /**
     * Next experiment.
     */
    private ExperimentNode nextExperiment=null;

    /**
     *
     * First experiment of next day.
     */
    private ExperimentNode nextDay=null;

    /**
     * Simple constructor that sets experiment.
     * @param data Experiment data.
     */
    public ExperimentNode(Experiment data) {
        this.data = new Experiment(data.getSetup(), data.getDay(), data.getTime(),
                data.getCompleted(), data.getAccuracy());
        this.nextDay = null;
        this.nextExperiment = null;
    }

    /**
     * Setter method of next experiment.
     * @param next Next experiment.
     */
    public void setNextExperiment(ExperimentNode next) {
        this.nextExperiment = next;
    }

    /**
     * Setter method for nextDay
     *
     * @param nextDay next days first element reference.
     */
    public void setNextDay(ExperimentNode nextDay) {
        this.nextDay = nextDay;
    }

    /**
     * Getter method for nextelement
     * @return Next experiment.
     */
    public ExperimentNode getNextExperiment() {
        return nextExperiment;
    }

    /**
     *
     * Getter method for next days first experiment.
     * @return next days first experiment.
     */
    public ExperimentNode getNextDay() {
        return nextDay;
    }

    /**
     * Getter method for experiment.
     * @return Current experiment.
     */
    public Experiment getData() {
        return this.data;
    }







}
