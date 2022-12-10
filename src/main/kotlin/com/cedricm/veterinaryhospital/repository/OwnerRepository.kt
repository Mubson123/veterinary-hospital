package com.cedricm.veterinaryhospital.repository

import com.cedricm.veterinaryhospital.entity.Owner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OwnerRepository : JpaRepository<Owner, String> {
}