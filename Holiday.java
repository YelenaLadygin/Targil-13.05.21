package com.example.demo.Spring;

import java.io.Serializable;

public class Holiday  implements Serializable {
    private int id;
    private String holidayName;
    private int day;
    private int month;
    private int length;

    public Holiday() {
        super();
    }

    public Holiday(int id, String holidayName, int day, int month, int length) {
        this.id = id;
        this.holidayName = holidayName;
        this.day = day;
        this.month = month;
        this.length = length;
    }

    public String getHolidayname() {
        return holidayName;
    }

    public void setHolidayname(String name) {
        this.holidayName = name;
    }

    public Holiday(int id, String holidayName) {
        this.id = id;
        this.holidayName = holidayName;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "MyMessage [id=" + id + "Holiday = " + holidayName + "day = " + day + "month =" + month +
                "length = " + length + "]";
    }
}

