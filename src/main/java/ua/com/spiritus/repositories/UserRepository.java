package ua.com.spiritus.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.spiritus.models.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    User findBylogin(String login);

    @Override
    User save(User user);
}
