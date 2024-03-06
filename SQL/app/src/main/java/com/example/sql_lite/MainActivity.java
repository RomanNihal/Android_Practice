package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern pass_pattern = Pattern.compile("^"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{6,}"+"$");
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    CheckBox c1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.tvsup);
        t2 = findViewById(R.id.tvname);
        t3 = findViewById(R.id.tvmail);
        t4 = findViewById(R.id.tvpass);
        t5 = findViewById(R.id.tvterms);
        t6 = findViewById(R.id.tvhac);
        t7 = findViewById(R.id.tvsignin);

        et1 = findViewById(R.id.etename);
        et2 = findViewById(R.id.etemail);
        et3 = findViewById(R.id.etepass);

        c1 = findViewById(R.id.caggree);
        b1 = findViewById(R.id.bcreate);
    }
    //    private boolean valid_name(){
//        String name = et1.getText().toString().trim();
//
//        if(name.isEmpty()){
//            et1.setError("Can't be empty");
//            return false;
//        }
//        if(name.length()>15){
//            et1.setError("Too long");
//            return false;
//        }
//        else{
//            et1.setError(null);
//            return true;
//        }
//    }
//    private boolean valid_mail(){
//        String mail = et2.getText().toString().trim();
//
//        if(mail.isEmpty()){
//            et2.setError("Can't be empty");
//            return false;
//        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
//            et2.setError("Enter a verified mail");
//            return false;
//        }
//        else{
//            et2.setError(null);
//            return true;
//        }
//    }
//    private boolean valid_pass(){
//        String pass = et3.getText().toString().trim();
//
//        if(pass.isEmpty()){
//            et3.setError("Can't be empty");
//            return false;
//        }
//        if(!pass_pattern.matcher(pass).matches()){
//            et3.setError("Password is too weak");
//            return false;
//        }
//        else{
//            et3.setError(null);
//            return true;
//        }
//    }
    public void terms_condition(View v){
        Intent to = new Intent(this,Read_Data.class);
        startActivity(to);
    }
    public void create_account(View v){
        //Data Base
        Data_base d = new Data_base(this);
//        SQLiteDatabase s = d.getReadableDatabase();

        String name = et1.getText().toString().trim();
        String mail = et2.getText().toString().trim();
        String pass = et3.getText().toString().trim();

        int flag=0;

        if(name.isEmpty()){
            et1.setError("Can't be empty");
        }
        else if(name.length()>15){
            et1.setError("Too long");
        }
        else{
            et1.setError(null);
            flag++;
        }
        if(mail.isEmpty()){
            et2.setError("Can't be empty");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            et2.setError("Enter a verified mail");
        }
        else{
            et2.setError(null);
            flag++;
        }
        if(pass.isEmpty()){
            et3.setError("Can't be empty");
        }
        else if(!pass_pattern.matcher(pass).matches()){
            et3.setError("Password is too weak");
        }
        else{
            et3.setError(null);
            flag++;
        }
        if(flag==3){
            d.insert(name,mail,pass);
        }
    }
    public void sign_in(View v){
        Intent to = new Intent(this,dataupdate.class);
        Toast.makeText(this,"Yes",Toast.LENGTH_LONG).show();
        startActivity(to);
    }
}