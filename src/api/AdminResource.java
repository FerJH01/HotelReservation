package api;

import model.customer.Customer;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AdminResource {

   public static Customer getCustomer(String email){
       return CustomerService.getCustomer(email);

   }

    public static void addRoom(Set<IRoom> rooms){
        ReservationService.addRoom((IRoom) rooms);

   }
//
//    public Collection<IRoom> getAllRooms(){
//
//    }
//
    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();

    }
//
//    public void displayAllReservations(){
//
//    }
}
