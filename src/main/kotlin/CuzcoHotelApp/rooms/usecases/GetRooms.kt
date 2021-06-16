package CuzcoHotelApp.rooms.usecases

import CuzcoHotelApp.rooms.IRoomRepository
import CuzcoHotelApp.rooms.domain.Room

class GetRooms(val roomRepository: IRoomRepository){

    fun getRooms() : List<Room> {
        return roomRepository.getRoomList()
    }
}


