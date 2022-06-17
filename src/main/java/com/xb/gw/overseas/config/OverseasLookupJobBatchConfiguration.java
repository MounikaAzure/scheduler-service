package com.xb.gw.overseas.config;

import com.xb.gw.overseas.entity.Lookup;
import com.xb.gw.overseas.job.listener.OverseasLookupJobExecutionListener;
import com.xb.gw.overseas.job.listener.processor.OverseasLookupProcessListener;
import com.xb.gw.overseas.job.listener.reader.OverseasLookupReaderListener;
import com.xb.gw.overseas.job.listener.writer.OverseasLookupWriterListener;
import com.xb.gw.overseas.job.processor.OverseasLookupProcessor;
import com.xb.gw.overseas.job.reader.OverseasLookupReader;
import com.xb.gw.overseas.job.writer.OverseasLookupWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class OverseasLookupJobBatchConfiguration {

    @Autowired
    JobSchedulerConfigProperties jobSchedulerConfigProperties;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public OverseasLookupJobExecutionListener jobExecutionListener() {
        return new OverseasLookupJobExecutionListener();
    }

    @Bean
    public OverseasLookupReaderListener readerListener() {
        return new OverseasLookupReaderListener();
    }

    @Bean
    public OverseasLookupProcessListener creditCardItemProcessListener() {
        return new OverseasLookupProcessListener();
    }

    @Bean
    public OverseasLookupWriterListener writerListener() {
        return new OverseasLookupWriterListener();
    }

    @Bean
    public Job job(Step step, OverseasLookupJobExecutionListener jobExecutionListener) {
        Job job = jobBuilderFactory.get("overseasLookupJob")
                .listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(OverseasLookupReader reader,
                     OverseasLookupWriter writer,
                     OverseasLookupProcessor processor,
                     OverseasLookupReaderListener readerListener,
                     OverseasLookupProcessListener creditCardItemProcessListener,
                     OverseasLookupWriterListener writerListener) {

        TaskletStep step = stepBuilderFactory.get("step1")
                .<Lookup, Lookup>chunk(jobSchedulerConfigProperties.getOverseasLookupJobSchedulerChunkSize())
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(creditCardItemProcessListener)
                .listener(writerListener)
                .build();
        return step;
    }

}
