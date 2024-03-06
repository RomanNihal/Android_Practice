package com.example.recyclerwithdialouge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.viewHolder> {

    List<bindData> userList;
    private Context context;
    personsData pD;
    recyclerAdapter(List<bindData>userList,Context context){
        this.userList = userList;
        this.context = context;
    }


    @NonNull
    @Override
    public recyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newcard,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.viewHolder holder, int position) {
        pD = new personsData(context);
        String s1 = userList.get(position).getS1();
        String s2 = userList.get(position).getS2();
        String s3 = userList.get(position).getS3();
        Glide.with(context).load(s1).into(holder.imageView);
        holder.setData(s2,s3);
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == 0){
                            final Dialog dialog = new Dialog(context);
                            dialog.setContentView(R.layout.additem);
                            dialog.setTitle("Update");

                            EditText et1 = dialog.findViewById(R.id.imageUrl);
                            EditText et2 = dialog.findViewById(R.id.etname);
                            EditText et3 = dialog.findViewById(R.id.etid);
                            Button b1 = dialog.findViewById(R.id.addbutton);
                            b1.setText("Update");

                            b1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String s1 = et1.getText().toString();
                                    String s2 = et2.getText().toString();
                                    String s3 = et3.getText().toString();
                                    boolean b = pD.update(s1, s2, s3);
                                    if(b){
                                        dialog.dismiss();
                                    }
                                    else{
                                        Toast.makeText(context, "name already added", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            int width = (int)(context.getResources().getDisplayMetrics().widthPixels * 0.95);
                            int height = (int)(context.getResources().getDisplayMetrics().heightPixels * 0.7);
                            dialog.getWindow().setLayout(width,height);
                            dialog.show();
                        }
                        else{
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView3);
            textView2 = itemView.findViewById(R.id.textView4);
            cardView = itemView.findViewById(R.id.cardView);
        }
        public void setData(String s2, String s3){
            textView1.setText(s2);
            textView2.setText(s3);
        }
    }
}
