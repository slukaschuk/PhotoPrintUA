package ua.com.spiritus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.repositories.AlbumItemRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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

    @Override
    public boolean addPhoto(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("c:/test/"+file.getOriginalFilename() + "-uploaded")));
                stream.write(bytes);
                stream.close();
                System.out.println("Вы удачно загрузили " + file.getOriginalFilename() + " в " + file.getOriginalFilename() + "-uploaded !");
                return true;

            } catch (Exception e) {
                System.out.println("Вам не удалось загрузить " + file.getOriginalFilename() + " => " + e.getMessage());
                return false;
            }
        } else {
            System.out.println("Вам не удалось загрузить " + file.getOriginalFilename() + " потому что файл пустой.");
            return false;

        }
    }
}
