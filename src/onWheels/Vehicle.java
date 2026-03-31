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
 * Trieda Auto ohsahuje atribúty, ktoré sú parametrom auta, ktoré bude neskôr inzerátom. 
 * Niektoré sú primitívnych tipov, niektoré typu String a atribút majitel je typu Osoba.
 * Majitel je vkladaný asociáciou, pretože aj jedna osoba môže mať viac aut.
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
      * V konštruktore sa vytvorí inštancia auto, ktorá musí mať vopred definované vlastnosti a majiteľa, preto parametrami konšturktora sú všetky paramatre vozidla.
      * @param person majiteľ vozidla typu Osoba
      * @param brand značka auta
      * @param model model auta
      * @param power výkon motora v KW
      * @param yearOfManufacture rok, kedy bolo auto vyrobené
      * @param engineDisplacement obsah motora v metroch kubických 
      * @param drivenKm doposiaľ odjazdených km na danom aute 
      * @param bodyType karoséria vozidla
      * @param color farba vozidla
      * @param price cena vozidla v €
      * @param comment dodotočný komentár autora
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
     *Metóda toString() je metóda, v ktorej sa snažím získať hodnoty atribútov v zmysluplnej vete, obsahuje spájanie reťazcov.
     *@return reťazec, ktorý hovorí o parametroch vozidla
     */
    public String toString() {
        String text = this.vehicleType + " " + this.brand + " " + this.model + " " + this.bodyType + ", " + this.fuel + ", " + this.engineDisplacement + ", " + this.color + ", vyrobené v roku " + this.yearOfManufacture; 
        String text2 = " s výkonom " + this.power + "KW, ktoré má nabehané " + this.drivenKm + "km ponúka: " + this.owner.toString() + " za cenu " + this.price + "€\n";
        String komentar1 = "Komentár použivateľa: " + this.comment;
        return text + text2 + komentar1;
    }
    
    /**
     *Metóda vypis() je metóda, v ktorej sa snažím vypísať metódu toString() na terminál.
     * 
     */
    public void print() {
        System.out.println(this.toString());
    }
    
    /**
     *Vrátí značku auta.
     *@return značka vozidla
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     *Vrátí model auta.
     *@return model vozidla
     */
    public String getModel() {
        return this.model;
    }
    
    /**
     *Vrátí majiteľa vozidla
     *@return Objekt typu osoba 
     */
    public Person getOwner() {
        return this.owner;
    }
    
    /**
     *Vrátí výkon motora vozidla v KW.
     *@return výkon motora v KW
     */
    public int getPower() {
        return this.power;
    }   
    
    /**
     *Vrátí rok výroby vozidla.
     *@return rok výroby auta 
     */
    public int getYearOfManufacture() {
        return this.yearOfManufacture;
    }
    
    /**
     *Vrátí doposiaľ najazdené km vozidla.
     *@return najazdené km auta
     */
    public int getDrivenKm() {
        return this.drivenKm;
    }
    
    /**
     *Vrátí typ karosérie vozidla.
     *@return karoséria auta
     */
    public String getBodyType() {
        return this.bodyType;
    }
    
    /**
     *Vrátí farbu vozidla.
     *@return farba auta
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     *Vrátí obsah motora vozidla v metroch kubických.
     *@return obsah motora auta
     */
    public double getEngineDisplacement() {
        return this.engineDisplacement;
    }
    
    /**
     *Vrátí cenu vozidla v €.
     *@return cena vozidla
     */
    public int getPrice() {
        return this.price;
    }
    
    /**
     *Vrátí typ vozidla.
     *@return typ vozidla
     */
    public String getVehicleType() {
        return this.vehicleType;
    }
    
    /**
     *Vrátí komentar pouzivatela.
     *@return komentar pouzivatela
     */
    public String getComment() {
        return this.comment;
    }
    
    /**
     *Vrátí palivo vozidla. 
     *@return palivo vozidla
     */
    public String getFuel() {
        return this.fuel;
    }
    
    
}
