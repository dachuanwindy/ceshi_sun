package inspur.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Collections;

public class Myjob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务正在执行，执行时间: " + Calendar.getInstance().getTime());
        for (int i=0;i<10;i++){
            System.out.println("任务开始干"+i);
        }
    }
}