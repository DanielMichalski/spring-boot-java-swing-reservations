package pl.dmichalski.reservations.business.time;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultCurrentTimeService implements CurrentTimeService {

    @Override
    public Date getCurrentDate() {
        return new Date();
    }

}
