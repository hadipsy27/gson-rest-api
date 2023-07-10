package com.labs;

import com.labs.entity.User;
import com.labs.service.UserService;
import com.labs.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        // Menampilkan semua data
        List<User> userList = userService.getAllUsers();
        System.out.println("Data users:");
        for (User user : userList) {
            System.out.println(user);
        }

        // Menampilkan data dengan id 2
//        User userById = userService.getUserById("2");
//        System.out.println("User with ID 2 :");
//        System.out.println(userById);

        // Menambahkan data baru
//        User newUser = new User("testing1", "testing1", "testing1@example.com", "123 Main testing1");
//        User addedUser = userService.addUser(newUser);
//        System.out.println("Added User:");
//        System.out.println(addedUser);

        // Mengupdate data dengan id 4
//        User updateUser = new User();
//        updateUser.setName("john does");
//        updateUser.setUsername("johndoes");
//        updateUser.setEmail("john.does@example.com");
//        updateUser.setAddress("123 Main st");
//        User updatedUser = userService.updateUser("4", updateUser);
//        System.out.println("Updated User:");
//        System.out.println(updatedUser);

        // Menghapus data dengan id 6
//        boolean isDeleted = userService.deleteUser("6");
//        System.out.println("User Deleted: " + isDeleted);
    }
}