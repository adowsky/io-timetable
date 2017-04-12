package com.out.io2.timetable.api;

import javax.validation.Valid;
import java.util.List;

public class TimetableRequest {
    @Valid
    List<TimetableCsvRequest> timetableCsvRequests;

    public TimetableRequest(List<TimetableCsvRequest> timetableCsvRequests) {
        this.timetableCsvRequests = timetableCsvRequests;
    }

    public List<TimetableCsvRequest> getTimetableCsvRequests() {
        return timetableCsvRequests;
    }
}
