package CuzcoHotelApp.rooms.usecases

import CuzcoHotelApp.rooms.IRoomRepository
import CuzcoHotelApp.rooms.domain.Room
import java.time.LocalDate

class FindAvailableRooms(val roomRepository: IRoomRepository) {
    fun findAvailabilities(
        arrivalDate: LocalDate,
        departureDate: LocalDate,
        numberOfGuests: Int
    ) : List<Room> {
        return roomRepository.findRoomsForAmountOfGuests(numberOfGuests)
    }
}
