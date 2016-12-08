package ua.com.spiritus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.spiritus.servises.UserService;
import ua.com.spiritus.models.User;


@RestController
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /*@RequestMapping(value = "/api/users")
    public User create(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
       User user = null;
        try {
            user = new User(login, password);
            userService.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getUserId() + ")";*//*
    }*/


    /*@RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }
*/


    
    //-------------------Retrieve Single User--------------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

   /* @RequestMapping(value = "/api/users/getbylogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getByLogin(@RequestParam(value = "login") String login) {
        User user  = null;
        user       = userService.findBylogin(login);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@RequestParam(value = "id") Integer id) {
        User user  = new User();
        user.getUserId();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }*/
/*
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(Integer id, String login, String password) {
        try {
            User user = userDao.findOne(id);
            user.setLogin(login);
            user.setPassword(password);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
*/


}
