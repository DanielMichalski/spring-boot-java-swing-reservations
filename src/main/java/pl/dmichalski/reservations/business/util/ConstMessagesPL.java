package pl.dmichalski.reservations.business.util;

public interface ConstMessagesPL {

    interface DialogTitles {
        String CLIENT_MODAL = "Dodawanie klienta";
        String ADDRESS_MODAL = "Dodawanie adresu";
        String PAYMENT_METHOD_MODAL = "Dodawanie metody płatności";
        String PAYMENT_MODAL = "Dodawanie płatności";
        String RESERVATION_MODAL = "Dodawanie rezerwacji";
        String ROOM_STATUS_MODAL = "Dodawanie statusu pokoju";
        String ROOM_TYPE_MODAL = "Dodawanie typu pokoju";
        String ROOM_MODAL = "Dodawanie pokoju";
        String RATE_MODAL = "Dodawanie stawek";
        String ROOM_X_RESERVATION_MODAL = "Dodawanie rezerwacji pokoju";
    }

    interface Messages {
        String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "Wystąpił błąd podczas ładowania wyglądu okna: ";
        String ALERT_TILE = "Uwaga";
        String NON_ROW_SELECTED = "Nie zaznaczono żadnego wiersza.";
        String INFORMATION_TITLE = "Informacja";
        String DELETE_ROW_ERROR = "Nie można usunąć wybranego rekordu. Sprawdź czy nie istnieje powiązanie w innej tabeli.";
    }

    interface Labels {
        String MAIN_MENU = "Rejestracja hotelowa";
        String CLIENTS = "Klienci";
        String RESERVATIONS = "Rezerwacje";
        String ADDRESSES = "Adresy";
        String ADD_BTN = "Dodaj";
        String CANCEL_BTN = "Anuluj";
        String REMOVE_BTN = "Usuń";
        String NAME = "Imię";
        String SURNAME = "Nazwisko";
        String PESEL = "Pesel";
        String PHONE_NUMBER = "Numer telefonu";
        String EMAIL = "E-mail";
        String ADDRESS = "Adres";
        String STREET = "Ulica";
        String HOUSE_NUMBER = "Numer domu";
        String FLAT_NUMBER = "Numer mieszkania";
        String CITY = "Miasto";
        String POSTAL_CODE = "Kod pocztowy";
        String RESERVATION_STATUS = "Status rezerwacji";
        String RESERVATION_STATUSES = "Statusy rezerwacji";
        String PAYMENT_METHODS = "Metody płatności";
        String PAYMENTS = "Płatności";
        String PAYMENT_METHOD = "Metoda płatności";
        String VALUE = "Wartość";
        String DATE_OF_PAYMENT = "Data płatności";
        String PAYMENT = "Płatność";
        String CLIENT = "Klient";
        String FROM_DATE = "Od";
        String TO_DATE = "Do";
        String RESERVATION_DATE = "Data rezerwacji";
        String AMOUNT = "Suma";
        String ROOM_STATUS = "Status pokoju";
        String ROOM_STATUSES = "Statusy pokoi";
        String ROOM_STATUS_DESCRIPTION = "Opis statusu pokoju";
        String ROOM_TYPE = "Typ pokoju";
        String ROOM_MULTIPLIER = "Mnożnik";
        String ROOM_TYPES = "Typy pokoi";
        String ROOM_TYPE_DESCRIPTION = "Opis typu pokoju";
        String ROOM_NUMBER_OF_PEOPLE = "Ilość osób";
        String ROOM_DESCRIPTION = "Opis";
        String ROOMS = "Pokoje";
        String ROOM = "Pokoj";
        String BASIC_RATE = "Stawka podstawowa";
        String RATES = "Stawki";
        String ROOM_X_RESERVATIONS = "Rezerwacje pokoi";
        String RESERVATION = "Rezerwacja";
        String PRICE = "Cena";
        String FORMS = "Formularze";
        String REPORTS = "Raporty";
        String PAYMENT_COUNT = "Ilość płatności";
        String NUMBER_OF_COUNT = "Ilość wystąpień";
        String NUMBER_OF_RESERVATIONS = "Ilość rezerwacji";
        String CLIENT_RESERVATIONS = "Rezerwacje klienta";
    }

    interface ValidationMessages {
        String REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA = "Nie podano wszystkich wymaganych danych lub wprowadzono błędne dane.";
        String PESEL_LENGTH_INCORRECT = "PESEL powinien zawierać 11 znaków.";
        String DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE = "Data od musi być wcześniejsza niż data do.";
    }
}
