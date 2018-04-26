package org.project02.app.entities;

/**
 * Created by Todor Popov using Lenovo on 15.3.2018 г. at 23:27.
 */
public enum Magnitude {
    LOW,
    MEDIUM,
    HIGH;

    public static Magnitude parseValue(String type) {
        return Magnitude.valueOf(type.toUpperCase());
    }

    public static String getSimpleValue(Magnitude type) {
        return type.toString().toLowerCase().charAt(0) + type.toString().toLowerCase().substring(1);
    }

}
