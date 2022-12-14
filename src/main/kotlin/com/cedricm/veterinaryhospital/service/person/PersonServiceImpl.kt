package com.cedricm.veterinaryhospital.service.person

import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto
import com.cedricm.veterinaryhospital.exception.ResourceNotFoundException
import com.cedricm.veterinaryhospital.mapper.PersonMapper
import com.cedricm.veterinaryhospital.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl @Autowired constructor(
  private val personRepository: PersonRepository,
  private val personMapper: PersonMapper
) : PersonService {

  override fun findAllPersons(): List<Person> {
    return personRepository.findAll()
  }

  override fun findPersonById(id: String): Person {
    return personRepository
      .findPersonById(id)
      .orElseThrow { ResourceNotFoundException("Given person can not be found") }
  }

  override fun addPerson(personDto: PersonDto): Person {
    val owner = personMapper.toPerson(personDto)
    return personRepository.save(owner)
  }

  override fun updatePerson(id: String, personDto: PersonDto): Person {
    val person = personRepository
      .findPersonById(id)
      .orElseThrow { ResourceNotFoundException("Given person can not be found") }
    person.title = personDto.title
    person.lastname = personDto.lastname
    person.firstname = personDto.firstname
    person.birthdate = personMapper.toBirthdate(personDto)
    return personRepository.save(person)
  }

  override fun deletePerson(id: String) {
    val person = personRepository
      .findPersonById(id)
      .orElseThrow { ResourceNotFoundException("Given person can not be found") }
    personRepository.delete(person)
  }
}