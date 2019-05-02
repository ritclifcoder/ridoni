package com.example.berberuyg;



import com.example.berberuyg.pojos.Places;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlacesAPI {

    @GET("maps/api/place/nearbysearch/json?location=37.874641,32.493156&radius=1900&types=hair_care&key=AIzaSyBrHXjn8rmLfsRq5PKZT-MeILRKzKN--wc")
    Call<Places> getPlaces();
}
