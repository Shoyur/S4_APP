package com.example.examen2;

import android.os.Parcel;
import android.os.Parcelable;

public class Usager implements Parcelable {

    private int id;
    private String name;
    private int age;

    public Usager(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Usager(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.age = parcel.readInt();
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(age);
    }

    public static final Parcelable.Creator<Usager> CREATOR = new Parcelable.Creator<Usager>() {
        public Usager createFromParcel(Parcel parcel) {
            return new Usager(parcel);
        }
        public Usager[] newArray(int grandeur) {
            return new Usager[grandeur];
        }
    };

    @Override
    public String toString() {
        return "User { id=" + id + ", name='" + name + ", age=" + age + " }";
    }
}