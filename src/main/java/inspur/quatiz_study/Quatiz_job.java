package inspur.quatiz_study;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Quatiz_job implements Job {
    @Override
    public void execute(JobExecutionContext nr) throws JobExecutionException {

        //从上下文获取job参数，
//        根据参数，获取相应的joB 任务。
        JobDataMap jobDataMap = nr.getJobDetail().getJobDataMap();

       String dddf= (String) jobDataMap.get("sunfengchuan");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");//设置日期格式
        String date = simpleDateFormat.format(new Date()).toString();

        for (int i = 0; i < 10; i++)
            System.out.println("输出孙风川==>" + date + "===>" + nr);
    }

}

class Quzatz_job_1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        for (int i = 0; i < 5; i++) {
            System.out.println("JOB_万金");
        }

    }
}



