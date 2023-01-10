package com.cedricm.veterinaryhospital.mapper

import com.cedricm.veterinaryhospital.entity.Animal
import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.AnimalDto
import com.cedricm.veterinaryhospital.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AnimalMapper {
  @Autowired
  private lateinit var personRepository: PersonRepository

  fun toAnimal(animalDto: AnimalDto): Animal {


    return Animal(
      null,
      animalDto.name,
      animalDto.race,
      animalDto.breed,
      animalDto.gender,
      animalDto.color,
      animalDto.symptoms,
      toBirthdate(animalDto),
      toOwners(animalDto.animalOwnerEmails),
    )
  }

  fun toBirthdate(animalDto: AnimalDto): LocalDate {
    val day = animalDto.day
    val month = animalDto.month
    val year = animalDto.year
    return LocalDate.of(year, month, day)
  }

  fun toPerson(email: String): Person {
    return personRepository.findPersonByEmail(email).orElseThrow ()
  }

  fun toOwners(emails: List<String>): MutableSet<Person> {
    return emails.map(this::toPerson).toMutableSet()
  }
}