package com.dhcp;

import java.net.DatagramSocket;
import java.net.SocketException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SocketException {
		SpringApplication.run(Application.class, args);
	}

}
