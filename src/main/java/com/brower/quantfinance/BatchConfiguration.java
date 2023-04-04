package com.brower.quantfinance;

import com.brower.quantfinance.simulation.ParameterItemProcessor;
import com.brower.quantfinance.simulation.ParameterItemReader;
import com.brower.quantfinance.simulation.SimulationParameters;
import com.brower.quantfinance.simulation.SimulationResults;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    //Input
    // tag::readerwriterprocessor[]
//    @Bean
//    public FlatFileItemReader<Person> reader() {
//        return new FlatFileItemReaderBuilder<Person>()
//                .name("personItemReader")
//                .resource(new ClassPathResource("sample-data.csv"))
//                .delimited()
//                .names(new String[]{"firstName", "lastName"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                    setTargetType(Person.class);
//                }})
//                .build();
//    }

    public ParameterItemReader reader() {
        return new ParameterItemReader();
    }

    // Processor
    @Bean
    public ParameterItemProcessor processor() {
        return new ParameterItemProcessor();
    }

    // Output
    @Bean
    public JdbcBatchItemWriter<SimulationResults> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<SimulationResults>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
//                .sql("")
                .dataSource(dataSource)
                .build();
    }

    // end::readerwriterprocessor[]

    // Define the job
    // tag::jobstep[]
    @Bean
    public Job marketSimulationJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("marketSimulationJob", jobRepository)
                .preventRestart()
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    // define a single step
    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, JdbcBatchItemWriter writer) {
        return new StepBuilder("step1", jobRepository)
                .<SimulationParameters, SimulationResults> chunk(1, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
    // end::jobstep[]
}
