package ua.com.spiritus.servises;

import ua.com.spiritus.models.User;

import java.util.List;


public interface UserService {

    User findById(Integer id);

    List<User> findAllUsers();

    void saveUser(User user);

    boolean isUserExist(String login);

    void deleteAllUsers();

    void updateUser(User currentUser);

    void deleteUserById(Integer id);
}
