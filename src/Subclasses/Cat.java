package Subclasses;

import Classes.Animal;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 12:51
 * Project: HealthyPets
 * Copyright: MIT
 */

public class Cat extends Animal {

    public Cat(String name, int weightInKilos) {
        super(name, weightInKilos);
        foodType = Food.CAT;
    }

    @Override
    public String getFoodType() {
        return foodType.getName();
    }

    @Override //polymorfism
    public double getFoodAmount() {
        return getWeightInGrams()/150;
    }
}
