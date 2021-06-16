package CuzcoHotelApp.rooms

import CuzcoHotelApp.rooms.domain.Room

interface IRoomRepository {
    fun getRoomList(): List<Room>
}
