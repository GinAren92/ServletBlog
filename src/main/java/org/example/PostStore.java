package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.SimpleDateFormat;
import java.util.*;

public class PostStore {
    private final PostService postService;
    private Map<String,Post> savedPosts = new HashMap<>();

    public Collection<Post> getAll(){
        return savedPosts.values();
    }
    public PostStore(PostService postService){
        this.postService=postService;
    }

    public void addPostToSaved(Post savedPost) {
        this.savedPosts.put(savedPost.getId(),savedPost);
    }

    public void deletePosts() {
        this.savedPosts.clear();
    }
    public String getSavedPosts() {
        return postService.getSavedPosts(this.getAll());
    }
    public Post getSavedPostId(String id) {
        return savedPosts.get(id);
    }
    public void deletePostId(String id) {
        savedPosts.remove(id);
    }


}
