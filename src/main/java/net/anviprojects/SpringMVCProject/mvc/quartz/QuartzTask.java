package net.anviprojects.SpringMVCProject.mvc.quartz;

import java.util.Calendar;

public class QuartzTask {

    public void simpleTaskMethod(){
        System.out.println("Test Simple Quartz Time: "+ Calendar.getInstance().getTime());
    }
}
