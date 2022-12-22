package com.cedricm.veterinaryhospital.service.animal

import com.cedricm.veterinaryhospital.entity.Animal
import com.cedricm.veterinaryhospital.entity.dto.AnimalDto

interface AnimalService {
  fun findAllAnimals(): List<Animal>
  fun findAnimalById(id: String): Animal
  fun addAnimal(animalDto: AnimalDto): Animal
  fun updateAnimal(id: String, animalDto: AnimalDto): Animal
  fun deleteAnimal(id: String)
}