package com.example.mynews;

import java.util.ArrayList;

public class mainnews {
    private String status;
    private String total;
    private ArrayList<Model> articles;

    public mainnews(String status, String total, ArrayList<Model> articles) {
        this.status = status;
        this.total = total;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }
}
