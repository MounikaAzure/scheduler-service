package com.xb.gw.overseas.job.listener;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OverseasLookupJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.debug("beforeJob");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.debug("afterJob: {} " , jobExecution.getStatus());
    }
}