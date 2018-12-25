package ru.stukolov.spingbatchexample.batch.impl;

import java.util.List;
import java.util.logging.Logger;

public class SimpleItemWriter<T> implements org.springframework.batch.item.ItemWriter<String> {
  Logger logger = Logger.getLogger(String.valueOf(SimpleItemWriter.class));

  @Override
  public void write(List<? extends String> items) {
    logger.info("MAXXX SimpleItemWriter: write() ");
  }
}
