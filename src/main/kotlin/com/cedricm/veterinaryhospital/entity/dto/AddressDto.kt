package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Owner

class AddressDto (
  var streetAndHouseNumber: String,
  var postalCode: String,
  var city: String,
  var owner: Owner?
)