package service;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import model.room.Room;
import model.room.RoomType;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReservationService {

    static Set<Room> allRooms = new HashSet<Room>();

    public static void addRoom(IRoom room){
        Room rooms = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
        rooms.setRoomNumber(rooms.getRoomNumber());
        rooms.setPrice(rooms.getRoomPrice());
        rooms.setEnumeration(rooms.getRoomType());
        allRooms.add(rooms);

    }

    public IRoom getARoom(String roomID){

        IRoom foundRoom = null;

        for (IRoom room : allRooms) {

            if (room.getRoomNumber().equals(roomID)) {
                foundRoom = room;

                System.out.println(foundRoom);

            }

        }

        return foundRoom;

    }


}
//
//    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
//
//    }
//
//    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
//
//    }
//
//    public Collection<Reservation> getCustomersReservation(Customer customer){
//
//    }
//
//    public void printAllReservation(){
//
//    }
//}
