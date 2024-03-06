package com.example.retrofitjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CallJson callJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        callJson = retrofit.create(CallJson.class);

//        Call<List<Model>> listCall = callJson.getList(new String[]{"1","2","3"},"id", "desc");
//        listCall.enqueue(new Callback<List<Model>>() {
//            @Override
//            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
//                StringBuffer stringBuffer = new StringBuffer();
//                List<Model> list = response.body();
//                for(Model model : list){
//                    stringBuffer.append("User Id: " + model.getUserId() + "\n");
//                    stringBuffer.append("Id: " + model.getId() + "\n");
//                    stringBuffer.append("Title: " + model.getTitle() + "\n");
//                    stringBuffer.append("Body: " + model.getBody() + "\n");
//                }
//                textView.setText(stringBuffer);
//            }
//            @Override
//            public void onFailure(Call<List<Model>> call, Throwable t) {
//                textView.setText(t.getMessage());
//            }
//        });

        createPost();
    }
    private void createPost(){
//        Model model = new Model(23, "New Title", "New Text");

        Call<Model> call = callJson.createPost(23, "New Title", "New Text");

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(!response.isSuccessful()){
                    textView.setText("code: " + response.code());
                    return;
                }
                Model modelResponse = response.body();
                StringBuffer stringBuffer = new StringBuffer();

                stringBuffer.append("Code: " + response.code() + "\n");
                stringBuffer.append("User Id: " + modelResponse.getUserId() + "\n");
                stringBuffer.append("Id: " + modelResponse.getId() + "\n");
                stringBuffer.append("Title: " + modelResponse.getTitle() + "\n");
                stringBuffer.append("Body: " + modelResponse.getBody() + "\n");

                textView.setText(stringBuffer);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}