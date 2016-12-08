package ua.com.spiritus.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.spiritus.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
   User findBylogin(String login);
}
