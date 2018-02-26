package com.jos.dem.springboot.jms

import javax.jms.ConnectionFactory

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.config.SimpleJmsListenerContainerFactory

@SpringBootApplication
class DemoApplication {

	@Bean
  JmsListenerContainerFactory<SimpleJmsListenerContainerFactory> myJmsContainerFactory(ConnectionFactory connectionFactory) {
    SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory()
    factory.setConnectionFactory(connectionFactory)
    return factory
  }

  static void main(String[] args) {
	  SpringApplication.run DemoApplication, args
  }

}
