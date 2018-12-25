package ru.stukolov.spingbatchexample.batch;

public interface ItemReader<T> {
  T read() throws Exception;
}
