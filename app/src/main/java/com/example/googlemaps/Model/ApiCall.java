package com.example.googlemaps.Model;

import com.example.googlemaps.ModelFlickr.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCall {
    String apikey = "79d466885188b99d6762980d64029892";



/*    @GET("json?lat=36.7201600&lng=-4.4203400")
    Call<ModelApi> getData();*/
/*

    @GET("json?lat=3.4&long=3.5")
    Call<ModelApi> getData(@Query("lat") String lat, @Query("lng") String lng);
*/

    @GET("json/{lat}/{lng}")
    Call<ModelApi> getAddress(@Path("lat") String lat, @Path("lng") String lng);


    @GET("?method=flickr.photos.search&api_key=" + apikey + "&format=json&nojsoncallback=1")
    Call<Results> getData(@Query("lat") String lat, @Query("lon") String lon);
}

