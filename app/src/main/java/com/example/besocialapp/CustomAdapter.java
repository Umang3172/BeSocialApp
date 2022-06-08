package com.example.besocialapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besocialapp.models.gorestApiResponse;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<gorestApiResponse> posts;

    public CustomAdapter(Context context, List<gorestApiResponse> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.post_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.heading.setText(posts.get(position).getPosts().get(0).getTitle());
        holder.body.setText(posts.get(position).getPosts().get(0).getBody());
        holder.user.setText("By: "+posts.get(position).getPosts().get(0).getUser_id());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
