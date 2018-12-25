package ru.stukolov.spingbatchexample;

import lombok.extern.log4j.Log4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
@Log4j
public class SpringBatchExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBatchExampleApplication.class, args);
  }

}

