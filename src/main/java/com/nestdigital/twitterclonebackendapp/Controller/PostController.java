package com.nestdigital.twitterclonebackendapp.Controller;


import com.nestdigital.twitterclonebackendapp.Model.PostModel;
import com.nestdigital.twitterclonebackendapp.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    private PostDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addPost",consumes = "application/json",produces = "application/json")
    public String AddPosts(@RequestBody PostModel post)
    {
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate= String.valueOf(dt.format(now));
        post.setPosted_date(currentdate);
        System.out.println(post.toString());
        dao.save(post);
        return "{status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Map<String,String>> Viewpost(){
        return (List<Map<String,String>>) dao.ViewAllPosts();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/single",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> ViewSingle(@RequestBody PostModel post)
    {
        return (List<Map<String,String>>) dao.ViewSingle(post.getUser_id());
    }

}
