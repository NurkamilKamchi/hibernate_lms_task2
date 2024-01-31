package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
//        userService.dropUsersTable();
//        userService.createUsersTable();
//        userService.saveUser("Nurkamil","asfvsdf",(byte) 62);
//        userService.removeUserById(1L);
//        System.out.println(userService.getAllUsers());
         userService.cleanUsersTable();

    }
}
