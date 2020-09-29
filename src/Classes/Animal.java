package Classes;

import Subclasses.Food;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 12:45
 * Project: HealthyPets
 * Copyright: MIT
 *
 * Abstrakt superklass som vi använder för att ärva ifrån, så vi dessutom kan lägga olika subklasser i samma lista.
 */

public abstract class Animal implements IFoodCalculator { //Implementerar IFoodCalculator, så alla subklasser implementerar den metoden som finns där i.
    private String name;  //Inkapsling
    private double weightInKilos;
    protected Food foodType;

    public Animal(String name, int weightInKilos){
        this.name = name;
        this.weightInKilos = weightInKilos;

    }

    public String getName(){  //Behövs för att subklasserna ska kunna komma åt dessa värden.
        return name;
    }

    public double getWeightInKilos(){   //Behövs för att subklasserna ska kunna komma åt dessa värden.
        return weightInKilos;
    }

    public double getWeightInGrams() {
        return weightInKilos*1000;
    }

    public abstract String getFoodType();  //polymorfism -> Vi sätter olika returns i varje subklass.

}
