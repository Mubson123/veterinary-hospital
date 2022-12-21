package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Animal
import com.cedricm.veterinaryhospital.entity.Owner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Repository
@Transactional
interface AnimalRepository : JpaRepository<Animal, String> {
  @Query("SELECT owner FROM Animal a WHERE a.id=:id")
  fun findOwnersByAnimalId(@Param("id") id: String): Optional<List<Owner>>
  @Modifying
  @Query("DELETE FROM Animal a WHERE a.ownerSet.owner=:owner")
  fun deleteByOwner(@Param("owner") owner: Owner): Optional<Void>
}