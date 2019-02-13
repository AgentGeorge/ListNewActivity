package com.example.study4_listdetails.Core;

public class Car {
    public int ID;
    public int iconID;
    public int imageID;
    public String model;
    public String engineVolume;
    public String enginePower;
    public String cost;
    public int descID;

    public Car(int ID, int iconID, int imageID, String model, String engineVolume, String enginePower, String cost, int descID) {
        this.ID = ID;
        this.iconID = iconID;
        this.imageID = imageID;
        this.model = model;
        this.cost = cost;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
        this.descID = descID;
    }
}