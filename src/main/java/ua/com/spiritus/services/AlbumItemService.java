package ua.com.spiritus.services;


import org.springframework.web.multipart.MultipartFile;
import ua.com.spiritus.models.AlbumItem;

public interface AlbumItemService {
    AlbumItem save(AlbumItem albumItem);

    AlbumItem findById(Integer id);

    boolean isAlbumItemExist(Integer albumItemId);

    boolean addPhoto(MultipartFile file);
}
