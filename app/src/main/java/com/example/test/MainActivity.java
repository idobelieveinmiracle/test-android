package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import itf.ApiService;
import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnSubmit;
    TextView txtResult;

    static String urlAdd = "http://192.168.43.237:8000/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);
    }

    public void handleSubmit(View view) {
        User user = new User(txtUsername.getText().toString(), txtPassword.getText().toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlAdd)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

//        Call<Item> call = apiService.getItem("5ca579e9780d9b30b00e36fb");
        Call<User> callUser = apiService.login(user);

//        call.enqueue(new Callback<Item>() {
//            @Override
//            public void onResponse(Call<Item> call, Response<Item> response) {
//                Item item = response.body();
//                txtResult.setText(String.valueOf(response.code()));
//                response.code();
//            }
//
//            @Override
//            public void onFailure(Call<Item> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        callUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                txtResult.setText(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
