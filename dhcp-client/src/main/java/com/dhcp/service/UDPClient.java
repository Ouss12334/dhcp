package com.dhcp.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UDPClient implements Runnable {

  public void run() {
    try {
        DatagramSocket socket = new DatagramSocket(777); // receive on port
        while (true) {
          // create new packet each time to not keep parts of the old message in case the new message is less in length
          DatagramPacket packet = new DatagramPacket(new byte[2000], 2000);
          socket.receive(packet);
          String message = new String(packet.getData());
          log.debug("received message '{}'", message);
          if ("end".equalsIgnoreCase(message.trim())) {
            // have to trim message (has extra spaces, probably from buffer size (2000)
            log.debug("closing client");
            System.exit(0);
          }
        }
    } catch (IOException e) {
      log.debug("can't read");
    }
  }
}
