package com.cedricm.veterinaryhospital.controller

import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto
import com.cedricm.veterinaryhospital.service.person.PersonServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/veterinary")
class OwnerController {
  @Autowired
  final lateinit var ownerServiceImpl: PersonServiceImpl

  @GetMapping
  fun findAllOwners(): ResponseEntity<List<Person>> {
    return ResponseEntity.ok(ownerServiceImpl.findAllPersons())
  }

  @GetMapping("/{id}")
  fun findOwnerById(@PathVariable("id") id: String): ResponseEntity<Person> {
    return ResponseEntity.ok(ownerServiceImpl.findPersonById(id))
  }

  @PostMapping
  fun addOwner(@RequestBody personDto: PersonDto): ResponseEntity<Person> {
    return ResponseEntity.status(HttpStatus.CREATED).body(ownerServiceImpl.addPerson(personDto))
  }

  @PutMapping("/{id}")
  fun updateOwner(@PathVariable("id") id: String, @RequestBody personDto: PersonDto): ResponseEntity<Person> {
    return ResponseEntity.accepted().body(ownerServiceImpl.updatePerson(id, personDto))
  }

  @DeleteMapping("/{id}")
  fun deleteOwner(@PathVariable("id") id: String): ResponseEntity<Person> {
    ownerServiceImpl.deletePerson(id)
    return ResponseEntity.noContent().build()
  }
}