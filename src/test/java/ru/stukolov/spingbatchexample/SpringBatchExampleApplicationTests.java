package ru.stukolov.spingbatchexample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBatchExampleApplication.class)
@AutoConfigureMockMvc
public class SpringBatchExampleApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void startBatchJob1() throws Exception {
    mvc.perform(get("/run?mode=simple"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello Gradle!"));
  }

  @Test
  public void startBatchJob2() throws Exception {
    mvc.perform(get("/run?mode=simple"))
        .andExpect(status().isOk())
        .andExpect(content().string("Batch started with mode:  simple...."));
  }
  @Test
  public void contextLoads() {
  }

}

