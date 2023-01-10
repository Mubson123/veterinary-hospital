package com.cedricm.veterinaryhospital.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
class Person (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  open var id: String? = null,
  @Column
  open var title: Title? = null,
  @Column
  open var lastname: String? = null,
  @Column
  open var firstname: String? = null,
  @Column
  open var birthdate: LocalDate? = null,
  @Column
  open var phoneNumber: Number? = null,
  @Email
  @Column
  open var email : String? = null,
  @Embedded
  open var address: Address? = null
  ) {

  @ManyToMany(mappedBy = "personSet", fetch = FetchType.LAZY,
    cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  @JsonIgnore
  var animalSet: MutableSet<Animal>? = null
}