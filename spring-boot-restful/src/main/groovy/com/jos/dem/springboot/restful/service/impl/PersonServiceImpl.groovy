package com.jos.dem.springboot.restful.service.impl

import org.springframework.stereotype.Service

import com.jos.dem.springboot.restful.service.PersonService
import com.jos.dem.springboot.restful.model.Person

@Service
class PersonServiceImpl implements PersonService {

  private Person person = new Person(nickname:'josdem', email:'joseluis.delacruz@gmail.com')

  List<Person> getPersons(){
    List<Person> persons = []
    persons << person
    persons
  }

  Person getPerson(String uuid){
    person
  }

  Person create(Person person){
    person
  }

  Person update(Person person){
    person
  }

  Person delete(String uuid){
    person
  }


}
