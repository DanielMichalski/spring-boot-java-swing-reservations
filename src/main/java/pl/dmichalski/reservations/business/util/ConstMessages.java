package pl.dmichalski.reservations.business.util;

public interface ConstMessages {

    interface FramesTitles {
        String REGISTRATION_FRAME = "Główne Menu";
        String CLIENT_FRAME = "Klienci";
    }

    interface Messages {
        String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "Wystąpił błąd podczas ładowania wyglądu okna: ";
        String ALERT_TILE = "Uwaga";
        String NON_ROW_SELECTED = "Nie zaznaczono żadnego wiersza";
    }

    interface Labels {
        String CLIENTS = "Klienci";
        String RESERVATIONS = "Rezerwacje";
        String ADDRESSES = "Adresy";
        String ADD_BTN = "Dodaj";
        String REMOVE_BTN = "Usuń";
    }

    interface ColumnsLabels {
        String NAME = "Imię";
        String SURNAME = "Nazwisko";
    }
}
