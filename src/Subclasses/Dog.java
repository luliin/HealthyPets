package Subclasses;

import Classes.Animal;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 12:51
 * Project: HealhyPets
 * Copyright: MIT
 */

public class Dog extends Animal {

    public Dog(String name, int weightInKilos) {
        super(name, weightInKilos);
        foodType= Food.DOG;
    }

    @Override
    public String getFoodType() {
        return foodType.getName();
    }

    @Override //polymorfism
    public double getFoodAmount() {

        return getWeightInGrams()/100;
    }
}
