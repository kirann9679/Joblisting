package com.MongoDBProject.Joblisting.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPost {
    private ObjectId _id;
    private String profile;
    private int experience;
    private String skill[];
    private String description;
    private int id;
}
