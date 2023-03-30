package peaksoft;

import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        // реализуйте алгоритм здесь

        UserServiceImpl userService=new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Bakyt","Latibov",(byte) 22);
        userService.saveUser("Uson","Kanylov",(byte) 23);
        userService.saveUser("Asan","Tairov",(byte) 23);
        userService.saveUser("Timurlan","Kasymbaev",(byte)26);

        userService.removeUserById(2);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();



    }
}
