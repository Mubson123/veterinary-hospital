package com.cedricm.veterinaryhospital.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
open class Address (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  open var id: String? = null,
  @Column
  open var streetAndHouseNumber: String,
  @Column
  open var postalCode: String,
  @Column
  open var city: String,
  @OneToOne(cascade = [CascadeType.ALL])
  open var owner: Owner?,
)