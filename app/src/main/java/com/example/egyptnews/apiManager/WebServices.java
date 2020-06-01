package com.example.egyptnews.apiManager;

import com.example.egyptnews.model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("countries")
    Call<List<NewsResponse>> getNews ();
}
