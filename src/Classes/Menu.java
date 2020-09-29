package Classes;
import Subclasses.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-25
 * Time: 13:19
 * Project: HealhyPets
 * Copyright: MIT
 */

public class Menu {
    static List<Animal> animals = new ArrayList<>();

    public static void menu() throws IllegalArgumentException {

        animalsInHotel();

        boolean successfulInput = false;

        while(!successfulInput) {
        String input = JOptionPane.showInputDialog("Vilket djur vill du mata? \n" +
                "Sixten\n" +
                "Dogge\n" +
                "Venus\n" +
                "Ove\n" +
                "Hypno");

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
            for(var name: Names.values()){
                if(name.name().equalsIgnoreCase(input)){
                    correctName = true;
                    break;
                }
            }
            if (correctName) {
                switch (Names.valueOf(input.toUpperCase())) {
                    case SIXTEN:
                    case DOGGE:
                    case VENUS:
                    case OVE:
                    case HYPNO:
                        printFoodAmount(getAnimal(input));
                        successfulInput = true;
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Namnet som du skrivit in finns inte på hotellet. Försök igen!");
            }
        }

    }

    public static void animalsInHotel() {

        Dog sixten = new Dog("Sixten", 5);
        Dog dogge = new Dog("Dogge", 10);
        Cat venus = new Cat("Venus", 5);
        Cat ove = new Cat("Ove", 3);
        Snake hypno = new Snake("Hypno", 1);

        animals.add(sixten);
        animals.add(dogge);
        animals.add(venus);
        animals.add(ove);
        animals.add(hypno);

    }

    public static Animal getAnimal(String name) {

        for (var animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public static void printFoodAmount(Animal animal){

        JOptionPane.showMessageDialog(null, String.format("%s ska ha %s g %s.", animal.getName(), df.format(animal.getFoodAmount()), animal.getFoodType()));
    }

    static DecimalFormat df = new DecimalFormat("#.##"); //Används för att undvika alldeles för många decimaler.

}
