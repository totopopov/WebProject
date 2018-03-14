package org.softuni.project01.auditorium.app.entities;

import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 12:55.
 */

public enum  ChairType {
    FIXED,
    MOVEABLE;

    public static ChairType parseValue(String value) {
        return ChairType.valueOf(value.toUpperCase());
    }

    public static String getSimpleValue(ChairType type) {
        return type.toString().toLowerCase().charAt(0) + type.toString().toLowerCase().substring(1);
    }


}
