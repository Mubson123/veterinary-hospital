package com.cedricm.veterinaryhospital.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
open class Person (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  open var id: String? = null,
  @Column
  open var gender: Gender? = null,
  @Column
  open var lastname: String? = null,
  @Column
  open var firstname: String? = null,
  @Column
  open var birthdate: LocalDate? = null,
  ) {

  @ManyToMany(mappedBy = "personSet", fetch = FetchType.LAZY,
    cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  @JsonIgnore
  open var animalSet: MutableSet<Animal>? = null

  @OneToOne(mappedBy = "person", cascade = [CascadeType.ALL])
  @JsonIgnore
  open var address: Address? = null
}