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

import java.util.List;


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
    //-------------------Retrieve All Photo of one user--------------------------------------------------------

    @RequestMapping(value = "/user/{userid}/photo/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumItem>> listAllPhotoForOneUser(@PathVariable("userid") Integer userId) {
        List<AlbumItem> albumItems = albumItemService.findAllPhotoForOneUser(userId);
        if (albumItems.isEmpty()) {
            return new ResponseEntity<List<AlbumItem>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AlbumItem>>(albumItems, HttpStatus.OK);
    }

    //-------------------Retrieve All Photo--------------------------------------------------------
    @RequestMapping(value = "/photo/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumItem>> listAllPhoto() {
        List<AlbumItem> albumItems = albumItemService.findAllPhoto();
        if (albumItems.isEmpty()) {
            return new ResponseEntity<List<AlbumItem>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AlbumItem>>(albumItems, HttpStatus.OK);
    }
    //-------------------Create a Photo ID for user--------------------------------------------------------
    @RequestMapping(value = "/user/{userid}/photo/", method = RequestMethod.POST)
    public ResponseEntity<AlbumItem> createPhotoForUser(@PathVariable("userid") Integer userId, @RequestBody AlbumItem albumItem, UriComponentsBuilder ucBuilder) {
        boolean created = albumItemService.savePhotoForUser(userId, albumItem);
        if (created) {
            log.info("Photo for user with id " + userId + " was created with id" + albumItem.getAlbumItemId());
            return new ResponseEntity<AlbumItem>(albumItem, HttpStatus.CREATED);
        } else {
            log.info("Photo for user with id " + userId + " wasn't created!");
            return new ResponseEntity<AlbumItem>(HttpStatus.BAD_REQUEST);
        }
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

