package com.cedricm.veterinaryhospital.controller

import com.cedricm.veterinaryhospital.entity.Owner
import com.cedricm.veterinaryhospital.entity.dto.OwnerDto
import com.cedricm.veterinaryhospital.service.owner.OwnerServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/veterinary")
class OwnerController {
  @Autowired
  final lateinit var ownerServiceImpl: OwnerServiceImpl

  @GetMapping
  fun findAllOwners(): ResponseEntity<List<Owner>> {
    return ResponseEntity.ok(ownerServiceImpl.findAllOwners())
  }

  @GetMapping("/{id}")
  fun findOwnerById(@PathVariable("id") id: String): ResponseEntity<Owner> {
    return ResponseEntity.ok(ownerServiceImpl.findOwnerById(id))
  }

  @PostMapping
  fun addOwner(@RequestBody ownerDto: OwnerDto): ResponseEntity<Owner> {
    return ResponseEntity.status(HttpStatus.CREATED).body(ownerServiceImpl.addOwner(ownerDto))
  }

  @PutMapping("/{id}")
  fun updateOwner(@PathVariable("id") id: String, @RequestBody ownerDto: OwnerDto): ResponseEntity<Owner> {
    return ResponseEntity.accepted().body(ownerServiceImpl.updateOwner(id, ownerDto))
  }

  @DeleteMapping("/{id}")
  fun deleteOwner(@PathVariable("id") id: String): ResponseEntity<Owner> {
    ownerServiceImpl.deleteOwner(id)
    return ResponseEntity.noContent().build()
  }
}