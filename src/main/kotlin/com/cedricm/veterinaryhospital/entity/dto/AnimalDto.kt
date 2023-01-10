package com.cedricm.veterinaryhospital.entity.dto

import com.cedricm.veterinaryhospital.entity.Gender

class AnimalDto (
  var name: String,
  var race: String,
  var breed: String? = null,
  var gender: Gender,
  var color: String,
  var symptoms: String? = null,
  var day: Int,
  var month: Int,
  var year: Int,
  var animalOwnerEmails: List<String>,
)