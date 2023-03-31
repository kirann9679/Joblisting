package com.MongoDBProject.Joblisting.Controller;

import com.MongoDBProject.Joblisting.Model.Post;
import com.MongoDBProject.Joblisting.Model.Request.RequestPost;
import com.MongoDBProject.Joblisting.Repository.PostRepository;
import com.MongoDBProject.Joblisting.Service.Impl.PostSeriveImpl;
import com.MongoDBProject.Joblisting.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
PostRepository postRepository;
    @Autowired
    PostSeriveImpl postServiceImpl;
    @GetMapping("/Posts")
    public List<Post> getallPosts(){
        return postRepository.findAll();
    }
    @GetMapping("/filteredPosts/{text}")
    public List<Post> filteredPosts(@PathVariable String text){
        return postServiceImpl.findByText(text);
    }
    @PostMapping("/Post")
    public Post savePost(@RequestBody RequestPost requestPost){
        return postRepository.save(postServiceImpl.savePost(requestPost));
    }
}
