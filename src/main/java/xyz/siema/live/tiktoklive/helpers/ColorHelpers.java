package xyz.siema.live.tiktoklive.helpers;

public class ColorHelpers {
    private static final char COLOR_CHAR = '§';

    public ColorHelpers() {
    }

    public static String color(String text) {
        return String.format("%s", text).replace('&', '§');
    }
}
