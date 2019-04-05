package com.scott.sourceProducer.config;

import com.scott.sourceProducer.job.MessageJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class MessageJobConfig {

    @Value("${jobs.message.name}")
    private String name;

    @Value("${jobs.message.schedule}")
    private int schedule;

    @Value("${jobs.message.description}")
    private String description;

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(MessageJob.class)
                .storeDurably()
                .withIdentity(name)
                .withDescription(description)
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity(name)
                .withDescription(description)
                .withSchedule(simpleSchedule()
                        .repeatForever()
                        .withIntervalInSeconds(schedule))
                .build();
    }
}
