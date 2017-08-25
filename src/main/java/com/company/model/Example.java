package com.company.model;

import org.jasypt.util.password.StrongPasswordEncryptor;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter your password: ");
            String pass = scan.nextLine();

            //in your DAO or controller you need to instantiate one of these
            StrongPasswordEncryptor enc = new StrongPasswordEncryptor();

            //after you get a new user password from a form
            //before you insert into the DB, do this
            String passEncrypted = enc.encryptPassword(pass);
            //use the encrypted version for the password in the INSERT statement

            System.out.println("Encrypted:\t" + passEncrypted);
            System.out.println("Length:\t" + passEncrypted.length());

            System.out.print("Please re-enter your password to log in: ");
            String pass2 = scan.nextLine();

            //when the user is trying to log in again
            //get the password they enter in the form
            //get the encrypted password from the database
            //pass the form version first argument, encrypted version
            //  from database second argument
            boolean match = enc.checkPassword(pass2, passEncrypted);
            //if the return value of checkPassword is true,
            //return the view with info filled in
            if (match) {
                System.out.println("The password match; you are logged in");
            } else {//if it's false, return a log in again view
                System.out.println("Mismatch--please try again");
            }
        }
    }
}