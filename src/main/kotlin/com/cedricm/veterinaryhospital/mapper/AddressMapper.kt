package com.cedricm.veterinaryhospital.mapper

import com.cedricm.veterinaryhospital.entity.Address
import com.cedricm.veterinaryhospital.entity.dto.AddressDto
import org.springframework.stereotype.Component

@Component
class AddressMapper {

  fun toAddress(addressDto: AddressDto): Address {
    return Address(
      null,
      addressDto.streetAndHouseNumber,
      addressDto.postalCode,
      addressDto.city,
      addressDto.owner
    )
  }
}