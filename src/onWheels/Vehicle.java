/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onWheels;

import bazaar.IForSale;
import owner.Person;

/**
 *
 * @author Tomáš
 */
/**
 * The Vehicle class contains attributes that describe a vehicle for listing in the bazaar.
 * Some are primitive types, some are String type, and the owner attribute is of type Person.
 * Owner is linked by association because one person can own multiple vehicles.
 * @author Tomáš Cvinček
 * @version 2.0
 */
public class Vehicle implements IForSale {
    private Person owner;
    private String vehicleType;
    private String brand;
    private String model;
    private int power;
    private int yearOfManufacture;
    private double engineDisplacement;
    private int drivenKm;
    private String bodyType;
    private String color;
    private int price;
    private String comment;
    private String fuel;
     /**
      * The constructor creates a vehicle instance with all required properties and owner.
      * @param person vehicle owner of type Person
      * @param brand vehicle brand
      * @param model vehicle model
      * @param power engine power in KW
      * @param yearOfManufacture year the vehicle was manufactured
      * @param engineDisplacement engine displacement in cubic meters
      * @param drivenKm kilometers driven so far
      * @param bodyType vehicle body type
      * @param color vehicle color
      * @param price vehicle price in €
      * @param comment additional user comment
      */
    public Vehicle(Person person, String vehicleType, String brand, String model, int power, int yearOfManufacture, double engineDisplacement, int drivenKm, String bodyType, String color, int price, String fuel, String comment) {
        this.owner = person;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.yearOfManufacture = yearOfManufacture;
        this.drivenKm = drivenKm;
        this.bodyType = bodyType;
        this.color = color;
        this.engineDisplacement = engineDisplacement;
        this.price = price;
        this.comment = comment;
        this.vehicleType = vehicleType;
        this.fuel = fuel;
                
    }
    
    /**
     * Returns a string representation of the vehicle's attributes.
     * @return string describing the vehicle parameters
     */
    public String toString() {
        String text = this.vehicleType + " " + this.brand + " " + this.model + " " + this.bodyType + ", " + this.fuel + ", " + this.engineDisplacement + ", " + this.color + ", manufactured in year " + this.yearOfManufacture; 
        String text2 = " with power " + this.power + "KW, with " + this.drivenKm + "km driven, offered by: " + this.owner.toString() + " for price " + this.price + "€\n";
        String komentar1 = "User comment: " + this.comment;
        return text + text2 + komentar1;
    }
    
    /**
     * Prints the vehicle details to the terminal.
     */
    public void print() {
        System.out.println(this.toString());
    }
    
    /**
     * Returns the vehicle brand.
     * @return vehicle brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Returns the vehicle model.
     * @return vehicle model
     */
    public String getModel() {
        return this.model;
    }
    
    /**
     * Returns the vehicle owner.
     * @return Person object
     */
    public Person getOwner() {
        return this.owner;
    }
    
    /**
     * Returns the vehicle engine power in KW.
     * @return engine power in KW
     */
    public int getPower() {
        return this.power;
    }   
    
    /**
     * Returns the year of manufacture.
     * @return year of manufacture
     */
    public int getYearOfManufacture() {
        return this.yearOfManufacture;
    }
    
    /**
     * Returns the kilometers driven.
     * @return kilometers driven
     */
    public int getDrivenKm() {
        return this.drivenKm;
    }
    
    /**
     * Returns the vehicle body type.
     * @return body type
     */
    public String getBodyType() {
        return this.bodyType;
    }
    
    /**
     * Returns the vehicle color.
     * @return vehicle color
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Returns the engine displacement in cubic meters.
     * @return engine displacement
     */
    public double getEngineDisplacement() {
        return this.engineDisplacement;
    }
    
    /**
     * Returns the vehicle price in €.
     * @return vehicle price
     */
    public int getPrice() {
        return this.price;
    }
    
    /**
     * Returns the vehicle type.
     * @return vehicle type
     */
    public String getVehicleType() {
        return this.vehicleType;
    }
    
    /**
     * Returns the user comment.
     * @return user comment
     */
    public String getComment() {
        return this.comment;
    }
    
    /**
     * Returns the vehicle fuel type.
     * @return fuel type
     */
    public String getFuel() {
        return this.fuel;
    }
    
    
}
