package com.jos.dem.springboot.mvc.controller

import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.springboot.mvc.model.Person
import com.jos.dem.springboot.mvc.service.PersonService

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
class PersonController {

  @Autowired
  PersonService personService

  Logger log = LoggerFactory.getLogger(this.class)

  @RequestMapping('/')
  ModelAndView index(){
    log.info 'Calling index'
    ModelAndView modelAndView = new ModelAndView('index')
    List<Person> persons = personService.getPersons()
    modelAndView.addObject('persons', persons)
    modelAndView
  }

}
