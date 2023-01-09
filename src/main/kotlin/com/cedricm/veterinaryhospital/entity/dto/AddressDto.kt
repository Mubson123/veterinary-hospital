package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Person

class AddressDto (
  var streetAndHouseNumber: String,
  var postalCode: String,
  var city: String,
  var person: Person?
)