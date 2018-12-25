package ru.stukolov.spingbatchexample.batch.impl;

import java.util.logging.Logger;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

public class SimpleItemReader<T> implements org.springframework.batch.item.ItemReader<String> {

  Logger logger = Logger.getLogger(String.valueOf(SimpleItemReader.class));

  @BeforeStep
  public void open() {
    System.out.printf("SimpleItemReader open() : %s", "");
  }

  @Override
  public String read() {
      logger.info("This is custom SimpleItemReader: read()");
      return null;
  }

  @AfterStep
  public void destroy() {
    logger.info("SimpleItemReader destroy(): destroy()");
  }
}
