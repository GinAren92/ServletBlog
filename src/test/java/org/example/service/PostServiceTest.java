package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.util.Post;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

class PostServiceTest {
    private final PostService objUnderTest = new PostService();
    private static final ObjectMapper objMapper = new ObjectMapper();
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objMapper.registerModule(javaTimeModule);
        objMapper.setDateFormat(simpleDateFormat);
    }

    @Test
    void getSavedPostsEquals() throws JsonProcessingException {
        //given
        final Collection<Post> testCollectionPost = new ArrayList<>();
        final Post testPost1 = new Post("testTitle","testContent","testAuthor");
        final Post testPost2 = new Post("testTitle2","testContent2","testAuthor3");
        String expected, result;
        //when
        testCollectionPost.add(testPost1);
        testCollectionPost.add(testPost2);
        expected = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testCollectionPost);
        result = objUnderTest.getSavedPosts(testCollectionPost);
        //then
        assertEquals(expected,result);
    }
    @Test
    void getSavedPostsNotEquals() throws JsonProcessingException {
        //given
        final Collection<Post> testCollectionPost = new ArrayList<>();
        final Post testPost1 = new Post("testTitle","testContent","testAuthor");
        final Post testPost2 = new Post("testTitle2","testContent2","testAuthor2");
        final Post testPost3 = new Post("testTitle3","testContent3","testAuthor3");
        String expected, result;
        //when
        testCollectionPost.add(testPost1);
        testCollectionPost.add(testPost2);

        expected = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testCollectionPost);
        testCollectionPost.add(testPost3);
        result = objUnderTest.getSavedPosts(testCollectionPost);
        //then
        assertNotEquals(expected,result);
    }

    @Test
    void getPostById() throws JsonProcessingException {
        //given
        final Post testPost1 = new Post("testTitle","testContent","testAuthor");
        String expected, result;
        //when
        expected = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testPost1);
        result = objUnderTest.getPostById(testPost1);
        //then
        assertEquals(expected,result);
    }
    @Test
    void getPostByIdNotEquals() throws JsonProcessingException {
        //given
        final Post testPost1 = new Post("testTitle","testContent","testAuthor");
        final Post testPost2 = new Post("testTitle2","testContent2","testAuthor3");
        String expected, result;
        //when
        expected = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testPost2);
        result = objUnderTest.getPostById(testPost1);
        //then
        assertEquals(expected,result);
    }
}