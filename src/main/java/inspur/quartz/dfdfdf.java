/*
package inspur.quartz;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.cronSchedule;


*/
/**
 * @Title:Quartz管理类
 * @Description:
 * @Copyright:
 * @author zz  2008-10-8 14:19:01
 * @version 1.00.000
 * <p>
 * <p>
 * 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
 * @param jobName 任务名
 * @param job     任务
 * @param time    时间设置，参考quartz说明文档
 * @throws SchedulerException
 * @throws ParseException
 * <p>
 * 添加一个定时任务
 * @param jobName 任务名
 * @param jobGroupName 任务组名
 * @param triggerName  触发器名
 * @param triggerGroupName 触发器组名
 * @param job     任务
 * @param time    时间设置，参考quartz说明文档
 * @throws SchedulerException
 * @throws ParseException
 * <p>
 * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
 * @param jobName
 * @param time
 * @throws SchedulerException
 * @throws ParseException
 * <p>
 * 修改一个任务的触发时间
 * @param triggerName
 * @param triggerGroupName
 * @param time
 * @throws SchedulerException
 * @throws ParseException
 * <p>
 * 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
 * @param jobName
 * @throws SchedulerException
 * <p>
 * 移除一个任务
 * @param jobName
 * @param jobGroupName
 * @param triggerName
 * @param triggerGroupName
 * @throws SchedulerException
 *//*
 */
/**
 * @Title:Quartz管理类
 *
 * @Description:
 *
 * @Copyright:
 * @author zz  2008-10-8 14:19:01
 * @version 1.00.000
 *
 *//*

public class QuartzManager {
    private static SchedulerFactory sf = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "group1";
    private static String TRIGGER_GROUP_NAME = "trigger1";


    */
/** *//*
 */
/**
 *  添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
 * @param jobName 任务名
 * @param job     任务
 * @param time    时间设置，参考quartz说明文档
 * @throws SchedulerException
 * @throws ParseException
 *//*


    public static void addJob(String jobName,Job job,String time)
            throws SchedulerException, ParseException{
        Scheduler sched = sf.getScheduler();
        JobDetail jobDetail1 = JobBuilder.newJob().withIdentity("","").build();




//        第一种情况：间隔时间执行
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("","").withSchedule(cronSchedule("")).build();

        // 只执行一次，就靠startat()
        trigger=TriggerBuilder.newTrigger().withIdentity("","").startAt(new Date()).build();

//        第二种情况：定时执行

        CronTrigger cronTrigger= (CronTrigger) TriggerBuilder.newTrigger().withIdentity("","").build();

        SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("","").build();





        //启动
        if(!sched.isShutdown())
            sched.start();
    }

    */
/** *//*
 */
/**
 * 添加一个定时任务
 * @param jobName 任务名
 * @param jobGroupName 任务组名
 * @param triggerName  触发器名
 * @param triggerGroupName 触发器组名
 * @param job     任务
 * @param time    时间设置，参考quartz说明文档
 * @throws SchedulerException
 * @throws ParseException
 *//*

    public static void addJob(String jobName,String jobGroupName,
                              String triggerName,String triggerGroupName,
                              Job job,String time)
            throws SchedulerException, ParseException{
        Scheduler sched = sf.getScheduler();
    //    JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job.getClass());//任务名，任务组，任务执行类
        //触发器
        CronTrigger  trigger =
     //           new CronTrigger(triggerName, triggerGroupName);//触发器名,触发器组
        trigger.setCronExpression(time);//触发器时间设定
        sched.scheduleJob(jobDetail,trigger);
        if(!sched.isShutdown())
            sched.start();
    }

    */
/** *//*
 */
/**
 * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
 * @param jobName
 * @param time
 * @throws SchedulerException
 * @throws ParseException
 *//*

    public static void modifyJobTime(String jobName,String time)
            throws SchedulerException, ParseException{
        Scheduler sched = sf.getScheduler();
        Trigger trigger =  sched.getTrigger(jobName,TRIGGER_GROUP_NAME);
        if(trigger != null){
            CronTrigger  ct = (CronTrigger)trigger;
            ct.setCronExpression(time);
            sched.resumeTrigger(jobName,TRIGGER_GROUP_NAME);
        }
    }

    */
/** *//*
 */
/**
 * 修改一个任务的触发时间
 * @param triggerName
 * @param triggerGroupName
 * @param time
 * @throws SchedulerException
 * @throws ParseException
 *//*

    public static void modifyJobTime(String triggerName,String triggerGroupName,
                                     String time)
            throws SchedulerException, ParseException{
        Scheduler sched = sf.getScheduler();
        Trigger trigger =  sched.getTrigger(triggerName,triggerGroupName);
        if(trigger != null){
            CronTrigger  ct = (CronTrigger)trigger;
            //修改时间
            ct.setCronExpression(time);
            //重启触发器
            sched.resumeTrigger(triggerName,triggerGroupName);
        }
    }

    */
/** *//*
 */
/**
 * 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
 * @param jobName
 * @throws SchedulerException
 *//*

    public static void removeJob(String jobName)
            throws SchedulerException{
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(jobName,TRIGGER_GROUP_NAME);//停止触发器
        sched.unscheduleJob(jobName,TRIGGER_GROUP_NAME);//移除触发器
        sched.deleteJob(jobName,JOB_GROUP_NAME);//删除任务
    }

    */
/** *//*
 */
/**
 * 移除一个任务
 * @param jobName
 * @param jobGroupName
 * @param triggerName
 * @param triggerGroupName
 * @throws SchedulerException
 *//*

    public static void removeJob(String jobName,String jobGroupName,
                                 String triggerName,String triggerGroupName)
            throws SchedulerException{
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(triggerName,triggerGroupName);//停止触发器
        sched.unscheduleJob(triggerName,triggerGroupName);//移除触发器
        sched.deleteJob(jobName,jobGroupName);//删除任务
    }
}*/
