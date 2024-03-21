package org.example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "https://example.com/";

        Retrofit rf = new Retrofit.Builder().baseUrl(url).build();
        Service svc = rf.create(Service.class);

        Call<ResponseBody> call = svc.getResponse();

        try {
            Response<ResponseBody> response = call.execute();
            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}