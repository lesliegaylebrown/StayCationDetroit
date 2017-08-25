package com.company.model;

import java.util.Scanner;

/**
 * Created by marcking2 on 8/22/17.
 */

public class ValidationTest {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        boolean loop;
        boolean validId;

        do {

            System.out.print("Enter your choice for your  User ID\n(User ID must be at least 6 to 12 characters long): ");

            String userId = scnr.nextLine();

            validId = Validation.validateUserId(userId);

            if (!validId) {
                System.out.println("Invalid Entry.\nUser ID must be at least 6 to 12 characters long.");
                loop = true;

            } else {

                loop = false;
            }
        } while (loop);

        do {
            loop = true;

            System.out.print("Enter your First Name: ");

            String fname = scnr.nextLine();

            boolean userEntry = Validation.validateEntry(fname);

            if (!userEntry) {
                System.out.print("Invalid Entry.\nEnter your First Name: ");
                loop = true;

            } else {

                loop = false;
            }
        } while (loop);

        do {

            System.out.print("Enter your Last Name: ");

            loop = true;

            String lname = scnr.nextLine();

            boolean userEntry = Validation.validateEntry(lname);

            if (!userEntry) {
                System.out.print("Invalid Entry.\nEnter your Last Name: ");
                loop = true;

            } else {

                loop = false;
            }
        } while (loop);


        do {

            System.out.print("Enter your eMail address: ");

            loop = true;

            String email = scnr.nextLine();

            boolean userEntry = Validation.validateEmail(email);

            if (!userEntry) {
                System.out.println("Invalid Entry.\nPlease enter a valid email address.");
                loop = true;

            } else {

                loop = false;
            }
        } while (loop);

        do {

            System.out.print("Enter your Phone number: ");

            loop = true;

            String cphone = scnr.nextLine();

            boolean userEntry = Validation.validatePhoneNumber(cphone);

            if (!userEntry) {
                System.out.print("Please enter a valid phone number\n (ex:9999999999, 1-999-999-9999 and 999-999-9999):");
                loop = true;

            } else {

                loop = false;
            }
        } while (loop);

        do {



            System.out.print("Password must be at least 8, but less than 60 characters long. Password must include one of each, " +
                    "a capital letter, a lower case letter, a number, and one of these symbols (! @ # $ ?)\nEnter your password: ");

//            loop = true;

            String password = scnr.nextLine();
            System.out.print("Re-enter your password: ");
            String password2 = scnr.nextLine();

            boolean userEntry = Validation.validatePassword(password, password2);

            if (!userEntry) {
                System.out.println("Invalid entry\nPlease enter a valid password.");
                loop = true;

            } else {

                loop = false;
            }
        } while (loop);
    }
}
