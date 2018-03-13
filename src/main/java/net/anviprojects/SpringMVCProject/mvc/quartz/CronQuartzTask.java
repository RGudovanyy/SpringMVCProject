package net.anviprojects.SpringMVCProject.mvc.quartz;

import java.util.Calendar;

public class CronQuartzTask {

    public void cronTaskMethod(){
        System.out.println("Cron Time: "+ Calendar.getInstance().getTime());
    }
}
