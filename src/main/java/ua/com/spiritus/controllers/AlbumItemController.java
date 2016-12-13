package ua.com.spiritus.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.services.AlbumItemService;


@RestController
@Slf4j
public class AlbumItemController {
    private AlbumItemService albumItemService;

    @Autowired
    public void setAlbumItemService(AlbumItemService albumItemService) {
        this.albumItemService = albumItemService;
    }

    //-------------------Retrieve Single Photo--------------------------------------------------------
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Integer id) {
        log.info("Fetching photo with id {}", id);
        AlbumItem albumItem = albumItemService.findById(id);
        if (albumItem == null) {
            log.warn("Photo with id " + id + " not found");
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(albumItemService.getPhotoById(id), headers, HttpStatus.OK);
    }

    //-------------------Create a Photo ID--------------------------------------------------------
    @RequestMapping(value = "/photo/", method = RequestMethod.POST)
    public ResponseEntity<AlbumItem> createPhoto(@RequestBody AlbumItem albumItem, UriComponentsBuilder ucBuilder) {
        albumItemService.save(albumItem);
        log.info("Photo with id " + albumItem.getAlbumItemId() + " was created");
        return new ResponseEntity<AlbumItem>(albumItem, HttpStatus.CREATED);
    }

    //-------------------Upload a Photo --------------------------------------------------------
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.POST)
    public ResponseEntity<AlbumItem> uploadFoto(@PathVariable("id") Integer id,
                                                @RequestParam("file") MultipartFile file) {
        AlbumItem albumItem = albumItemService.findById(id);
        if (albumItem == null) {
            log.warn("Photo with id " + id + " not found");
            return new ResponseEntity<AlbumItem>(HttpStatus.NOT_FOUND);
        } else {
            albumItemService.addPhoto(albumItem, file);
            log.info("Photo with id " + id + " was upload");
            return new ResponseEntity<AlbumItem>(HttpStatus.NO_CONTENT);
        }
    }
}

