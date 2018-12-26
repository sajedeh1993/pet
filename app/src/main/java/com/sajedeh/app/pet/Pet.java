package com.sajedeh.app.pet;

public class Pet {
    public int id;
    public String name;
    public int gender;
    public int age;
    public int pic;

    public Pet(int id, String name, int gender, int age,int pic) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.pic= pic;
    }

    public Pet() {
    }
}
