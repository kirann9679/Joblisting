package com.MongoDBProject.Joblisting.Service.Impl;

import com.MongoDBProject.Joblisting.Model.Post;
import com.MongoDBProject.Joblisting.Model.Request.RequestPost;
import com.MongoDBProject.Joblisting.Repository.PostRepository;
import com.MongoDBProject.Joblisting.Service.PostService;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import java.util.Arrays;
import org.bson.Document;

@Service
public class PostSeriveImpl implements PostService {
    @Autowired
    Post post;
    @Autowired
    PostRepository postRepository;
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Override
    public Post savePost(RequestPost requestPost) {
        post.setId(requestPost.getId());
        post.setSkill(requestPost.getSkill());
        post.setProfile(requestPost.getProfile());
        return post;
    }

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts=new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("myDB");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default").append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("profile", "description", "skill")))),
                new Document("$sort",
                        new Document("experience", 1L)),
                new Document("$limit", 3L)));
        result.forEach(document -> posts.add(mongoConverter.read(Post.class,document)));
        return posts;
    }


}
