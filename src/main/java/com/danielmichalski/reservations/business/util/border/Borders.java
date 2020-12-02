package com.danielmichalski.reservations.business.util.border;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Borders {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;

    public static Border createEmptyBorder() {
        return BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH);
    }

}
