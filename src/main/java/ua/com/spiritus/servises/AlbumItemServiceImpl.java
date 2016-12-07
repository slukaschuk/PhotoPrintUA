package ua.com.spiritus.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.repositories.AlbumItemRepository;

@Service
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
}
