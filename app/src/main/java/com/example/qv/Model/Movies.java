package com.example.qv.Model;

public class Movies {
    String name,des,rating;

    public Movies(String name, String des, String rating) {
        this.name = name;
        this.des = des;
        this.rating = rating;
    }

    public Movies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
