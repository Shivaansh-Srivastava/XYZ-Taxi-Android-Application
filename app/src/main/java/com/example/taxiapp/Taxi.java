package com.example.taxiapp;

import java.io.Serializable;
import java.math.BigInteger;

public class Taxi implements Serializable {
    private String fname;
    private String phn;
    private String seats;
    private String flat;
    private String address;
    private String city;
    private String fare;

    public Taxi(String fname, String phn, String seats, String flat, String address, String city) {
        this.fname = fname;
        this.phn = phn;
        this.seats = seats;
        this.flat = flat;
        this.address = address;
        this.city = city;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFare()
    {
        this.fare="1000";
    }
    public String getFare()
    {
        return this.fare;
    }
}
