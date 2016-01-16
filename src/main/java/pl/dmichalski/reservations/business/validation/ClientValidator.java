package pl.dmichalski.reservations.business.validation;

import com.google.common.base.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Client;

@Component
public class ClientValidator implements Validator<Client> {

    @Override
    public boolean isValid(Client client) {
        return !Strings.isNullOrEmpty(client.getName()) &&
            !Strings.isNullOrEmpty(client.getSurname());

    }

}
