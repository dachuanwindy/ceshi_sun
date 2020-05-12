package inspur.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class quartz_ceshi {

    public static void main(String[] args) throws Throwable {
        SchedulerFactory factory = new StdSchedulerFactory();
        // 从工厂里面拿到一个scheduler实例
        Scheduler scheduler = factory.getScheduler();
        // 计算任务的开始时间，DateBuilder.evenMinuteDate方法是取下一个整数分钟
        Date runTime = DateBuilder.evenMinuteDate(new Date());
        Date runtimesun = DateBuilder.evenSecondDate(new Date());
        System.out.println("shuhcushijian " + runtimesun);
        // 真正执行的任务并不是Job接口的实例，而是用反射的方式实例化的一个JobDetail实例
        JobDetail job = JobBuilder.newJob(Myjob.class).withIdentity("job1", "group1").build();
        // 定义一个触发器，startAt方法定义了任务应当开始的时间
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        // 将任务和Trigger放入scheduler
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        try {
            // 等待65秒，保证下一个整数分钟出现，这里注意，如果主线程停止，任务是不会执行的
            Thread.sleep(65L * 1000L);
            System.out.println("任务到此一游");
        } catch (Exception e) {

        }
        // scheduler结束
        scheduler.shutdown(true);
    }
}
