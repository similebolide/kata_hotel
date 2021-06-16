package app

import CuzcoHotelApp.rooms.usecases.GetRooms
import CuzcoHotelApp.rooms.IRoomRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class GetRoomsTest {

    @Test
    @DisplayName("it should return a list of rooms")
    fun itShouldReturnAListOfRooms() {
        //GIVEN
        val roomStub: IRoomRepository = RoomStub()
        val expected = roomStub.getRoomList()

        //WHEN
        val actual = GetRooms(roomStub).getRooms()

        //THEN
        assertEquals(expected, actual)
    }
}
