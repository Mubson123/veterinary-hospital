package com.cedricm.veterinaryhospital.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal")
open class Animal (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  open var id: String? = null,
  @Column
  open var name: String,
  @Column
  open var race: String,
  @Column
  open var type: String? = null,
  @Column
  open var gender: Gender,
  @Column
  open var color: String,
  @Column
  open var symptoms: String? = null,
  @Column
  open var birthdate: LocalDate,
  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  @JoinTable(
    name = "animal_owner",
    joinColumns = [JoinColumn(name = "animal_id", referencedColumnName = "owner_id")]
  )
  open var owner: MutableSet<Owner>? = null,
) {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  open var lastRegistration: Date = Date()
}