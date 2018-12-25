package ru.stukolov.spingbatchexample.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stukolov.spingbatchexample.service.impl.OMSValidationServiceImpl;
import ru.stukolov.spingbatchexample.service.impl.SnilsValidationServiceImpl;
import ru.stukolov.spingbatchexample.service.impl.PassportValidationServiceImpl;

@RestController
public class BatchManagerController {

  @Autowired
  private PassportValidationServiceImpl passportValidationService;

  @Autowired
  private SnilsValidationServiceImpl snilsValidationService;

  @Autowired
  private OMSValidationServiceImpl omsValidationService;

  @RequestMapping("/passportValidation")
  public String passportValidation(@RequestParam(value = "jobId") String jobId){
    passportValidationService.start(jobId);
    return "Batch started with jobId:  " + jobId;
  }

  @RequestMapping("/snilsValidation")
  public String snilsValidation(@RequestParam(value = "jobId") String jobId){
    snilsValidationService.start(jobId);
    return "Batch started with jobId:  " + jobId;
  }

  @RequestMapping("/omsValidation")
  public String omsValidation(@RequestParam(value = "jobId") String jobId){
    omsValidationService.start(jobId);
    return "Batch started with jobId:  " + jobId;
  }

}
