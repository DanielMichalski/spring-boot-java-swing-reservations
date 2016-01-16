package pl.dmichalski.reservations.business.util;

public interface ConstMessages {

    interface FramesTitles {
        String REGISTRATION_FRAME = "Główne Menu";
        String CLIENT_FRAME = "Klienci";

    }

    interface DialogTitles {
        String CLIENT_MODAL = "Dodawanie klientów";
    }

    interface Messages {
        String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "Wystąpił błąd podczas ładowania wyglądu okna: ";
        String ALERT_TILE = "Uwaga";
        String NON_ROW_SELECTED = "Nie zaznaczono żadnego wiersza";
        String FORM_VALIDATION_ALERT = "Nie wypełniono wszystkich pól";
        String INFORMATION_TITLE = "Informacja";
    }

    interface Labels {
        String CLIENTS = "Klienci";
        String RESERVATIONS = "Rezerwacje";
        String ADDRESSES = "Adresy";
        String ADD_BTN = "Dodaj";
        String REMOVE_BTN = "Usuń";
        String NAME = "Imię";
        String SURNAME = "Nazwisko";
        String PESEL = "Pesel";
        String PHONE_NUMBER = "Numer telefonu";
        String EMAIL = "E-mail";
    }

    interface ColumnsLabels {
        String NAME = "Imię";
        String SURNAME = "Nazwisko";
        String PESEL = "PESEL";
        String PHONE_NUMBER = "Telefon";
        String EMAIL = "E-mail";
    }
}
