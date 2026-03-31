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
public class Truck extends Vehicle {
    
    private String emissionClass;
    private int maxLoadCapacity;
    
    public Truck (Person person, String vehicleType, String brand, String model, int power, int yearOfManufacture, double engineDisplacement, int drivenKm, String bodyType, String color, int price, String fuel, int maxLoadCapacity, String emissionClass, String comment) {
        super(person, vehicleType, brand, model, power, yearOfManufacture, engineDisplacement, drivenKm, bodyType, color, price, fuel, comment);
        this.maxLoadCapacity = maxLoadCapacity;
        this.emissionClass = emissionClass;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Maximum load capacity: " + this.maxLoadCapacity + ", emission class: " + this.emissionClass + "\n";
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    public String getEmissionClass() {
        return this.emissionClass;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

}
