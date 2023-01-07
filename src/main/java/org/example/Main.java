package org.example;
import java.time.LocalDateTime;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        port(3498);
        Blog blog = new Blog();
        BlogController blogController = new BlogController();
        blogController.routesInit();
    }
}