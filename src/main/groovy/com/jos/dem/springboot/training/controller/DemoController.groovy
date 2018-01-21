package com.jos.dem.springboot.training.controller

import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping

import com.jos.dem.springboot.training.model.Person

@Controller
class DemoController {

  @RequestMapping('/')
  ModelAndView index(){
    Person person = new Person(nickname:'josdem', email:'joseluis.delacruz@gmail.com')
    ModelAndView modelAndView = new ModelAndView('index')
    modelAndView.addObject(person)
    modelAndView
  }

}
