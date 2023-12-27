package com.danielmichalski.reservations.commons.time;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
class CurrentTimeServiceImpl implements CurrentTimeService {

    @Override
    public Date getCurrentDate() {
        return new Date();
    }

}
