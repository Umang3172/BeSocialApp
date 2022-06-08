package com.example.besocialapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView heading,body,user;
    CardView cardview;
    Button comments;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        heading=itemView.findViewById(R.id.postHeading);
        body=itemView.findViewById(R.id.postBody);
        user=itemView.findViewById(R.id.postbyname);
        cardview=itemView.findViewById(R.id.mainContainer);
        comments=itemView.findViewById(R.id.postComments);
    }

    public TextView getHeading() {
        return heading;
    }

    public void setHeading(TextView heading) {
        this.heading = heading;
    }

    public TextView getBody() {
        return body;
    }

    public void setBody(TextView body) {
        this.body = body;
    }

    public TextView getUser() {
        return user;
    }

    public void setUser(TextView user) {
        this.user = user;
    }

    public CardView getCardview() {
        return cardview;
    }

    public void setCardview(CardView cardview) {
        this.cardview = cardview;
    }

    public Button getComments() {
        return comments;
    }

    public void setComments(Button comments) {
        this.comments = comments;
    }
}
