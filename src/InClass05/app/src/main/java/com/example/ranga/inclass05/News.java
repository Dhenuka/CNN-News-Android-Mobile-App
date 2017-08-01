package com.example.ranga.inclass05;

/**
 * Created by ranga on 2/13/2017.
 */

public class News {
    String title,description,sqImage,pubDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSqImage() {
        return sqImage;
    }

    public void setSqImage(String sqImage) {
        this.sqImage = sqImage;
    }

    @Override
    public String toString() {
        return "News{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", sqImage='" + sqImage + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
