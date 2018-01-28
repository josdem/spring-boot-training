package com.jos.dem.springboot.restful.controller

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST
import static org.springframework.web.bind.annotation.RequestMethod.PUT
import static org.springframework.web.bind.annotation.RequestMethod.DELETE

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import com.jos.dem.springboot.restful.service.PersonService
import com.jos.dem.springboot.restful.model.Person
import com.jos.dem.springboot.restful.exception.BusinessException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping('/persons/**')
class PersonController {

  Logger log = LoggerFactory.getLogger(this.class)

  @Autowired
  PersonService personService

  @RequestMapping(method=GET)
  @ResponseBody
  List<Person> getPersons(){
    log.info 'Listing all persons'
    personService.getPersons()
  }

  @RequestMapping(value='/{uuid}' ,method=GET)
  @ResponseBody
  Person getPerson(@PathVariable String uuid){
    log.info "Getting person by uuid: ${uuid}"
    personService.getPerson(uuid)
  }


  @RequestMapping(method=POST, consumes='application/json')
  @ResponseBody
  Person createPerson(@RequestBody Person person){
    log.info "Creating new person: ${person.nickname}"
    personService.create(person)
  }

  @RequestMapping(method=PUT, consumes='application/json')
  @ResponseBody
  Person updatePerson(@RequestBody Person person){
    log.info "Updating person: ${person.nickname}"
    personService.update(person)
  }

  @RequestMapping(value='/{uuid}', method=DELETE)
  @ResponseBody
  Person deletePerson(@PathVariable String uuid){
    log.info "Deleting person with uuid: ${uuid}"
    personService.delete(uuid)
  }

  @ResponseStatus(value=HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(BusinessException.class)
  ResponseEntity<String> handleException(BusinessException be){
    return new ResponseEntity<String>(be.message, HttpStatus.UNAUTHORIZED)
  }

}
