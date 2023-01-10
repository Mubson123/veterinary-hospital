package service

import com.cedricm.veterinaryhospital.entity.Address
import com.cedricm.veterinaryhospital.entity.Gender
import com.cedricm.veterinaryhospital.entity.Person
import com.cedricm.veterinaryhospital.entity.dto.AddressDto
import java.time.LocalDate
import java.util.UUID

class ServiceTestComponents {

  companion object {
    var id: String = UUID.randomUUID().toString()
    private val person = Person(
      id,
      Gender.Male,
      "Mube",
      "Cedric",
      LocalDate.of(1996, 1,4)
    )
    val addresses: List<Address> = listOf(
      Address(
        "id1",
        "haagstrasse 12",
        "91054",
        "Erlangen",
        person,
      ),
      Address(
        "id2",
        "Kreuzburger strasse 15",
        "90444",
        "Nuremberg",
        person,
      )
    )

    val address = Address(
      "id2",
      "Gebbert-Strasse 14",
      "90443",
      "Nuremberg",
      person,
    )

    val addressDto: AddressDto = AddressDto(
      "Kreuzburger strasse 15",
      "90444",
      "Nuremberg",
      person,
    )
  }
}