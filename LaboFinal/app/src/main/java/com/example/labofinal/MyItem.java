package com.example.labofinal;

public class MyItem {

    private int num;
    private int imageId;
    private String title;
    private String description;

    public MyItem(int num, int imageId, String title, String description) {
        this.num = num;
        this.imageId = imageId;
        this.title = title;
        this.description = description;
    }

    public int getNum() {
        return num;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

