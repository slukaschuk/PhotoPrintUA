package ua.com.spiritus.servises;

import ua.com.spiritus.models.User;

/**
 * Created by Spirit on 05.12.2016.
 */
public interface UserService {
    User findBylogin(String login);
    User save(User user);
}
