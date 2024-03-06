package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText usersWord;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersWord = findViewById(R.id.UsersWord);
        button = findViewById(R.id.Button);
        textView = findViewById(R.id.textView);

        String url = "https://api.dictionaryapi.dev/api/v2/entries/en/";

        usersWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String word = usersWord.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                        .build();
                callRetrofit RetroCall = retrofit.create(callRetrofit.class);
                Call<List<Model>> ModelCall = RetroCall.getData(word);

                ModelCall.enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                        if(!response.isSuccessful()){
                            textView.setText("error code " + response.code());
                            return;
                        }
                        List<Model> model = response.body();

                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(model.get(0).getWord() + "\n");
                        try {
                            for(int i=0; i<model.get(0).phonetics.size(); i++){
                                stringBuffer.append(model.get(0).phonetics.get(i).getSourceUrl() + "\n"
                                        + model.get(0).phonetics.get(i).license.name + "\n"
                                        + model.get(0).phonetics.get(i).license.url + "\n");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        for(int i=0; i<model.get(0).meanings.size(); i++){
                            stringBuffer.append(model.get(0).meanings.get(i).getPartOfSpeech() + "\n");
                            for (int j=0; j<model.get(0).meanings.get(i).definitions.size(); j++){
                                stringBuffer.append(model.get(0).meanings.get(i).definitions.get(j).getDefinition() + "\n");
                            }
                        }
                        textView.setText(stringBuffer);
                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {
                        textView.setText(t.getMessage());
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}