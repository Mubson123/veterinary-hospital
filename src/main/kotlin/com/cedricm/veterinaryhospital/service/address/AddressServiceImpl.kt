package com.cedricm.veterinaryhospital.service.address

import com.cedricm.veterinaryhospital.entity.Address
import com.cedricm.veterinaryhospital.entity.dto.AddressDto
import com.cedricm.veterinaryhospital.mapper.AddressMapper
import com.cedricm.veterinaryhospital.repository.AddressRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class AddressServiceImpl : AddressService {
  @Autowired
  lateinit var addressRepository: AddressRepository
  @Autowired
  val addressMapper = AddressMapper()

  override fun findAllAddress(): List<Address> {
    return addressRepository.findAll()
  }

  override fun findAddressById(id: String): Address {
    return addressRepository.findById(id)
      .orElseThrow { RuntimeException("Can not be found") }
  }

  override fun addAddress(addressDto: AddressDto): Address {
    val address = addressMapper.toAddress(addressDto)
    return addressRepository.save(address)
  }

  override fun updateAddress(id: String, addressDto: AddressDto): Address {
    val address = addressRepository.findById(id)
      .orElseThrow { RuntimeException("Can not be found") }
    address.city = addressDto.city
    address.owner = addressDto.owner
    address.postalCode = addressDto.postalCode
    address.streetAndHouseNumber = addressDto.streetAndHouseNumber
    return addressRepository.save(address)
  }

  override fun deleteAddress(id: String) {
    addressRepository.findById(id)
      .orElseThrow { RuntimeException("Can not be found") }
  }
}