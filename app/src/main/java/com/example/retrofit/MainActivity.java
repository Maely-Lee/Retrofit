package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TestItem dataList;
    List<Data> dataInfo;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    /*private final int MSG_A = 0;

    private  final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case MSG_A :
                    break;
            }
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataInfo = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        get();

    }

    public void sendMessage(View view){

        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == 2){
                Toast.makeText(MainActivity.this, "Result: "
                        + data.getStringExtra("result"), Toast.LENGTH_SHORT).show();

                get();

            }else{
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void get(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<TestItem> call = apiInterface.getData();

        // GET
        call.enqueue(new Callback<TestItem>() {
            @Override
            public void onResponse(Call<TestItem> call, Response<TestItem> response) {

                dataList = response.body();

                Log.d("MainActivity", dataList.toString());

                dataInfo = dataList.body;

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), dataInfo);
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onFailure(Call<TestItem> call, Throwable t) {

                Log.d("MainActivity", t.toString());

            }
        });
    }


}
