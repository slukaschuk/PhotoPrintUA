package ua.com.spiritus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.servises.AlbumItemService;

@RestController
public class AlbumItemController {
    private AlbumItemService albumItemService;

    @Autowired
    public void setAlbumItemService(AlbumItemService albumItemService) {
        this.albumItemService = albumItemService;
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create() {
        AlbumItem albumItem = null;
        try {
            albumItem = new AlbumItem();
            albumItemService.save(albumItem);
        }
        catch (Exception ex) {
            return "Error creating the photo: " + ex.toString();
        }
        return "Photo succesfully created! (id = " + albumItem.getAlbumItemId() + ")";
    }*/
}

