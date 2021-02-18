package com.bishe.mentality.entity;

public class Consultant {
    private String id;
    private String name;
    private String password;
    private int gender;
    private String introduction;
    private String imgSrc;

    public Consultant() {
    }

    public Consultant(String id, String name, String password, int gender, String introduction, String imgSrc) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.introduction = introduction;
        this.imgSrc = imgSrc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }



    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", introduction='" + introduction + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
