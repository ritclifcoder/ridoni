package com.example.berberuyg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;


import com.example.berberuyg.pojos.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);

    }

    public void getPlaces(View view) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://maps.googleapis.com/").addConverterFactory(GsonConverterFactory.create()).build();
        PlacesAPI placesAPI = retrofit.create(PlacesAPI.class);
        Call<Places> call = placesAPI.getPlaces();
        call.enqueue(new Callback<Places>() {
            @Override
            public void onResponse(Call<Places> call, Response<Places> response) {
                Places myPlaces = response.body();
                listView.setAdapter(new CustomAdapter(MainActivity.this,myPlaces));
            }

            @Override
            public void onFailure(Call<Places> call, Throwable t) {

            }
        });
    }
}
