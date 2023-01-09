package com.cedricm.veterinaryhospital.mapper

import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class PersonMapper {

  fun toPerson(personDto: PersonDto): Person {

    return Person(
      null,
      personDto.gender,
      personDto.lastname,
      personDto.firstname,
      toBirthdate(personDto)
    )
  }

  fun toBirthdate(personDto: PersonDto): LocalDate {
    val day = personDto.day
    val month = personDto.month
    val year = personDto.year
    return LocalDate.of(year, month, day)
  }
}