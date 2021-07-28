package ru.javawebinar.basejava.util;

import java.util.Calendar;
import java.util.Date;

public class MainDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.print(date);
        System.out.print(date.getTime());
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }
}
