package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.cache.PostStore;
import org.example.util.Post;

import static spark.Spark.*;
import static spark.Spark.delete;

public class BlogController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void routesInit(PostStore postStore){
        get("/review/All", (req, res) -> {
            res.body(postStore.getSavedPosts());
            res.type("application-json");
            return res.body();
        });
        get("/review/post/:id", (req, res) -> {
            String id = req.params("id");
            res.body(postStore.getSavedPostId(id));
            res.type("application-json");
            return res.body();
        });
        post("/new/post", (req,res) -> {
            Post post = objectMapper.readValue(req.body(), Post.class);
            postStore.addPostToSaved(post);
            res.body("New post saved");
            return res.body();
        });
        delete("/delete",(req,res) -> {
            postStore.deletePosts();
            res.body("All posts deleted");
            return res.body();
        });
        delete("/delete/post/:id",(req,res) -> {
            String id = req.params("id");
            postStore.deletePostId(id);
            res.body("Post with id: "+id+", deleted.");
            return res.body();
        });
    }

}
