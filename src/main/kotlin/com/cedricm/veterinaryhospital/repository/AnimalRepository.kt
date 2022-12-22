package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Animal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
@Transactional
interface AnimalRepository : JpaRepository<Animal, String> {

  @Query("SELECT a FROM Animal a WHERE a.id=:id")
  fun findAnimalById(id: String): Optional<Animal>

  @Modifying
  @Query("DELETE FROM Animal a WHERE a.id=:id")
  fun deleteByAnimalId(id: String): Optional<Void>
}