package com.out.io2.timetable.service.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DaysComparator implements Comparator<String> {
    private static final List<String> DAYS = Arrays.asList("PONIEDZIAŁEK", "WTOREK", "ŚRODA", "CZWARTEK", "PIĄTEK", "SOBOTA", "NIEDZIELA");

    @Override
    public int compare(String o1, String o2) {
        Integer o1Idx = DAYS.indexOf(o1.toUpperCase());
        Integer o2Idx = DAYS.indexOf(o2.toUpperCase());
        return o1Idx.compareTo(o2Idx);
    }
}
