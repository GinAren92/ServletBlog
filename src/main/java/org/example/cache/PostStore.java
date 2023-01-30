package org.example.cache;

import org.example.util.Post;
import org.example.service.PostService;

import java.util.*;

public class PostStore {
    private final PostService postService;
    private Map<String, Post> savedPosts = new HashMap<>();

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
    public String getSavedPostId(String id) {
        return postService.getPostById(savedPosts.get(id));
    }
    public void deletePostId(String id) {
        savedPosts.remove(id);
    }


}
