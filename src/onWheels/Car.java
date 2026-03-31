/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onWheels;

import owner.Person;

/**
 *
 * @author Tomáš
 */
public class Car extends Vehicle {

    public Car(Person person, String vehicleType, String brand, String model, int power, int yearOfManufacture, double engineDisplacement, int drivenKm, String bodyType, String color, int price, String fuel, String comment) {
        super(person, vehicleType, brand, model, power, yearOfManufacture, engineDisplacement, drivenKm, bodyType, color, price, fuel, comment);
    }
    
}
