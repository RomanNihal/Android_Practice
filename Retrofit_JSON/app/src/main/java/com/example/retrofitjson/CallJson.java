package com.example.retrofitjson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CallJson {

    @GET("comments")
    Call<List<Model>> getList(@Query("postId") String[] id,
                              @Query("_sort") String sort,
                              @Query("_order") String order);

    @GET("posts")
    Call<List<Model>> getList();

    @POST("posts")
    Call<Model> createPost(@Body Model model);

    @FormUrlEncoded
    @POST("posts")
    Call<Model> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body
    );

}
