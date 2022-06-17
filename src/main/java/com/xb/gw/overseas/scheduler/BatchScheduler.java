package com.xb.gw.overseas.scheduler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Batch Entry Point for Scheduler for all Jobs
 */
@Configuration
@EnableScheduling
@Slf4j
@AllArgsConstructor
public class BatchScheduler {

    private JobLauncher jobLauncher;
    private Job job;

   // @Scheduled(cron = "${batch.overseas.job.cron}")
    public void jScheduler() {
        System.out.println("Begin...........");
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();

        try {
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            System.out.println("started......................");
            System.out.println("Job's Status:::" + jobExecution.getStatus());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
