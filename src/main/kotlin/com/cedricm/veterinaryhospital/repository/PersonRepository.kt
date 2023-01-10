package com.cedricm.veterinaryhospital.repository

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
interface PersonRepository : JpaRepository<Person, String> {
  @Query("SELECT p FROM Person p WHERE p.id=:id")
  fun findPersonById(@Param("id") id: String): Optional<Person>
  @Modifying
  @Query("DELETE FROM Person p WHERE p.id=:id")
  fun deleteByPersonId(@Param("id") id: String): Optional<Void>
}