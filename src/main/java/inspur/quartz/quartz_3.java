/*
package inspur.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

class QuartzTest {

    public static void main(String[] args) throws SchedulerException {

        Scheduler s = new StdSchedulerFactory().getScheduler();
        s.start();

        JobDetail job = JobBuilder.newJob().ofType(Myjob.class)
                .withIdentity("job1", "group1").build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
//              .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 2))
//              .withSchedule(CronScheduleBuilder.cronSchedule("0 30 9 * * ?"))
                .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInHours(2))
                .build();

        s.scheduleJob(job, trigger);

//      s.shutdown(true);
    }

}*/
