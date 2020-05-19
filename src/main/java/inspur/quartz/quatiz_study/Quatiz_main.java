package inspur.quartz.quatiz_study;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;

public class Quatiz_main {
    public static void main(String[] args) throws SchedulerException {
        //  SimpleDateFormat simpleDateFormat =new SimpleDateFormat();
//创建调度工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
// 任务调度
        Scheduler scheduler = schedulerFactory.getScheduler();
//获取job信息
        JobDetail jobDetail = JobBuilder.newJob(Quatiz_job.class).withIdentity("job1", "g1").build();
//获取任务调度时间
//        获取触发器信息

        jobDetail.getJobDataMap().put("sunfengchuan", "sunfengchuan1111111");
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("T1", "g1").withSchedule(cronSchedule("0/5 * * * * ?")).build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        System.out.println("任务开始执行");


        remove();
        try {
            Thread.sleep(60000);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("任务调度失败");
        }
    }


    public static void remove() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
//获取job信息
        JobDetail jobDetail = JobBuilder.newJob(Quatiz_job.class).withIdentity("job1", "g1").build();

//获取任务调度时间
//        获取触发器信息

//        jobDetail.getJobDataMap().put("sunfengchuan", "sunfengchuan1111111");
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("T1", "g1").withSchedule(cronSchedule("0/10 * * * * ?")).build();

        TriggerKey key = trigger.getKey();
//        scheduler.pauseTrigger(key);
        scheduler.unscheduleJob(key);

        System.out.println("终止任务");


    }
}
