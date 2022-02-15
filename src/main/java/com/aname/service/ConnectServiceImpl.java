package com.aname.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConnectServiceImpl implements ConnectService {

  @PostConstruct
  public void connectTest() {
    // connect to me
    try {
      InetAddress address = InetAddress.getByName("196.239.29.173");
      boolean isReachable = address.isReachable(10000);

      log.debug("reached host {}", isReachable);
      log.debug("host {}", ReflectionToStringBuilder.toString(address));

    } catch (IOException e) {
      log.debug("failed to reach", e);
    }
  }
}
