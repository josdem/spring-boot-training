package com.jos.dem.springboot.jpa.model

import static javax.persistence.GenerationType.AUTO

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.GeneratedValue

@Entity
class Person{

	@Id
	@GeneratedValue(strategy=AUTO)
  Long id

  @Column(nullable=false)
  String nickname
  
  @Column(unique=true, nullable=false)
  String email
	
}