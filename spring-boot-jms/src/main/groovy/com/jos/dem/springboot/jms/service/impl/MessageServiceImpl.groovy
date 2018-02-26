package com.jos.dem.springboot.jms.service.impl

import javax.jms.JMSException
import javax.jms.ObjectMessage
import javax.jms.Message
import javax.jms.Session

import org.springframework.stereotype.Service
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator
import org.springframework.jms.annotation.EnableJms
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.springboot.jms.command.Command
import com.jos.dem.springboot.jms.service.MessageService

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
@EnableJms
class MessageServiceImpl implements MessageService {

  @Autowired
  JmsTemplate jmsTemplate

  Logger log = LoggerFactory.getLogger(this.class)

  void sendMessage(final Command command) {
    MessageCreator messageCreator = new MessageCreator() {

      @Override
      public Message createMessage(Session session) throws JMSException {
        ObjectMessage message = session.createObjectMessage()
        message.setObject(command)
        return message
      }
    }

    log.info 'Sending message'
    jmsTemplate.send("destination", messageCreator)
  }

}