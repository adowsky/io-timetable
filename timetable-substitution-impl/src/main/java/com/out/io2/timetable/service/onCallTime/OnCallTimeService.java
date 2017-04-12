package com.out.io2.timetable.service.onCallTime;


import com.out.io2.timetable.service.model.OnCallTime;
import org.springframework.stereotype.Service;

@Service
public class OnCallTimeService {
    private OnCallTimeRepository onCallTimeRepository;

    public OnCallTimeService(OnCallTimeRepository onCallTimeRepository) {
        this.onCallTimeRepository = onCallTimeRepository;
    }

    public void save(OnCallTime onCallTime){
        OnCallTimeDAO dao=new OnCallTimeDAO(onCallTime.getOnCallTimeId(),onCallTime.getRoom(),onCallTime.getFrom(),onCallTime.getTo(),onCallTime.getTeacherId());
        onCallTimeRepository.save(dao);
    }
}
