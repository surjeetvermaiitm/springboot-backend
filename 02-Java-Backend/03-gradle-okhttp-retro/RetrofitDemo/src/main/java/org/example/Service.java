package org.example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/")
    Call<ResponseBody> getResponse();
}
