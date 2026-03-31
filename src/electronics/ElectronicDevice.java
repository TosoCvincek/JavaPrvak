/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronics;

import bazaar.IForSale;
import owner.Person;

/**
 *
 * @author Tomáš
 */
public class ElectronicDevice implements IForSale {
    private Person owner;
    private String type;
    private String brand;
    private int yearOfManufacture;
    private int monthsOfUse;
    private int price;
    private String comment;

    public ElectronicDevice(Person owner, String type, String brand, int yearOfManufacture, int monthsOfUse, int price, String comment) {
        this.owner = owner;
        this.type = type;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.monthsOfUse = monthsOfUse;
        this.price = price;
        this.comment = comment;
    }
    
    public String toString() {
        String text = this.type + " " + this.brand + ", manufactured in year " + this.yearOfManufacture; 
        String text2 = " used by previous owner for " + this.monthsOfUse + " months, offered by: " + this.owner.toString() + " for price " + this.price + "€\n";
        String commentLine = "User comment: " + this.comment;
        return text + text2 + commentLine;
    }
    
    public void print() {
        System.out.println(this.toString());
    }

    public Person getOwner() {
        return this.owner;
    }

    public String getType() {
        return this.type;
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

    
}
