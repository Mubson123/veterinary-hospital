package com.cedricm.veterinaryhospital.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import java.util.Locale.IsoCountryCode

@Embeddable
class Address (
  @Column
  open var streetAndHouseNumber: String? = null,
  @Column
  open var postalCode: String? = null,
  @Column
  open var city: String? = null,
  @Column
  open var country: String? = null,
)