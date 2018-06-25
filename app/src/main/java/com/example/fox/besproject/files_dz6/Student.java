package com.example.fox.besproject.files_dz6;

public class Student {
    private String name;
    private String surname;
    private String phone;
    private String fotos;
    private String group;

    public Student(String name, String surname, String phone, String fotos, String group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.fotos = fotos;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
