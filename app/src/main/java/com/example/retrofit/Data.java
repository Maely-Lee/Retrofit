package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class Data {

    public int id;
    public String name;
    public float locLatitude;
    public float locLongitude;
    public int numOfStar;
    public int numOfLike;

    public Data(int id, String name, float locLatitude, float locLongitude, int numOfStar, int numOfLike) {
        this.id = id;
        this.name = name;
        this.locLatitude = locLatitude;
        this.locLongitude = locLongitude;
        this.numOfStar = numOfStar;
        this.numOfLike = numOfLike;
    }

    public Data(String name, int numOfStar, int numOfLike) {
        this.name = name;
        this.numOfStar = numOfStar;
        this.numOfLike = numOfLike;
    }

    public Data(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLocLatitude() {
        return locLatitude;
    }

    public void setLocLatitude(float locLatitude) {
        this.locLatitude = locLatitude;
    }

    public float getLocLongitude() {
        return locLongitude;
    }

    public void setLocLongitude(float locLongitude) {
        this.locLongitude = locLongitude;
    }

    public int getNumOfStar() {
        return numOfStar;
    }

    public void setNumOfStar(int numOfStar) {
        this.numOfStar = numOfStar;
    }

    public int getNumOfLike() {
        return numOfLike;
    }

    public void setNumOfLike(int numOfLike) {
        this.numOfLike = numOfLike;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locLatitude=" + locLatitude +
                ", locLongitude=" + locLongitude +
                ", numOfStar=" + numOfStar +
                ", numOfLike=" + numOfLike +
                '}';
    }
}
