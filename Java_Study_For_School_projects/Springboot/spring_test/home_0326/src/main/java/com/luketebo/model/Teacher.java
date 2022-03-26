package com.luketebo.model;

public class Teacher {
    private int id;
    private String name;
    private int age;
    private String identity;

    public Teacher() {
    }

    public Teacher(int id, String name, int age, String identity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", identity='" + identity + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
