package service;

import model.customer.Customer;
import ui.AdminMenu;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomerService {

    static Set<Customer> customers = new HashSet<Customer>();

    public static void addCustomer(String firstName, String lastName, String email) {
        Customer newCustomer = new Customer(firstName, lastName, email);
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        newCustomer.setEmail(email);
        customers.add(newCustomer);
    }

    public static void showCustomer() {

        for (Customer newCustomer : customers) {

            System.out.println(newCustomer.getEmail());
            System.out.println(newCustomer.getFirstName());
            System.out.println(newCustomer.getLastName());
        }
    }

    public static Customer getCustomer(String customerEmail) {

        Customer foundCustomer = null;

        for (Customer customer : customers) {

            if (customer.getEmail().equals(customerEmail)) {
                foundCustomer = customer;

                System.out.println("A customer was found with the provided email address");
                break;
            }


        }

        return foundCustomer;

    }

    public static Collection<Customer> getAllCustomers(){

        return customers;

    }

}
