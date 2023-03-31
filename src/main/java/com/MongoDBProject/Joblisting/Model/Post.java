package com.MongoDBProject.Joblisting.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Component;
import springfox.documentation.schema.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Document(collection="JobPost")
public class Post {
    @Id
    private ObjectId _id;
    private String profile;
    private int experience;
    private String skill[];
    private String description;
    private int id;
}
