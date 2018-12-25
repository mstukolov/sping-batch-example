package ru.stukolov.spingbatchexample.batch;

import lombok.extern.log4j.Log4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.stukolov.spingbatchexample.batch.impl.SimpleItemReader;
import ru.stukolov.spingbatchexample.batch.impl.SimpleItemWriter;

@Configuration
@Log4j
public class SimpleBatchConfig {
  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public SimpleItemReader<String> customReader() {
    return new SimpleItemReader<>();
  }

  @Bean
  public ItemProcessor<String, String> customProcessor() {
    return value -> value;
  }

  @Bean
  public SimpleItemWriter<String> customWriter() {
    return new SimpleItemWriter();
  }

  @Bean
  public Step mySimpleJobStep1() {
    return stepBuilderFactory.get("step1")
        .<String, String>chunk(10)
        .reader(customReader())
        .processor(customProcessor())
        .writer(customWriter())
        .build();
  }

  @Bean
  public Step loadDataFromCSVStep1() {
    return stepBuilderFactory.get("step1")
        .<String, String>chunk(10)
        .reader(customReader())
        .processor(customProcessor())
        .writer(customWriter())
        .build();
  }

  @Bean
  public Step PassportValidationJobStep1() {
    return stepBuilderFactory.get("step1")
        .<String, String>chunk(10)
        .reader(customReader())
        .processor(customProcessor())
        .writer(customWriter())
        .build();
  }

  @Bean
  public Step SnilsValidationJobStep1() {
    return stepBuilderFactory.get("step1")
        .<String, String>chunk(10)
        .reader(customReader())
        .processor(customProcessor())
        .writer(customWriter())
        .build();
  }

  @Bean
  public Step OMSValidationJobStep1() {
    return stepBuilderFactory.get("step1")
        .<String, String>chunk(10)
        .reader(customReader())
        .processor(customProcessor())
        .writer(customWriter())
        .build();
  }

  @Bean
  public Job passportValidationJob() {
    Job job = jobBuilderFactory.get("PassportValidationJob")
        .incrementer(new RunIdIncrementer())
        .flow(PassportValidationJobStep1())
        .end()
        .build();

    job.isRestartable();
    return job;
  }
  @Bean
  public Job snilsValidationJob() {
    Job job = jobBuilderFactory.get("SnilsValidationJob")
        .incrementer(new RunIdIncrementer())
        .flow(SnilsValidationJobStep1())
        .end()
        .build();

    job.isRestartable();
    return job;
  }

  @Bean
  public Job OMSValidationJob() {
    Job job = jobBuilderFactory.get("OMSValidationJob")
        .incrementer(new RunIdIncrementer())
        .flow(OMSValidationJobStep1())
        .end()
        .build();

    job.isRestartable();
    return job;
  }
}
