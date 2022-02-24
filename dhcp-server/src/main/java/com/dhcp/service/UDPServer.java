package com.dhcp.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UDPServer implements Runnable {

  public DatagramSocket socket;

  public void run() {
    try {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
        String line = scanner.nextLine();

        socket = new DatagramSocket();

        log.debug("sending message");
        socket.send(
            new DatagramPacket(
                line.trim().getBytes(StandardCharsets.UTF_8),
                line.length(),
                InetAddress.getLocalHost(),
                777
            )
        );

        // close server and trim to clear spaces
        if ("end".equalsIgnoreCase(line.trim())) {
          log.debug("closing server");
          System.exit(0);
        }
      }
    } catch (IOException e) {
      log.debug("can't read");
    }
  }
}
