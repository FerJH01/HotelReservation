package api;

import model.customer.Customer;
import service.CustomerService;

public class HotelResource {

   public static Customer getCustomer(String email){
       return CustomerService.getCustomer(email);
   }

    public static void createAcustomer(String firstName, String lastName, String email) {
        CustomerService.addCustomer(firstName, lastName, email);
    }


}

//    public IRoom getRoom(String roomNumber){
//
//    }
//
//    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
//
//
//    }
//
//    public Collection<Reservation> getCustomersReservations(String customerEmail){
//
//
//    }
//
//    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
//
//    }


//}
