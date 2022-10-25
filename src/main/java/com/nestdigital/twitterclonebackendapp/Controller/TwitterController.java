package com.nestdigital.twitterclonebackendapp.Controller;


import com.nestdigital.twitterclonebackendapp.Model.TwitterModel;
import com.nestdigital.twitterclonebackendapp.dao.TwitterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    private TwitterDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping( path = "/signup",consumes = "application/json",produces = "application/json")
    public String SignUp(@RequestBody TwitterModel twitter){
        System.out.println(twitter.toString());
        dao.save(twitter);
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/login",consumes = "application/json",produces = "application/json")
    List<TwitterModel> Login(@RequestBody TwitterModel twitter){
        return (List<TwitterModel>) dao.Signup(twitter.getEmail(), twitter.getPassword());
    }
}
