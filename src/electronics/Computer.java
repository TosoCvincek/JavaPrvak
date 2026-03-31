/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronics;

import owner.Person;

/**
 *
 * @author Tomáš
 */
public class Computer extends ElectronicDevice {
    private int processorFrequency;
    private double ram;
    private double internalStorage;
    private int displayDiagonal;

    public Computer(Person owner, String type, String brand, int yearOfManufacture, int monthsOfUse, int price, int processorFrequency, double ram, double internalStorage, int displayDiagonal, String comment) {
        super(owner, type, brand, yearOfManufacture, monthsOfUse, price, comment);
        this.processorFrequency = processorFrequency;
        this.ram = ram;
        this.internalStorage = internalStorage;
        this.displayDiagonal = displayDiagonal;
    }

    @Override
    public String toString() {
        return super.toString() + "Frekvencie procesora: " + this.processorFrequency + "Hz, RAM: " + this.ram + "GB, interná pamäť: " + this.internalStorage + "GB, uhlopriečka displeja: " + this.displayDiagonal + "cm \n";
    }
    
    @Override
    public void print() {
        System.out.println(this.toString());
    }
    
    public int getProcessorFrequency() {
        return this.processorFrequency;
    }

    public double getRam() {
        return this.ram;
    }

    public double getInternalStorage() {
        return this.internalStorage;
    }

    public int getDisplayDiagonal() {
        return this.displayDiagonal;
    }

}
