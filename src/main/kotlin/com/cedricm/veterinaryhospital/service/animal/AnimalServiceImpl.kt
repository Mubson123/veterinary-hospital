package com.cedricm.veterinaryhospital.service.animal

import com.cedricm.veterinaryhospital.entity.Animal
import com.cedricm.veterinaryhospital.entity.dto.AnimalDto
import com.cedricm.veterinaryhospital.mapper.AnimalMapper
import com.cedricm.veterinaryhospital.repository.AnimalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnimalServiceImpl @Autowired constructor(
  private val animalRepository: AnimalRepository,
  private val animalMapper: AnimalMapper
) : AnimalService {

  override fun findAllAnimals(): List<Animal> {
    return animalRepository.findAll()
  }

  override fun findAnimalById(id: String): Animal {
    return animalRepository
      .findAnimalById(id)
      .orElseThrow { RuntimeException("Can not be found") }

  }

  override fun addAnimal(animalDto: AnimalDto): Animal {
    val animal = animalMapper.toAnimal(animalDto)
    return animalRepository.save(animal)
  }

  override fun updateAnimal(id: String, animalDto: AnimalDto): Animal {
    val animal = animalRepository.findAnimalById(id)
      .orElseThrow { RuntimeException("Can not be updated") }
    animal.name = animalDto.name
    animal.race = animalDto.race
    animal.breed = animalDto.breed
    animal.gender = animalDto.gender
    animal.color = animalDto.color
    animal.symptoms = animalDto.symptoms
    animal.birthdate = animalMapper.toBirthdate(animalDto)
    animal.animalOwners = animalMapper.toOwners(animalDto.animalOwnerEmails)
    return animalRepository.save(animal)
  }

  override fun deleteAnimal(id: String) {
    animalRepository
      .deleteByAnimalId(id)
      .orElseThrow { RuntimeException("Can not be deleted") }
  }
}