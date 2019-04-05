package com.scott.sourceProducer.job;

import com.scott.sourceProducer.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageJob extends QuartzJobBean {

    @Autowired
    private MessageProducer messageProducer;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        messageProducer.sendMessage();
    }
}
