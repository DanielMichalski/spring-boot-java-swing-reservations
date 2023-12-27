package com.danielmichalski.reservations.util.constant;

public class ConstMessagesPL {

    public static class DialogTitles {

        public static String CLIENT_MODAL = "Dodawanie klienta";
        public static String ADDRESS_MODAL = "Dodawanie adresu";
        public static String PAYMENT_METHOD_MODAL = "Dodawanie metody płatności";
        public static String PAYMENT_MODAL = "Dodawanie płatności";
        public static String RESERVATION_MODAL = "Dodawanie rezerwacji";
        public static String ROOM_STATUS_MODAL = "Dodawanie statusu pokoju";
        public static String ROOM_TYPE_MODAL = "Dodawanie typu pokoju";
        public static String ROOM_MODAL = "Dodawanie pokoju";
        public static String RATE_MODAL = "Dodawanie stawek";
        public static String ROOM_X_RESERVATION_MODAL = "Dodawanie rezerwacji pokoju";
    }

    public static class Messages {

        public static String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "Wystąpił błąd podczas ładowania wyglądu okna: ";
        public static String ALERT_TILE = "Uwaga";
        public static String NON_ROW_SELECTED = "Nie zaznaczono żadnego wiersza.";
        public static String INFORMATION_TITLE = "Informacja";
        public static String DELETE_ROW_ERROR = "Nie można usunąć wybranego rekordu."
                + "Sprawdź czy nie istnieje powiązanie w innej tabeli.";
    }

    public static class Labels {

        public static String MAIN_MENU = "Rejestracja hotelowa";
        public static String CLIENTS = "Klienci";
        public static String RESERVATIONS = "Rezerwacje";
        public static String ADDRESSES = "Adresy";
        public static String ADD_BTN = "Dodaj";
        public static String CANCEL_BTN = "Anuluj";
        public static String REMOVE_BTN = "Usuń";
        public static String NAME = "Imię";
        public static String SURNAME = "Nazwisko";
        public static String PESEL = "Pesel";
        public static String PHONE_NUMBER = "Numer telefonu";
        public static String EMAIL = "E-mail";
        public static String ADDRESS = "Adres";
        public static String STREET = "Ulica";
        public static String HOUSE_NUMBER = "Numer domu";
        public static String FLAT_NUMBER = "Numer mieszkania";
        public static String CITY = "Miasto";
        public static String POSTAL_CODE = "Kod pocztowy";
        public static String RESERVATION_STATUS = "Status rezerwacji";
        public static String RESERVATION_STATUSES = "Statusy rezerwacji";
        public static String PAYMENT_METHODS = "Metody płatności";
        public static String PAYMENTS = "Płatności";
        public static String PAYMENT_METHOD = "Metoda płatności";
        public static String VALUE = "Wartość";
        public static String DATE_OF_PAYMENT = "Data płatności";
        public static String PAYMENT = "Płatność";
        public static String CLIENT = "Klient";
        public static String FROM_DATE = "Od";
        public static String TO_DATE = "Do";
        public static String RESERVATION_DATE = "Data rezerwacji";
        public static String AMOUNT = "Suma";
        public static String ROOM_STATUS = "Status pokoju";
        public static String ROOM_STATUSES = "Statusy pokoi";
        public static String ROOM_STATUS_DESCRIPTION = "Opis statusu pokoju";
        public static String ROOM_TYPE = "Typ pokoju";
        public static String ROOM_MULTIPLIER = "Mnożnik";
        public static String ROOM_TYPES = "Typy pokoi";
        public static String ROOM_TYPE_DESCRIPTION = "Opis typu pokoju";
        public static String ROOM_NUMBER_OF_PEOPLE = "Ilość osób";
        public static String ROOM_DESCRIPTION = "Opis";
        public static String ROOMS = "Pokoje";
        public static String ROOM = "Pokój";
        public static String BASIC_RATE = "Stawka podstawowa";
        public static String RATES = "Stawki";
        public static String ROOM_X_RESERVATIONS = "Rezerwacje pokoi";
        public static String RESERVATION = "Rezerwacja";
        public static String PRICE = "Cena";
        public static String FORMS = "Formularze";
        public static String REPORTS = "Raporty";
        public static String PAYMENT_COUNT = "Ilość płatności";
        public static String NUMBER_OF_COUNT = "Ilość wystąpień";
        public static String NUMBER_OF_RESERVATIONS = "Ilość rezerwacji";
        public static String CLIENT_RESERVATIONS = "Rezerwacje klienta";
    }

    public static class ValidationMessages {

        public static String REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA = "Nie podano wszystkich wymaganych danych lub "
                + "wprowadzono błędne dane.";
        public static String PESEL_LENGTH_INCORRECT = "PESEL powinien zawierać 11 znaków.";
        public static String DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE = "Data od musi być wcześniejsza niż data do.";
    }
}
