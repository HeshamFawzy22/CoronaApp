package com.example.egyptnews;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.egyptnews.model.NewsLiveData;
import com.example.egyptnews.model.NewsResponse;

import java.text.DecimalFormat;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String COVID_19 = "https://coronavirus-19-api.herokuapp.com/countries";

    //Declare
    public NewsLiveData newsLiveData;
    public ProgressDialog progressDialog;
    int egyptPos , worldPos;

    //UI Elements
    protected TextView deathText;
    protected CardView deathCard;
    protected TextView caseText;
    protected CardView caseCard;
    protected TextView recoverText;
    protected CardView recoverCard;
    protected TextView countryName;
    protected TextView countryCase;
    protected TextView countryDeath;
    protected TextView countryRecovered;
    protected CardView countryCard;
    protected Button countryReportCard;
    protected Button refreshCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        getMutableData();

        initView();
    }

    private void showProgress() {
        progressDialog = new ProgressDialog(this, AlertDialog.THEME_HOLO_LIGHT);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }
    private void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    private void getMutableData() {
        showProgress();
        newsLiveData = ViewModelProviders.of(this).get(NewsLiveData.class);
        newsLiveData.getData().observe(this, new Observer<List<NewsResponse>>() {
            @Override
            public void onChanged(List<NewsResponse> newsResponses) {

                hideProgress();

                getWorldNumbers(newsResponses);
                getEgyptNumbers(newsResponses);

            }
        });
        newsLiveData.getNewsResponse();
    }

    private void getEgyptNumbers(List<NewsResponse> newsResponses) {
        for (int i = 0 ; i < newsResponses.size() ; i++){
            if (newsResponses.get(i).getCountry().equals("Egypt"))
                egyptPos = i;
        }
        NewsResponse egypt = newsResponses.get(egyptPos);

        countryName.setText(egypt.getCountry());
        countryDeath.setText(getDecimalFormat(egypt.getDeaths()));
        countryCase.setText(getDecimalFormat(egypt.getCases()));
        countryRecovered.setText(getDecimalFormat(egypt.getRecovered()));
    }

    private void getWorldNumbers(List<NewsResponse> newsResponses) {
        for (int i = 0 ; i < newsResponses.size() ; i++){
            if (newsResponses.get(i).getCountry().equals("World"))
                worldPos = i;
        }
        NewsResponse world = newsResponses.get(worldPos);

        deathText.setText(getDecimalFormat(world.getDeaths()));
        caseText.setText(getDecimalFormat(world.getCases()));
        recoverText.setText(getDecimalFormat(world.getRecovered()));
    }

    private String getDecimalFormat(long number) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(number);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.countryReportCard) {
            startActivity(new Intent(this,WorldList.class));
        }else if (view.getId() == R.id.refreshCard) {
            getMutableData();
        }
    }

    private void initView() {
        deathText = (TextView) findViewById(R.id.deathText);
        deathCard = (CardView) findViewById(R.id.deathCard);
        caseText = (TextView) findViewById(R.id.caseText);
        caseCard = (CardView) findViewById(R.id.caseCard);
        recoverText = (TextView) findViewById(R.id.recoverText);
        recoverCard = (CardView) findViewById(R.id.recoverCard);
        countryName = (TextView) findViewById(R.id.countryName);
        countryCase = (TextView) findViewById(R.id.countryCase);
        countryDeath = (TextView) findViewById(R.id.countryDeath);
        countryRecovered = (TextView) findViewById(R.id.countryRecovered);
        countryCard = (CardView) findViewById(R.id.countryCard);
        countryReportCard = (Button) findViewById(R.id.countryReportCard);
        countryReportCard.setOnClickListener(MainActivity.this);
        refreshCard = (Button) findViewById(R.id.refreshCard);
        refreshCard.setOnClickListener(MainActivity.this);
    }
}
