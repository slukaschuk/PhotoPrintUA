package ua.com.spiritus.controllers;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.spiritus.models.User;
import ua.com.spiritus.services.UserService;
import ua.com.spiritus.services.UserServiceImpl;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;


public class UserContollerTest {


    private UserController sut = new UserController();
    //system under test
    @Test
    public void shouldValidateEmail(){
    // sut.createUser(new User(), UriComponentsBuilder.newInstance());
    }

}
