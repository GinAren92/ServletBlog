package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.*;
import static spark.Spark.delete;

public class BlogController {
    private final ObjectMapper objectMapper = new ObjectMapper();


    public void routesInit(){
        get("/review/All", (req, res) -> {

            return res.body();
        });
        get("/review/post/:id", (req, res) -> {
            String id = req.params("id");

            return res.body();
        });
        post("/new/post", (req,res) -> {

            res.body("Cokolwiek");
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
