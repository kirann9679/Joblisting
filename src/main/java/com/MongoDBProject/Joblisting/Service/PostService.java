package com.MongoDBProject.Joblisting.Service;

import com.MongoDBProject.Joblisting.Model.Post;
import com.MongoDBProject.Joblisting.Model.Request.RequestPost;

import java.util.List;

public interface PostService {
    Post savePost(RequestPost requestPost);
    //Post deletePost(int id);
    List<Post> findByText(String text);
}
