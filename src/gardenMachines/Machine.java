/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenMachines;

import bazaar.IForSale;
import owner.Person;

/**
 *
 * @author Tomáš
 */
public class Machine implements IForSale {
    private Person owner;
    private String machineType;
    private int powerInKw;
    private double volume;
    private String brand;
    private int yearOfManufacture;
    private int monthsOfUse;
    private int price;
    private String comment;

    public Machine(Person owner, String machineType, int powerInKw, double volume, String brand, int yearOfManufacture, int monthsOfUse, int price, String comment) {
        this.owner = owner;
        this.powerInKw = powerInKw;
        this.volume = volume;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.monthsOfUse = monthsOfUse;
        this.price = price;
        this.comment = comment;
        this.machineType = machineType;
    }
    
    public String toString() {
        String text = "Garden machine " + this.machineType + " " + this.brand + ", power: " + this.powerInKw + " KW, engine volume " + this.volume + ", manufactured in year " + this.yearOfManufacture; 
        String text2 = "used by previous owner for " + this.monthsOfUse + " months, offered by: " + this.owner.toString() + " for price " + this.price + "€\n";
        String komentar1 = "User comment: " + this.comment;
        return text + text2 + komentar1;
    }
    
    public void print() {
        System.out.println(this.toString());
    }

    public Person getOwner() {
        return this.owner;
    }

    public int getPowerInKw() {
        return this.powerInKw;
    }

    public double getVolume() {
        return this.volume;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getYearOfManufacture() {
        return this.yearOfManufacture;
    }

    public int getMonthsOfUse() {
        return this.monthsOfUse;
    }

    public int getPrice() {
        return this.price;
    }

    public String getComment() {
        return this.comment;
    }

    public String getMachineType() {
        return this.machineType;
    }
    
    
    
}
