package ua.com.spiritus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.spiritus.models.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles,Integer>{
}
