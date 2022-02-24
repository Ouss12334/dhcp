package com.aname.config;

import com.aname.service.ConnectService;
import com.aname.service.ConnectServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

  @Bean
  public ConnectService connectService() {
    return new ConnectServiceImpl();
  }

}
