package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PostService {
    private static final ObjectMapper objMapper = new ObjectMapper();
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objMapper.registerModule(javaTimeModule);
        objMapper.setDateFormat(simpleDateFormat);
    }

    public String getSavedPosts(Collection<Post> savedPosts) {

        String allPosts = null;
        try {
            allPosts = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(savedPosts);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return allPosts;
    }
    public String getPostId(Post post){
        String postString = null;
        try {
            postString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(post);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return postString;
    }

}
