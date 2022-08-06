package com.pr.java_mvp_retrofit.Model.Api;

import com.pr.java_mvp_retrofit.Model.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Call<List<Posts>> getAllposts();
}
