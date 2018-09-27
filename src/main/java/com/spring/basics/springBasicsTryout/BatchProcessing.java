package com.spring.basics.springBasicsTryout;

import com.spring.basics.springBasicsTryout.pojo.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchProcessing {

    @Bean
    @StepScope
    FlatFileItemReader<Person> reader() {
        FlatFileItemReader<Person> r = new FlatFileItemReader<>();
        return null;

    }

    @Bean
    JdbcBatchItemWriter<Person> writer() {
        return null;
    }

    @Bean
    Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
            FlatFileItemReader<Person> reader, JdbcBatchItemWriter<Person> writer) {

        Step step = stepBuilderFactory.get("fiel-to-db").<Person,Person>chunk(5).reader(reader).writer(writer).build();

        return jobBuilderFactory.get("etl").start(step).build();
    }

}
