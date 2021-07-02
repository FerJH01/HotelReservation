package ui;

import api.AdminResource;
import api.HotelResource;
import model.customer.Customer;
import service.CustomerService;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import static ui.MainMenu.drawMainOptions;

public class AdminMenu {


    public static void drawAdminOptions() {
        boolean t = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (t) {

                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Add Test Data / found customer by email");
                    System.out.println("6. Back to the Main Menu");
                    System.out.println("-------------------------------------------------------");

                    int option = Integer.parseInt(scanner.nextLine());

                    switch (option) {
                        case 1:
                            showAllCustomers();
                            drawAdminOptions();

                            t = false;
                            break;
                        case 2:
                            System.out.println("This is option 2");
                            t = false;
                            break;
                        case 3:
                            System.out.println("This is option 3");
                            t = false;
                            break;
                        case 4:
                            AddRoom();
                            drawAdminOptions();
                            t = false;
                            break;
                        case 5:
                            System.out.println("Please provide an email address: ");
                            Scanner scn = new Scanner(System.in);
                            String email = scn.nextLine();
                            AdminResource.getCustomer(email);
                            drawAdminOptions();
                            t = false;
                            break;
                        case 6:
                            System.out.println("This is option 6");
                            t = false;
                            drawMainOptions();

                        default:
                            System.out.println("Please select a an option from 1 to 6");
                            drawAdminOptions();
                    }
                } catch (NumberFormatException e) {

                    System.out.println("ERROR! Please enter a valid option number." + "\n");
                }
            }
        }
    }

    public static void findCustomerByEmail(){
        String email;
        System.out.println("Please provide an email address: ");
        Scanner scn = new Scanner(System.in);

        email = scn.nextLine();
        Customer foundCustomer = AdminResource.getCustomer(email);
        try {
            if (foundCustomer == null) {
                throw new NullPointerException();

            } else {

                System.out.println(foundCustomer);
                drawAdminOptions();
            }
        } catch (NullPointerException ex){
            System.out.println("No customer found with the provided email address");
            drawAdminOptions();
        }

    }

    public static void showAllCustomers(){

        HashSet <Customer> mySet = (HashSet<Customer>) AdminResource.getAllCustomers();

        for(Customer customer: mySet){

            System.out.println(customer);
            System.out.println("\n");
        }


    }

    public static void AddRoom(){

        AdminResource.addRoom();


    }


}
