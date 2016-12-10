package ua.com.spiritus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.repositories.AlbumItemRepository;

@Service
@Transactional
public class AlbumItemServiceImpl implements AlbumItemService {
    private AlbumItemRepository albumItemRepository;

    @Autowired
    public void setAlbumItemRepository(AlbumItemRepository albumItemRepository) {
        this.albumItemRepository = albumItemRepository;
    }

    @Override
    public AlbumItem save(AlbumItem albumItem) {
        return albumItemRepository.save(albumItem);
    }

    @Override
    public boolean isAlbumItemExist(Integer albumItemId) {
        return albumItemRepository.findOne(albumItemId)!=null;
    }

    @Override
    public AlbumItem findById(Integer id) {
        return albumItemRepository.findOne(id);
    }
}
