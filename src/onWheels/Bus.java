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
public class Bus extends Vehicle {
    private String emissionClass;
    private int seatCount;
    
    public Bus(Person person, String vehicleType, String brand, String model, int power, int yearOfManufacture, double engineDisplacement, int drivenKm, String bodyType, String color, int price, String fuel, int seatCount, String emissionClass, String comment) {
        super(person, vehicleType, brand, model, power, yearOfManufacture, engineDisplacement, drivenKm, bodyType, color, price, fuel, comment);
        this.seatCount = seatCount;
        this.emissionClass = emissionClass;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Pocet miest na sedenie: " + this.seatCount + ", emisná trieda: " + this.emissionClass + "\n";
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    public String getEmissionClass() {
        return this.emissionClass;
    }

    public int getSeatCount() {
        return this.seatCount;
    }
      
}
