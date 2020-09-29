package Classes;

import Subclasses.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 13:19
 * Project: HealthyPets
 * Copyright: MIT
 */

public class Menu {
    static List<Animal> animals = new ArrayList<>();

    public static void menu() throws IllegalArgumentException {

        generateAnimals();

        boolean successfulInput = false;

        while (!successfulInput) {
            String input = JOptionPane.showInputDialog("Vilket djur vill du mata?");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Välkommen åter!");
                System.exit(0);
            } else {
                input = input.trim();


/*

            Bortkommenterad då jag löste switch-satsen med en ny enum över namn.

            switch (input.toLowerCase()) {
                case "sixten":
                case "dogge":
                case "venus":
                case "ove":
                case "hypno":
                    printFoodAmount(getAnimal(input));
                    successfulInput = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Namnet som du skrivit in finns inte på hotellet. Försök igen!");
            }

 */
                boolean correctName = false;
                for (var name : Names.values()) {
                    if (name.name().equalsIgnoreCase(input)) { //Vi kollar om inputen matchar med något av djurens namn.
                        correctName = true;                    // Om ja, correctName blir true och leder in oss i nästa if.
                        break;
                    }
                }
                if (correctName) {
                    switch (Names.valueOf(input.toUpperCase())) {
                        case SIXTEN, DOGGE, VENUS, OVE, HYPNO -> {
                            printFoodAmount(Objects.requireNonNull(getAnimal(input)));
                            successfulInput = true;  //Bryter while-loopen.
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, input + " finns inte på hotellet. Försök igen!\n" +
                            "Djur på hotellet: Sixten, Dogge, Venus, Ove och Hypno.");
                }
            }
        }
    }

    public static void generateAnimals() { //Vi skapar upp våra djur och lägger i en lista.

        Dog sixten = new Dog("Sixten", 5);
        Dog dogge = new Dog("Dogge", 10);
        Cat venus = new Cat("Venus", 5);
        Cat ove = new Cat("Ove", 3);
        Snake hypno = new Snake("Hypno", 1);

        animals.add(sixten);  //Skulle kunna förkortas till animals.add(new Animal(name, weight)
        animals.add(dogge);   //Har behållit det som det står för läsbarhetens skull.
        animals.add(venus);
        animals.add(ove);
        animals.add(hypno);


    }

    public static Animal getAnimal(String name) { //Hämtar ett djur om inparemetern name matchar djurets namn.

        for (var animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public static void printFoodAmount(Animal animal) { //Skriver ut djurets namn, hur mycket & typ av mat.

        JOptionPane.showMessageDialog(null, String.format("%s ska ha %s g %s.",
                animal.getName(), df.format(animal.getFoodAmount()), animal.getFoodType()));
    }

    static DecimalFormat df = new DecimalFormat("#.##"); //Används för att undvika alldeles för många decimaler.
                                                                //Tar också bort decimal isället för att skriva ex "2.0"

}
