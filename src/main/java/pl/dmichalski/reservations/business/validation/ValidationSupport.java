package pl.dmichalski.reservations.business.validation;

import com.google.common.base.Strings;

public abstract class ValidationSupport {

    boolean isNullOrEmptyString(String value) {
        return Strings.isNullOrEmpty(value);
    }

    boolean isNullValue(Object value) {
        return value == null;
    }

    boolean isValueGreaterThanZero(long value) {
        return value > 0;
    }

    boolean isValueGreaterThanZero(double value) {
        return value > 0;
    }

}
