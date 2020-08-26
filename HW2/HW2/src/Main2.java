/*
 *
 *
 *I started all index and days to 1.
 *
 * So i changed your input values. Please be carefull about that.
 * The output is not the same with yout output.
 *
 *Thank you.
 *
 * 161044007
 * Yusuf Can Kan
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        ExperimentList list = new ExperimentList();
        Random generator = new Random();
        generator.setSeed(3);
        boolean completed = true;
        float acc;
        int day;
        String time = "timeInfo";
        for(int i=0; i<20; i++)
        {
            System.out.println("----------------------");
            day =  generator.nextInt(4)+1 ;
            String setup = "setup"+Integer.toString(i);
            acc = (float) (i*0.1);
            Experiment e = new Experiment(setup,day, time , completed, acc);
            System.out.println("Add new experiment:");
            System.out.println(e.toString());
            list.addExp(e);
            list.listAll();
        }

        System.out.println("----------------------");
        System.out.println("getExp(1,2) Result:");
        Experiment e = list.getExp(1,2);
        System.out.println(e.toString());
        System.out.println("----------------------");
        System.out.println("setExp(1,2), accuracy=1.0");
        e.setAccuracy((float) 1.0);
        list.setExp(1,2, e);
        e = list.getExp(1,2);
        System.out.println("----------------------");
        System.out.println("getExp Result:");
        e = list.getExp(1,2);
        System.out.println(e.toString());
        System.out.println("----------------------");
        System.out.println("listExp(1) Result:");
        list.listExp(1);
        System.out.println("----------------------");
        System.out.println("removeExp(1,1) Result:");
        list.removeExp(1, 1);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("removeExp(1,1) Result:");
        list.removeExp(1, 1);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("removeExp(2,1) Result:");
        list.removeExp(2, 1);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("removeExp(3,5) Result:");
        list.removeExp(3, 5);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("orderExperiment Result:");
        ExperimentNode orderedList = list.orderExperiments();

        ExperimentList listt = new ExperimentList(orderedList);
        Iterator itr =  listt.iterator();
        while(itr.hasNext()) {

            System.out.println(((ExperimentNode)(itr.next())).getData());
        }

    }
}
