package ua.com.spiritus.servises;

import ua.com.spiritus.models.User;


public interface UserService {
   // User findBylogin(String login);

    User findById(Integer id);

    //User save(User user);
}
