package com.example.egyptnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.egyptnews.adapters.NewsAdapter;
import com.example.egyptnews.model.NewsLiveData;
import com.example.egyptnews.model.NewsResponse;

import java.util.List;

public class WorldList extends AppCompatActivity {

    //Declare
    NewsAdapter newsAdapter;
    RecyclerView.LayoutManager layoutManager;
    NewsLiveData newsLiveData;

    //UI Elements
    RecyclerView recyclerView;
    EditText searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_list);

        intView();
        getMutableData();
        searchCountry();


    }

    private void searchCountry() {
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                newsAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                newsAdapter.getFilter().filter(s);
            }
        });
    }

    private void intView(){
        recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.search_bar);
    }
    private void getMutableData() {

        newsLiveData = ViewModelProviders.of(this).get(NewsLiveData.class);
        newsLiveData.getData().observe(this, new Observer<List<NewsResponse>>() {
            @Override
            public void onChanged(List<NewsResponse> newsResponses) {
                newsAdapter = new NewsAdapter(newsResponses);
                layoutManager = new LinearLayoutManager(getParent());
                recyclerView.setAdapter(newsAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
        newsLiveData.getNewsResponse();
    }

}
