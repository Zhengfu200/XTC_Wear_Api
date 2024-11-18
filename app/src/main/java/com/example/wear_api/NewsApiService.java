package com.example.wear_api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {
    @GET("generalnews")
    Call<NewsResponse> getNews(@Query("key") String apiKey);
}
