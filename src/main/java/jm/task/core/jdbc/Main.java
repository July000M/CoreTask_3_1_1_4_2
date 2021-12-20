package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

            UserService userService = new UserServiceImpl();
   //         userService.removeUserById(1);
//        userService.createUsersTable();

//            System.out.println( userService.getAllUsers());
//            userService.saveUser("Yulia", "Malinovskaya", (byte) 24);
//        userService.saveUser("Nikita", "Mikhonin", (byte) 24);
//        userService.saveUser("Polina", "Vovk", (byte) 24);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

//        userService.dropUsersTable();
        userService.createUsersTable();
//        userService.saveUser("Yulia", "Malinovskaya", (byte) 24);
//        userService.saveUser("Polina", "Vovk", (byte) 24);
//        System.out.println("1");
//        System.out.println("2");
//        userService.dropUsersTable();

//        userService.createUsersTable();
//        System.out.println("3");
//        userService.saveUser("Yulia", "Malinovskaya", (byte) 24);
//        System.out.println("4");
//        // реализуйте алгоритм здесь
    }
}
