package ua.com.spiritus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.spiritus.models.User;
import ua.com.spiritus.servises.UserService;

@Controller

public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/create")
    @ResponseBody
    public String create(String login, String password) {
        User user = null;
        try {
            user = new User(login, password);
            userService.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getUserId() + ")";
    }


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

    @RequestMapping("/get-by-login")
    @ResponseBody
    public String getByLogin(String login) {
        String userId;
        try {
            User user = userService.findBylogin(login);
            userId = String.valueOf(user.getUserId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

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
