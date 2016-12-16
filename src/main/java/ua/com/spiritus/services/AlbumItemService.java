package ua.com.spiritus.services;


import org.springframework.web.multipart.MultipartFile;
import ua.com.spiritus.models.AlbumItem;

import java.util.List;

public interface AlbumItemService {
    AlbumItem save(AlbumItem albumItem);

    AlbumItem findById(Integer id);

    boolean isAlbumItemExist(Integer albumItemId);

    boolean addPhoto(AlbumItem albumItem, MultipartFile file);

    byte[] getPhotoById(Integer id);

    boolean savePhotoForUser(Integer userId, AlbumItem albumItem);

    List<AlbumItem> findAllPhotoForOneUser(Integer userId);

    List<AlbumItem> findAllPhoto();
}
