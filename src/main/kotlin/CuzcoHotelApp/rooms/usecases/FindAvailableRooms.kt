package CuzcoHotelApp.rooms.usecases

import CuzcoHotelApp.rooms.domain.Exceptions.MinimumNightsException
import CuzcoHotelApp.rooms.domain.Room
import java.time.LocalDate

class FindAvailableRooms() {
    fun findAvailabilities(
        arrivalDate: LocalDate,
        departureDate: LocalDate,
        numberOfGuests: Int
    ) : List<Room> {
        return listOf(Room(
            id = 101,
            floor = 1,
            description = "1 king size bed - A/C - Wi-Fi - private bathroom - wheelchair accessible",
            capacity = 2
        ))
    }
}