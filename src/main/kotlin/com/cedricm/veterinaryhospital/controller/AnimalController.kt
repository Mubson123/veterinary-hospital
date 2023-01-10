package com.cedricm.veterinaryhospital.controller

import com.cedricm.veterinaryhospital.entity.Animal
import com.cedricm.veterinaryhospital.entity.dto.AnimalDto
import com.cedricm.veterinaryhospital.service.animal.AnimalServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/veterinary/animals")
class AnimalController {
  @Autowired
  private final lateinit var animalServiceImpl: AnimalServiceImpl

  @GetMapping
  fun findAllAnimals(): ResponseEntity<List<Animal>> {
    return ResponseEntity.ok(animalServiceImpl.findAllAnimals())
  }

  @GetMapping("/{id}")
  fun findAnimalById(@PathVariable("id") id: String): ResponseEntity<Animal> {
    return ResponseEntity.ok(animalServiceImpl.findAnimalById(id))
  }

  @PostMapping
  fun addAnimal(@RequestBody animalDto: AnimalDto): ResponseEntity<Animal> {
    return ResponseEntity.status(HttpStatus.CREATED).body(animalServiceImpl.addAnimal(animalDto))
  }

  @PutMapping("/{id}")
  fun updateAnimal(@PathVariable("id") id: String, @RequestBody animalDto: AnimalDto): ResponseEntity<Animal> {
    return ResponseEntity.accepted().body(animalServiceImpl.updateAnimal(id, animalDto))
  }

  @DeleteMapping("/{id}")
  fun deleteAnimal(@PathVariable("id") id: String): ResponseEntity<Animal> {
    animalServiceImpl.deleteAnimal(id)
    return ResponseEntity.noContent().build()
  }
}