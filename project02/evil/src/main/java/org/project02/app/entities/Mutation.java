package org.project02.app.entities;

/**
 * Created by Todor Popov using Lenovo on 15.3.2018 г. at 23:27.
 */
public enum Mutation {
    ZOMBIE,
    T_078_TYRANT,
    GIANT_SPIDER;

    public static Mutation parseValue(String type) {
        return Mutation.valueOf(type.toUpperCase());
    }

    public static String getSimpleValue(Mutation type) {
        return type.toString().toLowerCase().charAt(0) + type.toString().toLowerCase().substring(1);
    }

}
