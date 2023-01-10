package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Title

class PersonDto (
  var title: Title,
  var lastname: String,
  var firstname: String? = null,
  var birthDay: Int,
  var birthMonth: Int,
  var birthYear: Int,
  var phoneNumber: Number,
  var email : String,
  var streetAndHouseNumber: String,
  var postalCode: String,
  var city: String,
  var country: String = "Germany",
)