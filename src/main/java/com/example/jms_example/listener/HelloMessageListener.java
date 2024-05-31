package com.example.jms_example.listener;

import com.example.jms_example.config.JmsConfig;
import com.example.jms_example.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloMessageListener {

    private final JmsTemplate template;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloMessage, @Headers MessageHeaders headers, Message message) {
        System.out.println("I got a message");
        System.out.println(helloMessage);
    }

    @JmsListener(destination = JmsConfig.MY_SEND_AND_RECEIVE_QUEUE)
    public void listenAndReply(@Payload HelloWorldMessage helloMessage, @Headers MessageHeaders headers, Message message) throws JMSException {
        HelloWorldMessage msgToReturn = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("World")
                .build();

        template.convertAndSend(message.getJMSReplyTo(), msgToReturn);
    }
}
