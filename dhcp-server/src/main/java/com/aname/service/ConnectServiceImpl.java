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
      // ip ranges of afgan source https://lite.ip2location.com/afghanistan-ip-address-ranges
      // afgan range 1
      for(int resetCounter=0; resetCounter<2; resetCounter++) {
          String ipToPing = "103.102.220.";
          if (resetCounter == 1) {
            ipToPing = "103.102.221.";
          }
        for (int counter = 0; counter <= 255; counter++) {
          // InetAddress address = InetAddress.getByName("197.16.136.239");
          InetAddress address = InetAddress.getByName(ipToPing.concat(String.valueOf(counter)));
          boolean isReachable = address.isReachable(1000);
          // log.debug("reached host {}", isReachable);
          if (isReachable) {
            log.debug("host {}", address);
          }
        }
      }
    } catch (IOException e) {
      log.debug("failed to reach", e);
    }
  }
}
