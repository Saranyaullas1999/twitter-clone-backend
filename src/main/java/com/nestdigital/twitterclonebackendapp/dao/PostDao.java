package com.nestdigital.twitterclonebackendapp.dao;

import com.nestdigital.twitterclonebackendapp.Model.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostDao extends CrudRepository<PostModel,Integer> {

    @Query(value = "SELECT p.id, p.`post`, p.`posted_date`,u.name,p.user_id FROM `posts` p JOIN users u ON u.id=p.user_id",nativeQuery = true)
    List<Map<String,String>> ViewAllPosts();


    @Query(value = "SELECT p.id, p.`post`, p.`posted_date`,u.name,p.user_id FROM `posts` p JOIN users u ON u.id=p.user_id WHERE p.`user_id` = :user_id",nativeQuery = true)
    List<Map<String,String>> ViewSingle(Integer user_id);
}
