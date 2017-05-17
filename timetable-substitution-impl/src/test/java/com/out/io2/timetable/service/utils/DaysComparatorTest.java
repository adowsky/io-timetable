package com.out.io2.timetable.service.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaysComparatorTest {
    private DaysComparator daysComparator = new DaysComparator();

    @Test
    public void shouldReturnMondayLessThanTuesday() {
        //given
        String monday = "PONIEDZIAŁEK";
        String tuesday = "WTOREK";

        //when
        int actual = daysComparator.compare(monday, tuesday);

        //then
        assertThat(actual).isNegative();
    }

    @Test
    public void shouldReturnMondayEqualsMonday() {
        //given
        String monday = "PONIEDZIAŁEK";
        String tuesday = "PONIEDZIAŁEK";

        //when
        int actual = daysComparator.compare(monday, tuesday);

        //then
        assertThat(actual).isZero();
    }

    @Test
    public void shouldReturnTuesdayHigherThanMonday() {
        //given
        String monday = "PONIEDZIAŁEK";
        String tuesday = "WTOREK";

        //when
        int actual = daysComparator.compare(tuesday, monday);

        //then
        assertThat(actual).isPositive();
    }

    @Test
    public void shouldReturnTuesdayHigherThanNonDay() {
        //given
        String nonDay = "asdasda";
        String tuesday = "WTOREK";

        //when
        int actual = daysComparator.compare(tuesday, nonDay);

        //then
        assertThat(actual).isPositive();
    }


    @Test
    public void shouldReturnNonDayEqualsNonDay() {
        //given
        String nonDay = "asdasda";
        String nonDay2 = "zxczxczxc";

        //when
        int actual = daysComparator.compare(nonDay, nonDay2);

        //then
        assertThat(actual).isZero();
    }
}