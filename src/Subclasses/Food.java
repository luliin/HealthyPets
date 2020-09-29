package Subclasses;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 12:52
 * Project: HealthyPets
 * Copyright: MIT
 */

public enum Food {
    DOG("hundfoder"),
    CAT("kattfoder"),
    SNAKE("ormpellets");

    private final String name;

    Food(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
