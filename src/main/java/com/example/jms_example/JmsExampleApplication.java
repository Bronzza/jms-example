package com.example.jms_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsExampleApplication {

	public static void main(String[] args) throws Exception {

//		ActiveMQServer mqServer = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
//				.setPersistenceEnabled(false)
//				.setJournalDirectory("target/data/journal")
//				.setSecurityEnabled(false)
//				.addAcceptorConfiguration("invm", "vm://0"));
//
//		mqServer.start();


		SpringApplication.run(JmsExampleApplication.class, args);
	}

}
