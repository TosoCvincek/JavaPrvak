/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenMachines;

import owner.Person;

/**
 *
 * @author Tomáš
 */
public class BrushCutter extends Machine {
    
    public BrushCutter(Person owner, String machineType, int powerInKw, double volume, String brand, int yearOfManufacture, int monthsOfUse, int price, String comment) {
        super(owner, machineType, powerInKw, volume, brand, yearOfManufacture, monthsOfUse, price, comment);
    }
    
    
}
