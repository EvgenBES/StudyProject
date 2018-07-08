package com.example.fox.besproject.files_dz6;


import java.util.ArrayList;

public class SinglStudent {
    private static SinglStudent instance;
    private ArrayList<Student> list = null;

    public static SinglStudent getInstance() {
        if(instance == null)
            instance = new SinglStudent();

        return instance;
    }

    private SinglStudent() {
        list = new ArrayList<>();

        list.add (new Student("Nikita", "Bulbus", "+375 29 325 23 77", "https://avatarko.ru/img/avatar/14/shlyapa_pistolet_Lego_13500.jpg", "15"));
        list.add (new Student("Marina", "Mahnatus", "+375 44 154 12 85", "https://avatarko.ru/img/avatar/14/igra_soldat_13506.jpg", "17"));
        list.add (new Student("Evgen", "Puzicov", "+375 17 956 45 52", "https://avatarko.ru/img/avatar/18/devushka_17296.jpg", "25"));
        list.add (new Student("Sergey", "Perducov", "+375 44 854 98 23", "https://avatarko.ru/img/avatar/31/igra_Dota_2_Omniknight_30248.jpg", "25"));
        list.add (new Student("Kirilton", "Kokos", "+375 25 365 45 36", "https://avatarko.ru/img/avatar/7/zhivotnye_sobaka_6187.jpg", "33"));
    }
    // retrieve array from anywhere
    public ArrayList<Student> getArray() {
        return this.list;
    }
    //Add element to array
    public void addToArray(String name, String surname, String phone, String fotos, String group) {
        list.add(new Student(name, surname, phone, fotos, group));
    }

    public void setToArray(String name, String surname, String phone, String fotos, String group, int id) {
        list.set(id, (new Student(name, surname, phone, fotos, group)));
    }


}