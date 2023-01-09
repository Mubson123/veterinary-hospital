package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Address
import com.cedricm.veterinaryhospital.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
@Transactional
interface AddressRepository : JpaRepository<Address, String> {
  @Modifying
  @Query("DELETE FROM Address a WHERE a.person=:owner")
  fun deleteByOwner(@Param("owner") person: Person): Optional<Void>
}