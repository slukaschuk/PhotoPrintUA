package ua.com.spiritus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.spiritus.enums.Role;
import ua.com.spiritus.models.User;
import ua.com.spiritus.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
        return userRepository.findBylogin(login) != null;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findBylogin(username);
        if (user != null) {
            return (UserDetails) user;
        } else {
            throw new UsernameNotFoundException("user " + username + " was not found");
        }
    }

    @PostConstruct
    public void init() {
        if (userRepository.findBylogin("admin") == null) {
            User user = new User();
            //User user = userRepository.findBylogin("admin");
            user.setLogin("admin");
            user.setFirtsName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("123"));
            List role = new ArrayList<Role>();
            role.add(Role.ADMIN);
            user.setAuthorities(role);
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            userRepository.save(user);
        }
    }
}
