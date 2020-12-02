package com.danielmichalski.reservations.business.validation;

import com.google.common.base.Strings;

public abstract class ValidationSupport {

    protected boolean isNullOrEmptyString(String value) {
        return Strings.isNullOrEmpty(value);
    }

    protected boolean isNullValue(Object value) {
        return value == null;
    }

    protected boolean isValueNotGreaterThanZero(long value) {
        return value <= 0;
    }

}
