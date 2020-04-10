package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    Data newData;

    EditText newName, newStar, newLike;
    static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final Intent intent = getIntent();

        newName = (EditText) findViewById(R.id.newDataName);
        newStar = (EditText) findViewById(R.id.newNumOfStar);
        newLike = (EditText) findViewById(R.id.newNumOfLike);

        newData = new Data("", 0, 0);

        Button uploadBtn = findViewById(R.id.uploadBtn);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        uploadBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                upload();
                intent.putExtra("result", "some value");
                setResult(2, intent);

                finish();

            }

        });

    }

    public void upload(){

        final Data data = new Data();

        data.name = newName.getText().toString();
        data.numOfLike = Integer.parseInt(newLike.getText().toString());
        data.numOfStar = Integer.parseInt(newStar.getText().toString());

        new Thread(){

            @Override
            public void run(){
                final Call<TestItem> call = apiInterface.postData(data.name, data.numOfLike, data.numOfStar);

                call.enqueue(new Callback<TestItem>() {
                    @Override
                    public void onResponse(Call<TestItem> call, Response<TestItem> response) {
                        TestItem dataList = response.body();
                        Integer statusCode = dataList.statusCode;
                        Long serverTime = dataList.serverTime;
                        List<Data> dataInfo = dataList.body;

                    }

                    @Override
                    public void onFailure(Call<TestItem> call, Throwable t) {
                        call.cancel();
                    }
                });
            }
        }.start();



    }

}
