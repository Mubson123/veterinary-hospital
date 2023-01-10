package com.cedricm.veterinaryhospital.mapper

import com.cedricm.veterinaryhospital.entity.Address
import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.PersonDto
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class PersonMapper {

  fun toPerson(personDto: PersonDto): Person {
    return Person(
      id = null,
      title = personDto.title,
      lastname = personDto.lastname,
      firstname = personDto.firstname,
      birthdate = toBirthdate(personDto),
      phoneNumber = personDto.phoneNumber,
      email = personDto.email,
      address =  toAddress(personDto)
    )
  }

  fun toBirthdate(personDto: PersonDto): LocalDate {
    val day = personDto.birthDay
    val month = personDto.birthMonth
    val year = personDto.birthYear
    return LocalDate.of(year, month, day)
  }

  fun toAddress(personDto: PersonDto): Address {
    return Address(
      personDto.streetAndHouseNumber,
      personDto.postalCode,
      personDto.city,
      personDto.country
    )
  }
}