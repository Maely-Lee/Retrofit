package com.example.retrofit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/restaurant")
    Call<TestItem> getData();

    @FormUrlEncoded
    @POST("api/restaurant")
    Call<TestItem> postData(@Field("name") String name,
                            @Field("numOfLike") int numOfLike,
                            @Field("numOfStar") int numOfStar);

}
