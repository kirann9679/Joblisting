package com.MongoDBProject.Joblisting.Repository;

import com.MongoDBProject.Joblisting.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.print.DocFlavor;
import java.math.BigInteger;

public interface PostRepository extends MongoRepository<Post, BigInteger> {
}
