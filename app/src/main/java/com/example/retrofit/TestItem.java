package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class TestItem{

    @SerializedName("statusCode")
    public int statusCode;
    @SerializedName("serverTime")
    public long serverTime;
    @SerializedName("body")
    public List<Data> body;

    @Override
    public String toString() {
        return "TestItem{" +
                "body=" + body +
                '}';
    }

}


