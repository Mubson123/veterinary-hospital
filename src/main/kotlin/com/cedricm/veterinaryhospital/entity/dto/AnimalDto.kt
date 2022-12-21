package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Gender
import com.cedricm.veterinaryhospital.entity.Owner

class AnimalDto (
  var name: String,
  var race: String,
  var type: String? = null,
  var gender: Gender,
  var color: String,
  var symptoms: String? = null,
  var day: Int,
  var month: Int,
  var year: Int,
  var owner: MutableSet<Owner>? = null,
)