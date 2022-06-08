package com.example.besocialapp;

import com.example.besocialapp.models.gorestApiResponse;

import java.util.List;

public interface OnFetchDataListener<gorestApiResponse> {
    void onFetchData(List<gorestApiResponse> posts,String message);
    void onError (String message);

}
