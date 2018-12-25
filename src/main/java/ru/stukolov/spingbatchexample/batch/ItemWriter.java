package ru.stukolov.spingbatchexample.batch;

import java.util.List;

public interface ItemWriter<T> {
  void write(List<? extends T> items) throws Exception;
}
