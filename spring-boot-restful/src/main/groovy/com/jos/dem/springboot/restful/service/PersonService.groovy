package com.jos.dem.springboot.restful.service

import com.jos.dem.springboot.restful.model.Person

interface PersonService {
  List<Person> getPersons()
  Person getPerson(String uuid)
  Person create(Person person)
  Person update(Person person)
  Person delete(String uuid)
}
