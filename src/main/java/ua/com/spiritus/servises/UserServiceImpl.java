package ua.com.spiritus.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.spiritus.models.User;
import ua.com.spiritus.repositories.UserRepository;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
       return userRepository.findOne(id);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean isUserExist(String login) {
        return userRepository.findBylogin(login)!=null;
    }

    @Override
    public void updateUser(User currentUser) {
        userRepository.save(currentUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
