package com.cedricm.veterinaryhospital.controller

import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto
import com.cedricm.veterinaryhospital.service.person.PersonServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/veterinary/persons")
class PersonController {
  @Autowired
  private final lateinit var personServiceImpl: PersonServiceImpl

  @GetMapping
  fun findAllPersons(): ResponseEntity<List<Person>> {
    return ResponseEntity.ok(personServiceImpl.findAllPersons())
  }

  @GetMapping("/{id}")
  fun findPersonById(@PathVariable("id") id: String): ResponseEntity<Person> {
    return ResponseEntity.ok(personServiceImpl.findPersonById(id))
  }

  @PostMapping
  fun addPerson(@RequestBody personDto: PersonDto): ResponseEntity<Person> {
    return ResponseEntity.status(HttpStatus.CREATED).body(personServiceImpl.addPerson(personDto))
  }

  @PutMapping("/{id}")
  fun updatePerson(@PathVariable("id") id: String, @RequestBody personDto: PersonDto): ResponseEntity<Person> {
    return ResponseEntity.accepted().body(personServiceImpl.updatePerson(id, personDto))
  }

  @DeleteMapping("/{id}")
  fun deletePerson(@PathVariable("id") id: String): ResponseEntity<Person> {
    personServiceImpl.deletePerson(id)
    return ResponseEntity.noContent().build()
  }
}