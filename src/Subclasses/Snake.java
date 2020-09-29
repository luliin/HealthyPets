package Subclasses;
import Classes.*;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 12:51
 * Project: HealthyPets
 * Copyright: MIT
 */

public class Snake extends Animal {

    public Snake(String name, int weightInKilos) {

        super(name, weightInKilos);
        foodType= Food.SNAKE;
    }

    @Override
    public String getFoodType() {
        return foodType.getName();
    }

    @Override //polymorfism
    public double getFoodAmount() {
        return 20;
    }
}
