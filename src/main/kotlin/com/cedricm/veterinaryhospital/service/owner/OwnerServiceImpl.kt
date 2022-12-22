package com.cedricm.veterinaryhospital.service.owner

import com.cedricm.veterinaryhospital.entity.Owner
import com.cedricm.veterinaryhospital.entity.dto.OwnerDto
import com.cedricm.veterinaryhospital.mapper.OwnerMapper
import com.cedricm.veterinaryhospital.repository.AddressRepository
import com.cedricm.veterinaryhospital.repository.AnimalRepository
import com.cedricm.veterinaryhospital.repository.OwnerRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OwnerServiceImpl: OwnerService {
  @Autowired
  final lateinit var ownerRepository: OwnerRepository
  @Autowired
  final lateinit var addressRepository: AddressRepository
  @Autowired
  private final val ownerMapper = OwnerMapper()


  override fun findAllOwners(): List<Owner> {
    return ownerRepository.findAll()
  }

  override fun findOwnerById(id: String): Owner {
    return ownerRepository
      .findOwnerById(id)
      .orElseThrow { RuntimeException("Can not be updated") }
  }

  override fun addOwner(ownerDto: OwnerDto): Owner {
    val owner = ownerMapper.toOwner(ownerDto)
    return ownerRepository.save(owner)
  }

  override fun updateOwner(id: String, ownerDto: OwnerDto): Owner {
    val owner = ownerRepository
      .findOwnerById(id)
      .orElseThrow{ RuntimeException("Can not be updated") }
    owner.gender = ownerDto.gender
    owner.lastname = ownerDto.lastname
    owner.firstname = ownerDto.firstname
    owner.birthdate = ownerMapper.toBirthdate(ownerDto)
    return ownerRepository.save(owner)
  }

  override fun deleteOwner(id: String) {
    val owner = ownerRepository
      .findOwnerById(id)
      .orElseThrow{ RuntimeException("Can not be deleted") }
    addressRepository.deleteByOwner(owner)
    ownerRepository.deleteByOwnerId(id)
  }
}