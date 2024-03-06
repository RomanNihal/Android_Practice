package com.example.apirecycler;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    List<itemList> itemLists;
    Context context;

    public itemAdapter(List<itemList> itemLists, Context context){
        this.itemLists = itemLists;
        this.context = context;
    }
    @NonNull
    @Override
    public itemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.ViewHolder holder, int position) {
        String s1 = itemLists.get(position).getSourceName();
        String s2 = itemLists.get(position).getSourceId();
        String s3 = itemLists.get(position).getAuthorName();
        String s4 = itemLists.get(position).getNewsTitle();
        String s5 = itemLists.get(position).getImageUrl();
        Glide.with(context).load(s5).into(holder.imageView);
        holder.setData(s1,s2,s3,s4);
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void setData(String s1, String s2, String s3, String s4) {
            textView.setText(s1.toUpperCase() + "\n" +s2 + "\n" + s3 + "\n" + s4 + "\n\n");

        }
    }
}
