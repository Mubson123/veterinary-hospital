package com.cedricm.veterinaryhospital.mapper

import com.cedricm.veterinaryhospital.entity.Owner
import com.cedricm.veterinaryhospital.entity.dto.OwnerDto
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class OwnerMapper {

  fun toOwner(ownerDto: OwnerDto): Owner {

    return Owner(
      null,
      ownerDto.gender,
      ownerDto.lastname,
      ownerDto.firstname,
      toBirthdate(ownerDto)
    )
  }

  fun toBirthdate(ownerDto: OwnerDto): LocalDate {
    val day = ownerDto.day
    val month = ownerDto.month
    val year = ownerDto.year
    return LocalDate.of(year, month, day)
  }
}