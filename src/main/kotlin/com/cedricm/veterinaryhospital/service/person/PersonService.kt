package com.cedricm.veterinaryhospital.service.person

import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto

interface PersonService {
  fun findAllPersons(): List<Person>
  fun findPersonById(id: String): Person
  fun addPerson(personDto: PersonDto): Person
  fun updatePerson(id: String, personDto: PersonDto): Person
  fun deletePerson(id: String)
}