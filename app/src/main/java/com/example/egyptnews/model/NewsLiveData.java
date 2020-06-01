package com.example.egyptnews.model;

import android.util.Log;

import com.example.egyptnews.apiManager.ApiManager;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsLiveData extends ViewModel {

    private MutableLiveData<List<NewsResponse>> data;

    public NewsLiveData() {
        data = new MutableLiveData<>();
    }

    public void getNewsResponse(){
        ApiManager.getApis().getNews()
                .enqueue(new Callback<List<NewsResponse>>() {
                    @Override
                    public void onResponse(Call<List<NewsResponse>> call, Response<List<NewsResponse>> response) {
                        data.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<NewsResponse>> call, Throwable t) {
                        Log.e("Error","Not Found");
                    }
                });
    }

    public MutableLiveData<List<NewsResponse>> getData() {
        return data;
    }

}
