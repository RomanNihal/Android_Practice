package com.example.dictionary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface callRetrofit {
    @GET("{word}")
    Call<List<Model>> getData(@Path("word") String word);
}
