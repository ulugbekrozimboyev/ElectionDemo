package com.example.ElectionDemo.helpers;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/3/2021 9:43 PM
 */
public class AuthHelper {
    public static boolean isAllowed(String username, String password) {
        return username.contentEquals("admin") && password.contentEquals("password");
    }
}
