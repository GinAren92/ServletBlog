package org.example;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private List<Post> savedPosts = new ArrayList<>();

    public List<Post> getSavedPosts() {
        return savedPosts;
    }

    public Post getSavedPostId(String id) {
        int index = -1;
        Post post = new Post();
        for(int i = 0; i<savedPosts.size();i++){
            if(savedPosts.get(i).getId().equals(id)) {
                post = savedPosts.get(i);
                break;
            }
        }
        return post;
    }

    public void addPostToSaved(Post savedPost) {
        this.savedPosts.add(savedPost);
    }

    public void deletePosts() {
        this.savedPosts.clear();
    }

    public void deletePostId(String id) {
        int index = -1;
        for(int i = 0; i<savedPosts.size();i++){
            if(savedPosts.get(i).getId().equals(id)) index = i;
        }
        if(index>=0) savedPosts.remove(index);
    }


}
