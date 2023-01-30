package org.example;

import org.example.cache.PostStore;
import org.example.controller.BlogController;
import org.example.service.PostService;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        port(3498);
        PostService postService = new PostService();
        PostStore postStore = new PostStore(postService);
        BlogController blogController = new BlogController();
        blogController.routesInit(postStore);
    }
}