package ua.com.spiritus.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumItem> getUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching photo with id " + id);
        log.debug("Fetching photo with id {}",id);
        AlbumItem albumItem = albumItemService.findById(id);
        if (albumItem == null) {
            System.out.println("Photo with id " + id + " not found");
            return new ResponseEntity<AlbumItem>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AlbumItem>(albumItem, HttpStatus.OK);
    }

    //-------------------Create a Photo ID--------------------------------------------------------
    @RequestMapping(value = "/photo/", method = RequestMethod.POST)
    public ResponseEntity<AlbumItem> createUser(@RequestBody AlbumItem albumItem, UriComponentsBuilder ucBuilder) {

        albumItemService.save(albumItem);
        return new ResponseEntity<AlbumItem>(albumItem, HttpStatus.CREATED);
    }


}

