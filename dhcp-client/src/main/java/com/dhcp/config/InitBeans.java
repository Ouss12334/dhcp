package com.dhcp.config;

import com.dhcp.service.UDPClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
public class InitBeans {

  @Bean
  public TaskExecutor taskExecutor() {
    return new SimpleAsyncTaskExecutor("dhcp-client-");
  }

  @Bean
  @DependsOn("taskExecutor")
  public CommandLineRunner udpServer(
      @Qualifier("taskExecutor") TaskExecutor executor) {
    return args -> executor.execute(new UDPClient());
  }
}
