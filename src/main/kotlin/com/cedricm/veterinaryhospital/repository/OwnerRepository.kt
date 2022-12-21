package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Owner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
@Transactional
interface OwnerRepository : JpaRepository<Owner, String> {
  @Query("SELECT o FROM Owner o WHERE o.id=:id")
  fun findOwnerById(@Param("id") id: String): Optional<Owner>
  @Modifying
  @Query("DELETE FROM Owner o WHERE o.id=:id")
  fun deleteByOwnerId(@Param("id") id: String): Optional<Void>
}