package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class toDoAdapter extends RecyclerView.Adapter<toDoAdapter.ViewHolder> {
    List<toDoList> userList;

    public toDoAdapter(List<toDoList> userList){
        this.userList = userList;
    }
    @NonNull
    @Override
    public toDoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull toDoAdapter.ViewHolder holder, int position) {
        String s1 = userList.get(position).getText();
        holder.setData(s1);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView2);
        }
        public void setData(String s1){
            textView.setText(s1);
        }
    }
}
