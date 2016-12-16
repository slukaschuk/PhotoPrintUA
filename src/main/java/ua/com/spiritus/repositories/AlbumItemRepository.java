package ua.com.spiritus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.models.User;

import java.util.List;

@Repository
public interface AlbumItemRepository extends CrudRepository<AlbumItem,Integer>{


    List<AlbumItem> findAllByUser(User user);
}
