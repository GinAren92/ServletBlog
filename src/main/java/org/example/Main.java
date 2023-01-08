package org.example;

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