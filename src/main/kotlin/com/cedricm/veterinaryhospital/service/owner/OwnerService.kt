package com.cedricm.veterinaryhospital.service.owner

import com.cedricm.veterinaryhospital.entity.Owner
import com.cedricm.veterinaryhospital.entity.dto.OwnerDto
import kotlin.jvm.Throws

interface OwnerService {
  fun findAllOwners(): List<Owner>
  fun findOwnersByAnimalId(id: String): List<Owner>
  fun addOwner(ownerDto: OwnerDto): Owner
  fun updateOwner(id: String, ownerDto: OwnerDto): Owner
  fun deleteOwner(id: String)
  fun deleteAllAnimals(id: String)
}