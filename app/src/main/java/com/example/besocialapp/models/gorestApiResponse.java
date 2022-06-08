package com.example.besocialapp.models;

import java.util.List;

public class gorestApiResponse {
    List<postModel> posts;

    public List<postModel> getPosts() {
        return posts;
    }

    public void setPosts(List<postModel> posts) {
        this.posts = posts;
    }

    public gorestApiResponse(List<postModel> posts) {
        this.posts = posts;
    }
}
