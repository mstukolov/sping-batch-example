package ru.stukolov.spingbatchexample.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stukolov.spingbatchexample.service.ImportService;


@Service
@Log4j
public class OMSValidationServiceImpl implements ImportService {
  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private Job OMSValidationJob;

  @Override
  public void start(String jobId) {

    try {
      JobParameters jobParameters = new JobParametersBuilder().addString("jobId", jobId)
          .toJobParameters();

      JobExecution jobExecution = jobLauncher.run(OMSValidationJob, jobParameters);
      BatchStatus status;
      do {
        status = jobExecution.getStatus();
        //log.info("status = " + status);
        Thread.sleep(1000);
      } while (status != BatchStatus.COMPLETED);
    } catch (JobExecutionAlreadyRunningException e) {
      e.printStackTrace();
    } catch (JobRestartException e) {
      e.printStackTrace();
    } catch (JobInstanceAlreadyCompleteException e) {
      e.printStackTrace();
    } catch (JobParametersInvalidException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
