package com.example.egyptnews.apiManager;

import java.nio.channels.GatheringByteChannel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit retrofit;
    private static Retrofit getInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static WebServices getApis(){
        return getInstance().create(WebServices.class);
    }
}
