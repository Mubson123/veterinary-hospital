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
@Table(name = "owner")
open class Owner (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  open var id: String? = null,
  @Column
  open var gender: Gender,
  @Column
  open var lastname: String,
  @Column
  open var firstname: String? = null,
  @Column
  open var birthdate: LocalDate,
  ) {

  @ManyToMany(mappedBy = "owner", fetch = FetchType.LAZY,
    cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  @JsonIgnore
  open var animalSet: MutableSet<Animal>? = null

  @OneToOne(mappedBy = "owner", cascade = [CascadeType.ALL])
  @JsonIgnore
  open var address: Address? = null
}