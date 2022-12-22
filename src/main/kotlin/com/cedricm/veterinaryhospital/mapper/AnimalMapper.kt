package com.cedricm.veterinaryhospital.mapper

import com.cedricm.veterinaryhospital.entity.Animal
import com.cedricm.veterinaryhospital.entity.dto.AnimalDto
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AnimalMapper {

  fun toAnimal(animalDto: AnimalDto): Animal {
    val day = animalDto.day
    val month = animalDto.month
    val year = animalDto.year
    return Animal(
      null,
      animalDto.name,
      animalDto.race,
      animalDto.type,
      animalDto.gender,
      animalDto.color,
      animalDto.symptoms,
      LocalDate.of(year, month, day),
      animalDto.owner,
    )
  }

  fun toBirthdate(animalDto: AnimalDto): LocalDate {
    val day = animalDto.day
    val month = animalDto.month
    val year = animalDto.year
    return LocalDate.of(year, month, day)
  }
}