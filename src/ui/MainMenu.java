package ui;


import api.HotelResource;
import service.CustomerService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {

    public static void drawMainOptions() {
        boolean t = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (t) {

                try {
                    System.out.println("\n");
                    System.out.println("Welcome to the Hotel Reservation Application");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an Account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Please enter an option number: ");
                    int option = Integer.parseInt(scanner.nextLine());

                    switch (option) {
                        case 1 -> {
                            System.out.println("This is option 1");
                            t = false;
                        }
                        case 2 -> {
                            System.out.println("This is option 2");

                            t = false;
                        }
                        case 3 -> {
                            createAnAccount();
                            t = false;
                        }
                        case 4 -> {
                            System.out.println("This is option 4");
                            AdminMenu.drawAdminOptions();
                            t = false;
                        }
                        case 5 -> {
                            System.out.println("The application will end now");
                            System.exit(-1);
                        }
                        default -> System.out.println("Please select a correct option from 1 to 5");
                    }
                } catch (NumberFormatException e) {

                    System.out.println("ERROR! Please enter a valid option number." + "\n");


                }


            }


        }


    }

    public static void createAnAccount() {
        final String emailRegex = "^(.+)@(.+).(.+)$";
        final String nameRegex = "^[\\p{L} .'-]+$";

        final Pattern pattern = Pattern.compile(emailRegex);
        final Pattern patternName = Pattern.compile(nameRegex);

        boolean t = true;
        Scanner scan = new Scanner(System.in);

        while (t) {
            try {
                System.out.println("To create an account please enter your email: ");
                String email = scan.nextLine();

                while(HotelResource.getCustomer(email)!=null){
                    System.out.println("Please provide a different email address: " + "\n");
                    email = scan.nextLine();
                }

                System.out.println("Enter your First Name: ");
                String firstName = scan.nextLine();

                System.out.println("Enter your Last Name: ");
                String lastName = scan.nextLine();

                if (pattern.matcher(email).matches() && patternName.matcher(firstName).matches() && patternName.matcher(lastName).matches()) {

                    HotelResource.createAcustomer(firstName, lastName, email);

                    t = false;

                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {

                System.out.println("Either your email, First Name or Last Name are incorrect. Please enter valid information" + "\n");

            }
        }

        drawMainOptions();
    }

}




