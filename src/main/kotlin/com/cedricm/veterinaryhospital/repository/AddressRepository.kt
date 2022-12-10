package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, String> {

}