package com.danielmichalski.reservations.commons.validation;

@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
public abstract class ValidationSupport {

    protected boolean isNullOrEmptyString(String value) {
        return value == null || value.isEmpty();
    }

    protected boolean isNullValue(Object value) {
        return value == null;
    }

    protected boolean isValueNotGreaterThanZero(Long value) {
        return isNullValue(value) || value <= 0;
    }

}
