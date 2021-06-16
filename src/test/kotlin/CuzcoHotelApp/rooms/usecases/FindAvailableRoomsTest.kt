package CuzcoHotelApp.rooms.usecases

import CuzcoHotelApp.rooms.domain.Room
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

internal class FindAvailableRoomsTest{

    // @Test
    // @DisplayName("it should throw an exception if arrivalDate is after departureDate")
    // fun itShouldThrowAnExceptionIfArrivalDateIsAfterDepartureDate() {
    //     //GIVEN
    //     val arrivalDate = LocalDate.of(2021, 6, 16)
    //     val departureDate = LocalDate.of(2021, 6, 16)
    //     //WHEN //THEN
    //     assertThrows<MinimumNightsException>(
    //         FindAvailableRoom().findAvailabilities(arrivalDate, departureDate)
    //     )
    // }

    @Test
    @DisplayName("it should return a list with a single room when the hotel has only one room and no reservations")
    fun itShouldReturnAListWithASingleRoomWhenTheHotelHasOnlyOneRoomAndNoReservations() {
        //GIVEN
        val numberOfGuests = 1
        val arrivalDate = LocalDate.of(2021, 6, 16)
        val departureDate = LocalDate.of(2021, 6, 16)

        val expected = listOf(Room(
            id = 101,
            floor = 1,
            description = "1 king size bed - A/C - Wi-Fi - private bathroom - wheelchair accessible",
            capacity = 2
        ))

        //WHEN
        val actual = FindAvailableRooms().findAvailabilities(arrivalDate, departureDate, numberOfGuests)

        //THEN
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("it should return an empty list when there is one avaiable room but with not enough capacity")
    fun itShouldReturnAnEmptyListWhenThereIsOneAvaiableRoomButWithNotEnoughCapacity() {
        //GIVEN
        val numberOfGuests = 1000
        val arrivalDate = LocalDate.of(2021, 6, 16)
        val departureDate = LocalDate.of(2021, 6, 16)

        val expected = emptyList<Room>()

        //WHEN
        val actual = FindAvailableRooms().findAvailabilities(arrivalDate, departureDate, numberOfGuests)

        //THEN
        assertEquals(expected, actual)
    }
}