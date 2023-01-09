package com.cedricm.veterinaryhospital.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.Date

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Animal")
open class Animal (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  open var id: String? = null,
  @Column
  open var name: String? = null,
  @Column
  open var race: String? = null,
  @Column
  open var breed: String? = null,
  @Column
  open var gender: Gender? = null,
  @Column
  open var color: String? = null,
  @Column
  open var symptoms: String? = null,
  @Column
  open var birthdate: LocalDate? = null,
  @ManyToMany(fetch = FetchType.LAZY,
    cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  open var personSet: MutableSet<Person>? = mutableSetOf(),
) {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  open var lastRegistration: Date = Date()
}