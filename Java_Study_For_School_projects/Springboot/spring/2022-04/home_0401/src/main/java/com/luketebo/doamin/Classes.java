package com.luketebo.doamin;

public class Classes {
    private int id;
    private String admin;
    private int people;

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", admin='" + admin + '\'' +
                ", people=" + people +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
