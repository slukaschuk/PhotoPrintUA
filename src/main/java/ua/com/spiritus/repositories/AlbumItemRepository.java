package ua.com.spiritus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.spiritus.models.AlbumItem;

@Repository
public interface AlbumItemRepository extends CrudRepository<AlbumItem,Integer>{

}
