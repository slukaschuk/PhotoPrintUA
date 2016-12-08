package ua.com.spiritus.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.spiritus.models.User;
import ua.com.spiritus.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*@Override
    public User findBylogin(String login) {
        return userRepository.findBylogin(login);
    }*/

    @Override
    public User findById(Integer id) {
       return userRepository.findOne(id);
    }

   /* @Override
    public User save(User user) {
        return userRepository.save(user);
    }*/
}
