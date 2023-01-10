package service

import com.cedricm.veterinaryhospital.mapper.AddressMapper
import com.cedricm.veterinaryhospital.repository.AddressRepository
import com.cedricm.veterinaryhospital.service.address.AddressServiceImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals


internal class AddressServiceTest {
  private val addressRepository: AddressRepository = mockk()
  private val addressMapper : AddressMapper = mockk()
  private val uut = AddressServiceImpl(addressRepository, addressMapper)

  @Test
  fun findAllAddressesTest() {
    // given
    val expected = ServiceTestComponents.addresses
    every { addressRepository.findAll() } returns expected

    // when
    val actual = uut.findAllAddresses()

    // then
    verify(exactly = 1) { addressRepository.findAll() }
    assertEquals(expected, actual)
  }

  @Test
  fun findAddressByIdTest() {
    // given
    val id = "id1"
    val expected = ServiceTestComponents.addresses[0]
    every { addressRepository.findById(id) } returns Optional.of(expected)

    // when
    val actual = uut.findAddressById(id)

    // then
    verify(exactly = 1) { addressRepository.findById(id) }
    assertEquals(expected.id, id)
    assertEquals(expected, actual)
  }

  @Test
  fun addAddressTest() {
    // given
    val addressDto = ServiceTestComponents.addressDto
    val expected = ServiceTestComponents.addresses[1]
    every { addressMapper.toAddress(addressDto) } returns expected
    every { addressRepository.save(expected) } returns expected

    // when
    val actual = uut.addAddress(addressDto)

    // then
    verify(exactly = 1) { addressMapper.toAddress(addressDto) }
    verify(exactly = 1) { addressRepository.save(expected) }
    assertEquals(expected, actual)
  }

  @Test
  fun updateAddressTest() {
    // given
    val id = "id2"
    val addressDto = ServiceTestComponents.addressDto
    val oldAddress = ServiceTestComponents.address
    val expected = ServiceTestComponents.addresses[1]
    every { addressRepository.findById(id) } returns Optional.of(oldAddress)
    every { addressRepository.save(oldAddress) } returns expected

    // when
    val actual = uut.updateAddress(id, addressDto)

    // then
    verify(exactly = 1) { addressRepository.findById(id) }
    verify(exactly = 1) { addressRepository.save(oldAddress) }
    assertEquals(actual.id, id)
    assertEquals(actual.postalCode, addressDto.postalCode)
    assertEquals(actual.streetAndHouseNumber, addressDto.streetAndHouseNumber)
    assertEquals(actual.person, addressDto.person)
    assertEquals(expected, actual)
  }

  @Test
  fun deleteAddressTest() {
    // given
    val id = "id2"
    val address = ServiceTestComponents.address
    every { addressRepository.findById(id) } returns Optional.of(address)

    // when
    uut.deleteAddress(id)

    // then
    verify(exactly = 1) { addressRepository.findById(id) }
  }
}