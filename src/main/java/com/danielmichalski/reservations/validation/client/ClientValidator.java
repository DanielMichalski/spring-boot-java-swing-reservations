package com.danielmichalski.reservations.validation.client;

import com.danielmichalski.reservations.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.validation.ValidationError;
import com.danielmichalski.reservations.validation.ValidationSupport;
import com.danielmichalski.reservations.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.PESEL_LENGTH_INCORRECT;
import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class ClientValidator extends ValidationSupport implements Validator<ClientEntity> {

    private static final int PESEL_LENGTH = 11;

    @Override
    public Optional<ValidationError> validate(ClientEntity client) {
        if (isNullOrEmptyString(client.getName())
                || isNullOrEmptyString(client.getSurname())
                || isNullOrEmptyString(client.getPesel())
                || isNullOrEmptyString(client.getPhoneNumber())
                || isNullOrEmptyString(client.getEmail())
                || isNullValue(client.getAddress())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (PESEL_LENGTH != client.getPesel().length()) {
            return Optional.of(new ValidationError(PESEL_LENGTH_INCORRECT));
        }
        return Optional.empty();
    }

}
