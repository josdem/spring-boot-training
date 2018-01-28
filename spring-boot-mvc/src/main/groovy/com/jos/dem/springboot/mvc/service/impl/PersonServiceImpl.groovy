package com.jos.dem.springboot.mvc.service

import org.springframework.stereotype.Service
import com.jos.dem.springboot.mvc.model.Person

@Service
class PersonServiceImpl implements PersonService {

  List<Person> getPersons(){
    List<Person> persons = []
    Person person = new Person(nickname:'josdem', email:'joseluis.delacruz@gmail.com')
    persons << person
    persons
  }

}
