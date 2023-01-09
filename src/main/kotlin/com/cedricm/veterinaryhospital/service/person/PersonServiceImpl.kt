package com.cedricm.veterinaryhospital.service.person

import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto
import com.cedricm.veterinaryhospital.mapper.PersonMapper
import com.cedricm.veterinaryhospital.repository.AddressRepository
import com.cedricm.veterinaryhospital.repository.PersonRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class PersonServiceImpl : PersonService {
  @Autowired
  final lateinit var personRepository: PersonRepository
  @Autowired
  final lateinit var addressRepository: AddressRepository
  @Autowired
  lateinit var personMapper : PersonMapper


  override fun findAllPersons(): List<Person> {
    return personRepository.findAll()
  }

  override fun findPersonById(id: String): Person {
    return personRepository
      .findOwnerById(id)
      .orElseThrow { RuntimeException("Given person can not be found") }
  }

  override fun addPerson(personDto: PersonDto): Person {
    val owner = personMapper.toPerson(personDto)
    return personRepository.save(owner)
  }

  override fun updatePerson(id: String, personDto: PersonDto): Person {
    val owner = personRepository
      .findOwnerById(id)
      .orElseThrow{ RuntimeException("Given person can not be found") }
    owner.gender = personDto.gender
    owner.lastname = personDto.lastname
    owner.firstname = personDto.firstname
    owner.birthdate = personMapper.toBirthdate(personDto)
    return personRepository.save(owner)
  }

  override fun deletePerson(id: String) {
    val owner = personRepository
      .findOwnerById(id)
      .orElseThrow{ RuntimeException("Given person can not be found") }
    addressRepository.deleteByOwner(owner)
    personRepository.deleteByOwnerId(id)
  }
}