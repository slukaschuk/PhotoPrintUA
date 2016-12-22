package ua.com.spiritus.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.spiritus.models.User;

import java.util.List;


public interface UserService extends UserDetailsService {

    User findById(Integer id);

    List<User> findAllUsers();

    void saveUser(User user);

    boolean isUserExist(String login);

    void deleteAllUsers();

    void updateUser(User currentUser);

    void deleteUserById(Integer id);
}
