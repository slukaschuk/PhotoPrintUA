package ua.com.spiritus.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.models.User;
import ua.com.spiritus.repositories.AlbumItemRepository;

import java.time.LocalDateTime;

@Service
@Transactional
@Slf4j
public class AlbumItemServiceImpl implements AlbumItemService {
    private AlbumItemRepository albumItemRepository;
    private UserService userService;

    @Autowired
    public void setAlbumItemRepository(AlbumItemRepository albumItemRepository) {
        this.albumItemRepository = albumItemRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AlbumItem save(AlbumItem albumItem) {
        return albumItemRepository.save(albumItem);
    }

    @Override
    public boolean savePhotoForUser(Integer userId, AlbumItem albumItem) {
        boolean saved = false;
        User user = userService.findById(userId);
        if (user!=null){
            albumItem.setUser(user);
            albumItemRepository.save(albumItem);
            saved=true;
        }
        else{
            log.warn("User with id " + userId + " not found");
        }
        return saved;
    }

    @Override
    public boolean isAlbumItemExist(Integer albumItemId) {
        return albumItemRepository.findOne(albumItemId) != null;
    }

    @Override
    public AlbumItem findById(Integer id) {
        return albumItemRepository.findOne(id);
    }

    @Override
    public boolean addPhoto(AlbumItem albumItem, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                albumItem.setImage(bytes);
                albumItem.setItemDate(LocalDateTime.now());
                albumItemRepository.save(albumItem);
                log.info("You successfully uploaded " + file.getOriginalFilename());
                return true;

            } catch (Exception e) {
                log.error("You haven't uploaded " + file.getOriginalFilename() + " => " + e.getMessage());
                return false;
            }
        } else {
            log.warn("You haven't uploaded " + file.getOriginalFilename() + " because file is empty.");
            return false;

        }
    }

    @Override
    public byte[] getPhotoById(Integer id) {
        byte[] photo;
        try {
            AlbumItem albumitem = albumItemRepository.findOne(id);
            photo = albumitem.getImage();
            return photo;
        } catch (Exception e) {
            log.error("Getting photos of data caused the error => " + e.getMessage());
        }
       return new byte[0];
    }
}
