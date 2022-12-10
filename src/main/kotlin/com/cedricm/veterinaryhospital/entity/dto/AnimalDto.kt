package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Gender

class AnimalDto (
  var name: String,
  var race: String,
  var type: String? = null,
  var gender: Gender,
  var color: String,
  var symptoms: String? = null,
  var day: Short,
  var month: Short,
  var years: Short,
)