package pl.dmichalski.reservations.business.validation;

interface Validator <K> {

    boolean isValid(K k);

}
