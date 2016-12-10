package ua.com.spiritus.services;


import ua.com.spiritus.models.AlbumItem;

public interface AlbumItemService {
    AlbumItem save(AlbumItem albumItem);

    AlbumItem findById(Integer id);

    boolean isAlbumItemExist(Integer albumItemId);
}
