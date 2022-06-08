package com.example.besocialapp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.besocialapp.models.gorestApiResponse;

import java.util.List;

public class Post extends Fragment {

    View view;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_post, container, false);

//        progressDialog= new ProgressDialog(getContext());
//        progressDialog.setTitle("Loading Posts!!");
//        progressDialog.show();


        //Toast.makeText(getContext(), "Worked", Toast.LENGTH_SHORT).show();
        RequestManager manager = new RequestManager(getContext());
        manager.getPosts(listener);

        return view;
    }

    private final OnFetchDataListener<gorestApiResponse> listener = new OnFetchDataListener<gorestApiResponse>() {
        @Override
        public void onFetchData(List<gorestApiResponse> posts, String message) {

            showPost(posts);
            //    progressDialog.dismiss();
        }


        @Override
        public void onError(String message) {

        }
    };

    private void showPost(List<gorestApiResponse> posts) {
        recyclerView = recyclerView.findViewById(R.id.postrecyclerveiw);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        adapter = new CustomAdapter(getContext(),posts);
        recyclerView.setAdapter(adapter);

    }

}