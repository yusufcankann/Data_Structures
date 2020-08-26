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


import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args){

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("06:02:19");
        Date date = new Date();
        String time1=dateFormat1.format(date);

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("06:02:19");
        Date date1 = new Date();
        String time2=dateFormat2.format(date1);

        SimpleDateFormat dateFormat3 = new SimpleDateFormat("06:02:19");
        Date date2 = new Date();
        String time3=dateFormat3.format(date2);

        System.out.println("\n\n-------Experiment Constructor test---------");
        System.out.println("5 experiment created and their names setted as 'a1','a2','a3','a4','a5'. ");
        Experiment ex1=new Experiment("a1",1,time1,true,97);
        Experiment ex2=new Experiment("a2",2,time2,true,19);
        Experiment ex3=new Experiment("a3",3,time3,false,11);
        Experiment ex4=new Experiment("a4",3,time2,true,92);
        Experiment ex5=new Experiment("a5",3,time1,true,15);

        ExperimentList exlist = new ExperimentList();
        exlist.addExp(ex1);
        exlist.addExp(ex2);
        exlist.addExp(ex3);
        exlist.addExp(ex4);
        exlist.addExp(ex5);

        ListIterator iter = exlist.iterator();
        System.out.println("\n\n-------Iterator Class Test {hasnext(),next(),remove() methods}--------");
        System.out.println("Iterator created and next method goes and " +
                "prints all element on the terminal." +
                "hasNext() tested inside of this code.");
        while(iter.hasNext()){
            System.out.printf(" %s ",iter.next().getData().getSetup());
        }

        System.out.println("\n\nIterator removes the third element.");

        iter = exlist.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.remove();
        System.out.println("Current elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf(" %s ",iter.next().getData().getSetup());
        }

        System.out.println("\n\n\n--------addExperiment() Method Test------------");

        System.out.println("\n\nExperiment 6 7 and 8 created and added to the list." +
                "Setups names are a6,a7,a8.");
        Experiment ex6=new Experiment("a6",4,time2,false,12);
        Experiment ex7=new Experiment("a7",4,time1,false,12);
        Experiment ex8=new Experiment("a8",5,time2,false,12);


        System.out.println("\n\naddExperiment method tested succesfully.");
        exlist.addExp(ex6);
        exlist.addExp(ex7);
        exlist.addExp(ex8);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\nExperiment 9 created and added to the list. Its setup is a9 and day is 3");
        Experiment ex9 = new Experiment("a9",3,time3,true,12);
        exlist.addExp(ex9);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\n------Day List structure test---------");
        System.out.println("\nAll nextday list from head to tail;");
        ExperimentNode nodee;
        nodee = exlist.getHead();
        while(nodee != null){
            System.out.printf(" %s ", nodee.getData().getSetup());
            nodee = nodee.getNextDay();
        }

        /*getExperiment(); Method Test;*/
        System.out.println("\n\n--------getExperiment(); method Test-------");
        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\ngetExperiment(3,2) setup name;");
        System.out.println(exlist.getExp(3,2).getSetup());
        System.out.println("\ngetExperiment(4,1) setup name;");
        System.out.println(exlist.getExp(4,1).getSetup());
        System.out.println("\ngetExperiment(1,1) setup name;");
        System.out.println(exlist.getExp(1,1).getSetup());
        System.out.println("\ngetExperiment(3,3) setup name;");
        System.out.println(exlist.getExp(3,3).getSetup());

        /*setExperiment(); Method Test;*/
        System.out.println("\n\n--------setExperiment(); method Tests-------");
        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\n\nNew experiment created: setup a10, day 3.");
        System.out.println("setExperiment(3,1,experiment)");

        Experiment ex10 = new Experiment("a10",3,time1,true,67);
        exlist.setExp(3,1,ex10);


        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\n\nNew experiment created: setup a11, day 4.");
        System.out.println("setExperiment(4,2,experiment)");

        Experiment ex11 = new Experiment("a11",4,time3,true,12);
        exlist.setExp(4,2,ex11);


        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\n------Day List structure test---------");
        System.out.println("\nAll nextday list from head to tail;");
        ExperimentNode nodee1;
        nodee1 = exlist.getHead();
        while(nodee1 != null){
            System.out.printf(" %s ", nodee1.getData().getSetup());
            nodee1 = nodee1.getNextDay();
        }

        /*removeExp(); Method Test;*/
        System.out.println("\n\n--------removeExp(); method Test()-------");

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\nremoveExp(3,3)");
        exlist.removeExp(3,3);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\nremoveExp(5,1)");
        exlist.removeExp(5,1);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\n");

        System.out.println("Some experiments added.");

        exlist.addExp(ex1);
        exlist.addExp(ex4);
        exlist.addExp(ex5);
        exlist.addExp(ex7);

        Experiment ex12 = new Experiment("a12",6,time3,true,12);
        exlist.addExp(ex12);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        /*ListExp(); Method Test;*/
        System.out.println("\n\n--------ListExp(); method Test-------");

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent Days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d ",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent Completed;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5b ",iter.next().getData().getCompleted());
        }

        System.out.println("\n\nlistExperiment(3);");
        exlist.listExp(3);
        System.out.println("\n\nlistExperiment(4);");
        exlist.listExp(4);


        /*removeDay(); Method Test;*/
        System.out.println("\n\n--------removeDay(); method Test-------");

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\nremoveDay(4);");
        exlist.removeDay(4);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }

        System.out.println("\n\nremoveDay(2);");
        exlist.removeDay(2);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3s ",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%3d ",iter.next().getData().getDay());
        }







        /*orderDay(); Method Test;*/
        System.out.println("\n\n--------orderDay(); method Test-------");

        Experiment ex13=new Experiment("a13",2,time2,true,69);
        Experiment ex14=new Experiment("a14",2,time2,true,70);
        Experiment ex15=new Experiment("a15",2,time2,true,71);
        Experiment ex16=new Experiment("a16",2,time2,true,72);

        exlist.addExp(ex15);
        exlist.addExp(ex13);
        exlist.addExp(ex16);
        exlist.addExp(ex14);
        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s |",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d |",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent accurancy;");
        iter = exlist.iterator();
        while(iter.hasNext()) {
            System.out.printf("%2.2f |", iter.next().getData().getAccuracy());
        }

        System.out.println("\n\norderDay(2)\n");

        exlist.orderDay(2);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s |",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d |",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent accurancy;");
        iter = exlist.iterator();
        while(iter.hasNext()) {
            System.out.printf("%2.2f |", iter.next().getData().getAccuracy());
        }

        System.out.println("\n\norderDay(3)\n");

        exlist.orderDay(3);

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s |",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d |",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent accurancy;");
        iter = exlist.iterator();
        while(iter.hasNext()) {
            System.out.printf("%2.2f |", iter.next().getData().getAccuracy());
        }


        System.out.println("\n\n------Day List structure test---------");
        System.out.println("\nAll nextday list from head to tail;");
        ExperimentNode nodee2;
        nodee2 = exlist.getHead();
        while(nodee2 != null){
            System.out.printf(" %s ", nodee2.getData().getSetup());
            nodee2 = nodee2.getNextDay();
        }


        /*orderExperiments(); Method Test;*/
        System.out.println("\n\n-----------------orderExperiments(); method Test-----------------");

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s |",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d |",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent accurancy;");
        iter = exlist.iterator();
        while(iter.hasNext()) {
            System.out.printf("%2.2f |", iter.next().getData().getAccuracy());
        }

        ExperimentList exlist2 = new ExperimentList(exlist.orderExperiments());

        System.out.println("\n\n ---------- SORTED LIST ---------- \n");
        System.out.println("\nCurrent elements;");
        iter = exlist2.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s |",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist2.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d |",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent accurancy;");
        iter = exlist2.iterator();
        while(iter.hasNext()) {
            System.out.printf("%2.2f |", iter.next().getData().getAccuracy());
        }

        System.out.println("\n\n --------- MAIN LIST --------");

        System.out.println("\nCurrent elements;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5s |",iter.next().getData().getSetup());
        }

        System.out.println("\nCurrent days;");
        iter = exlist.iterator();
        while(iter.hasNext()){
            System.out.printf("%5d |",iter.next().getData().getDay());
        }

        System.out.println("\nCurrent accurancy;");
        iter = exlist.iterator();
        while(iter.hasNext()) {
            System.out.printf("%2.2f |", iter.next().getData().getAccuracy());
        }

        System.out.println("\n\n------Day List structure test for main---------");
        System.out.println("\nAll nextday list from head to tail;");
        nodee2 = exlist.getHead();
        while(nodee2 != null){
            System.out.printf(" %s ", nodee2.getData().getSetup());
            nodee2 = nodee2.getNextDay();
        }

        System.out.println("\n\n------listAll() method test---------");
        exlist.listAll();


    }
}
