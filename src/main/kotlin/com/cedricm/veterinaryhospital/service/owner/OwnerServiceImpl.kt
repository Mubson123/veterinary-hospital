package com.cedricm.veterinaryhospital.service.owner

import com.cedricm.veterinaryhospital.entity.Owner
import com.cedricm.veterinaryhospital.entity.dto.OwnerDto
import com.cedricm.veterinaryhospital.mapper.OwnerMapper
import com.cedricm.veterinaryhospital.repository.AddressRepository
import com.cedricm.veterinaryhospital.repository.AnimalRepository
import com.cedricm.veterinaryhospital.repository.OwnerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OwnerServiceImpl: OwnerService {
  @Autowired
  final lateinit var ownerRepository: OwnerRepository
  @Autowired
  final lateinit var animalRepository: AnimalRepository
  @Autowired
  final lateinit var addressRepository: AddressRepository
  @Autowired
  private final val ownerMapper = OwnerMapper()


  override fun findAllOwners(): List<Owner> {
    return ownerRepository.findAll()
  }

  override fun findOwnersByAnimalId(id: String): List<Owner> {
    return animalRepository.findOwnersByAnimalId(id).orElseThrow()
  }

  override fun addOwner(ownerDto: OwnerDto): Owner {
    val owner = ownerMapper.toOwner(ownerDto)
    return ownerRepository.save(owner)
  }

  override fun updateOwner(id: String, ownerDto: OwnerDto): Owner {
    val owner = ownerRepository.findById(id).orElseThrow()
    owner.gender = ownerDto.gender
    owner.lastname = ownerDto.lastname
    owner.firstname = ownerDto.firstname
    owner.birthdate = ownerMapper.toBirthdate(ownerDto)
    return ownerRepository.save(owner)
  }

  override fun deleteOwner(id: String) {
    val owner = ownerRepository.findById(id).orElseThrow()
    addressRepository.deleteByOwner(owner)
    ownerRepository.deleteByOwnerId(id)
  }

  override fun deleteAllAnimals(id: String) {
    val owner = ownerRepository.findById(id).orElseThrow()
    animalRepository.deleteByOwner(owner)
  }
}