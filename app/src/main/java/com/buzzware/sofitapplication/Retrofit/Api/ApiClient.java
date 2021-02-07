package com.buzzware.sofitapplication.Retrofit.Api;
import com.buzzware.sofitapplication.Retrofit.PostService.PostModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
public interface ApiClient {
    @Headers("Accept: application/json")
    @GET("Posts")
    Call<ArrayList<PostModel>> postServiceData();
}
