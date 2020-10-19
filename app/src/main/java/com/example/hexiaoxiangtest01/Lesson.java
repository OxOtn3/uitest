package com.example.hexiaoxiangtest01;

public class Lesson {
    private String name;
    private int imageId;  //对应图片资源id
    private String introduction;

    public Lesson(String name, int imageId, String introduction) {
        this.name = name;
        this.imageId = imageId;
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getIntroduction() {
        return introduction;
    }

}
