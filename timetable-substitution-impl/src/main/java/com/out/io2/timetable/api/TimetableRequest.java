package com.out.io2.timetable.api;

import java.util.List;

public class TimetableRequest {
    List<TimetableCsvRequest> timetableCsvRequests;

    public TimetableRequest(List<TimetableCsvRequest> timetableCsvRequests) {
        this.timetableCsvRequests = timetableCsvRequests;
    }

    public List<TimetableCsvRequest> getTimetableCsvRequests() {
        return timetableCsvRequests;
    }
}
