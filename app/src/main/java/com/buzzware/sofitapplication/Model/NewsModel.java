package com.buzzware.sofitapplication.Model;

public class NewsModel {
    int newsimage;
    String newstitle;

    public NewsModel(int newsimage, String newstitle) {
        this.newsimage = newsimage;
        this.newstitle = newstitle;
    }

    public int getNewsimage() {
        return newsimage;
    }

    public void setNewsimage(int newsimage) {
        this.newsimage = newsimage;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }
}
