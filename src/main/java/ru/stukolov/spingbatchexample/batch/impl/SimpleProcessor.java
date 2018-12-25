package ru.stukolov.spingbatchexample.batch.impl;

import java.util.logging.Logger;
import ru.stukolov.spingbatchexample.batch.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, String> {
  Logger logger = Logger.getLogger(String.valueOf(SimpleProcessor.class));

  @Override
    public String process(String item) {
      System.out.printf("SimpleProcessor get: %s", item);
      logger.info("MAXXX SimpleProcessor: process()");
      return item;
    }
}
