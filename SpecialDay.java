package com.example.demo.Spring;

import java.io.Serializable;

public class SpecialDay  implements Serializable {

        private int id;
        private String name;
        private int day;
        private int month;

        public SpecialDay() {
            super();
        }

    public SpecialDay(int id, String name, int day, int month) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
    }

    public String getSpDname() {
            return name;
        }

        public void setSpDname(String name) {
            this.name = name;
        }

        public SpecialDay (int id, String name) {
            this.id = id;
            this.name = name;

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

        @Override
        public String toString() {
            return "MyMessage [id=" + id + "Special day = " + name + "day = " + day + "month =" + month + "]";
        }
    }

