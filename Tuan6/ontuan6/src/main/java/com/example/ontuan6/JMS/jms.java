package com.example.ontuan6.JMS;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class jms {
   @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
       DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
       jmsListenerContainerFactory.setConcurrency("5-10");
       jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
       return jmsListenerContainerFactory;
   }
}
