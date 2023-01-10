package com.cedricm.veterinaryhospital.service.address

import com.cedricm.veterinaryhospital.entity.Address
import com.cedricm.veterinaryhospital.entity.dto.AddressDto

interface AddressService {

  fun findAllAddresses(): List<Address>

  fun findAddressById(id: String): Address

  fun addAddress(addressDto: AddressDto): Address

  fun updateAddress(id: String, addressDto: AddressDto): Address

  fun deleteAddress(id: String)
}