package com.jos.dem.springboot.jms.messengine

import javax.jms.Message
import javax.jms.ObjectMessage

import org.springframework.stereotype.Component
import org.springframework.jms.annotation.JmsListener
import org.springframework.beans.factory.annotation.Autowired

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Component
class MessageListener {

  Logger log = LoggerFactory.getLogger(this.class)

  @JmsListener(destination = "destination", containerFactory = "myJmsContainerFactory")
  void receiveMessage(Message message) {
    Object command =  ((ObjectMessage) message).getObject()
    log.info "Message Received ${command.dump()}"    
  }

}