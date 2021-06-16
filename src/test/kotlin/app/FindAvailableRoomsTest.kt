package app

import CuzcoHotelApp.rooms.IRoomRepository
import CuzcoHotelApp.rooms.domain.Room
import CuzcoHotelApp.rooms.usecases.FindAvailableRooms
import CuzcoHotelApp.serverAdapter.StaticRoomRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.time.LocalDate
import kotlin.test.assertEquals

internal class FindAvailableRoomsTest{

    val roomRepository = StaticRoomRepository()

    @Test
    @DisplayName("it should return a list with a single room when the hotel has only one room and no reservations")
    fun itShouldReturnAListWithASingleRoomWhenTheHotelHasOnlyOneRoomAndNoReservations() {
        //GIVEN
        val numberOfGuests = 1
        val arrivalDate = LocalDate.of(2021, 6, 16)
        val departureDate = LocalDate.of(2021, 6, 16)
        val expected = listOf(
            Room(
                id = 101,
                floor = 1,
                description = "1 king size bed - A/C - Wi-Fi - private bathroom - wheelchair accessible",
                capacity = 2
            ),
            Room(
                id = 102,
                floor = 1,
                description = "2 queen size beds - A/C - Wi-Fi - private bathroom - wheelchair accessible",
                capacity = 4
            )
        )


        //WHEN
        val actual = FindAvailableRooms(roomRepository).findAvailabilities(arrivalDate, departureDate, numberOfGuests)

        //THEN
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("it should return an empty list when there is one available room but with not enough capacity")
    fun itShouldReturnAnEmptyListWhenThereIsOneAvailableRoomButWithNotEnoughCapacity() {
        //GIVEN
        val numberOfGuests = 1000
        val expected = emptyList<Room>()
        val arrivalDate = LocalDate.of(2021, 6, 16)
        val departureDate = LocalDate.of(2021, 6, 16)

        //WHEN
        val actual = FindAvailableRooms(roomRepository).findAvailabilities(arrivalDate, departureDate, numberOfGuests)

        //THEN
        assertEquals(expected, actual)
    }
}
