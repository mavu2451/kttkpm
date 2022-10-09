package com.example.ontuan6.app;

import com.example.ontuan6.model.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    @JmsListener(destination = "test")
    public void messageListener(SystemMessage systemMessage){
        LOGGER.info("Da nhan ",systemMessage);
    }
}
