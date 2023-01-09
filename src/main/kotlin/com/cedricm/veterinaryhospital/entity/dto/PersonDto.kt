package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Gender

class PersonDto (
  var gender: Gender,
  var lastname: String,
  var firstname: String? = null,
  var day: Int,
  var month: Int,
  var year: Int,
)