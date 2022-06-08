package com.example.besocialapp;

import android.content.Context;
import android.widget.Toast;

import com.example.besocialapp.models.gorestApiResponse;
import com.example.besocialapp.models.postModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://gorest.co.in/public/v2/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getPosts(OnFetchDataListener listener){
        CallgoApiforPost callgoApi = retrofit.create(CallgoApiforPost.class);
        Call<gorestApiResponse> call = callgoApi.callPosts();



        try{
            call.enqueue(new Callback<gorestApiResponse>() {
                @Override
                public void onResponse(Call<gorestApiResponse> call, Response<gorestApiResponse> response) {

                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Not Successful", Toast.LENGTH_SHORT).show();
                    }
                    List<gorestApiResponse> temp = new ArrayList<gorestApiResponse>();
                    assert response.body() != null;
                    gorestApiResponse t1 = new gorestApiResponse(response.body().getPosts());
                    listener.onFetchData(temp,response.message());
                }

                @Override
                public void onFailure(Call<gorestApiResponse> call, Throwable t) {

                    // Error, going in onFailure rather than onResponse



                    listener.onError("Failed");
                }
            });
        }
        catch (Exception e){
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    public interface CallgoApiforPost{
        @GET("posts")
        Call<gorestApiResponse> callPosts();
    }





}
