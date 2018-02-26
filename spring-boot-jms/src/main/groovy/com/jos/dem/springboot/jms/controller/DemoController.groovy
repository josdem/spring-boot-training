package com.jos.dem.springboot.jms.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.springboot.jms.command.Command
import com.jos.dem.springboot.jms.command.PersonCommand
import com.jos.dem.springboot.jms.service.MessageService

@RestController
class DemoController {

	@Autowired
  MessageService messageService

  @RequestMapping('/')
  String index(){
  	Command person = new PersonCommand(nickname:'josdem', email:'joseluis.delacruz@gmail.com')
  	messageService.sendMessage(person)
  	'Java Message Service'
  }
	
}