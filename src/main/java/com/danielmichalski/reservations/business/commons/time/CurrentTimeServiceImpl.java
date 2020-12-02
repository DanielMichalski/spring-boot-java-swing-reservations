package com.danielmichalski.reservations.business.commons.time;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
class CurrentTimeServiceImpl implements CurrentTimeService {

    @Override
    public Date getCurrentDate() {
        return new Date();
    }

}
