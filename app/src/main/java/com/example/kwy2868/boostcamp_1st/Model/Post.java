package com.example.kwy2868.boostcamp_1st.Model;

/**
 * Created by kwy2868 on 2017-07-04.
 */

public class Post {
    // 글쓴이명.
    private String author;
    // 글쓴이 이미지.
    private int author_image;
    // 글 내용.
    private String content;
    // 같이 올린 이미지.
    private int content_image;

    public Post() {
    }

    public Post(String author, int author_image, String content, int content_image) {
        this.author = author;
        this.author_image = author_image;
        this.content = content;
        this.content_image = content_image;
    }

    public String getAuthor() {
        return author;
    }

    public int getAuthor_image() {
        return author_image;
    }

    public String getContent() {
        return content;
    }

    public int getContent_image() {
        return content_image;
    }
}
