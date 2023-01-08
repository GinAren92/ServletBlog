package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

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

            return res.body();
        });
        post("/new/post", (req,res) -> {
            Post post = objectMapper.readValue(req.body(), Post.class);
            postStore.addPostToSaved(post);
            res.body("Nowy post zapisany");
            return res.body();
        });
        delete("/delete",(req,res) -> {

            return res.body();
        });
        delete("/delete/post/:id",(req,res) -> {
            String id = req.params("id");

            return res.body();
        });
    }

}
