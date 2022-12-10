package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Animal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnimalRepository : JpaRepository<Animal, String> {
}