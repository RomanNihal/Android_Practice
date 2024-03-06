package com.example.to_do;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Connector extends RecyclerView.Adapter<Connector.ViewHolder> {
   List<Model> list;
   Context context;
   RecyclerView recyclerView;
   LinearLayoutManager layoutManager;
   SQLiteDatabase sqLiteDatabase;
   Connector connector;

    public Connector(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Connector.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Connector.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SplashActivity.handler = new databaseHandler(context);

        holder.checkBox.setChecked(returnBool(list.get(position).getStatus()));
        holder.checkBox.setText(list.get(position).getTaskText());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    SplashActivity.handler.updateStatus(list.get(position).getId(),1);
                }
                else{
                    SplashActivity.handler.updateStatus(list.get(position).getId(),0);
                }
            }
        });
        holder.checkBox.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == 0){
                            updateItem(list.get(position).getId());
                        }
                        else{
                            deleteItem(list.get(position).getId());
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    private void deleteItem(int id){
        Intent intent = new Intent(context, MainActivity.class);
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(context);

        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Are you sure?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try{
                    SplashActivity.handler.delete(id);
                }
                catch (Exception error){
                    Log.e("error", error.getMessage());
                }
            }
        });

        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updateItem(int id){
        Intent intent = new Intent(context, MainActivity.class);
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.add_new_task);
        dialog.setTitle("Update");

        EditText newTaskText = dialog.findViewById(R.id.newTaskText);
        Button newTaskSaveButton = dialog.findViewById(R.id.newTaskSaveButton);

        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();

        newTaskSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final String task = newTaskText.getText().toString();
                    SplashActivity.handler.updateTask(id, task);
                    dialog.dismiss();
                }
                catch (Exception error){
                    Log.e("Update error: ", error.getMessage());
                }
            }
        });
    }

    private boolean returnBool(int status) {
        if(status==0){
            return false;
        }
        else return true;
    }

    private void updateList(){
        sqLiteDatabase = SplashActivity.handler.getReadableDatabase();

        Cursor cursor= SplashActivity.handler.getData();

        list.clear();

        if(cursor.getCount()==0){
            Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                list.add(new Model(cursor.getInt(0),cursor.getInt(1),cursor.getString(2)));
            }
        }
        layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        connector=new Connector(list,context);
        recyclerView.setAdapter(connector);
        connector.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkBox);
            recyclerView=itemView.findViewById(R.id.taskRecyclerView);
        }
    }
}
