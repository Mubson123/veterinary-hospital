package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Gender

class OwnerDto (
  var gender: Gender,
  var lastname: String,
  var firstname: String? = null,
  var day: Short,
  var month: Short,
  var years: Short,
)