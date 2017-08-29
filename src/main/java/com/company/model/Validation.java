package com.company.model;

import org.jasypt.util.password.StrongPasswordEncryptor;

import java.util.regex.*;
import java.util.Scanner;

/**
 * Created by marcking2 on 8/22/17.
 */

public class Validation {
    Scanner scnr = new Scanner(System.in);

    public static boolean validateUserId(String userId) {

        return (userId.matches("^[a-zA-Z_0-9'`]{3,12}$"));
    }

    public static boolean validateEntry(String input) { //validates name Strings up to 35 chars in case Mr. or Mrs. Wolfeschlegelsteinhausenbergerdorff want to register,
        //I mean, lets not get crazy here.

        return (input.matches("^[a-zA-Z_0-9'`]{1,35}$"));

    }

    public static boolean validateEmail(String input) {

        return (input.matches("^([a-zA-Z_0-9.\\-]{1,64}\\@[a-zA-Z_0-9]{1,64}\\.[a-zA-Z_0-9]{1,64})$"));
    }

    public static boolean validatePhoneNumber(String input) {

        return (input.matches("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$"));
    }

    public static boolean validatePassword(String password) {

        return (password.matches("^(?=.*[a-z])|(?=.*d)(?=.*[A-Z])|(?=.*[!@#$?.]).{8,64}"));
    }

    public static String encryptPassword(String password) {
        StrongPasswordEncryptor enc = new StrongPasswordEncryptor();

        String passEncrypted = enc.encryptPassword(password);

        password = passEncrypted;
        return password;
    }
}