package ru.stukolov.spingbatchexample.batch;

public interface ItemProcessor<I, O> {
  O process(I item) throws Exception;
}
