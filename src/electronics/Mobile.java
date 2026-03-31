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
public class Mobile extends ElectronicDevice {
    
    private int processorFrequency;
    private double ram;
    private double internalStorage;
    private int batteryLife;
    private int cameraResolution;

    public Mobile(Person owner, String type, String brand, int yearOfManufacture, int monthsOfUse, int price, int processorFrequency, double ram, double internalStorage, int batteryLife, int cameraResolution, String comment) {
        super(owner, type, brand, yearOfManufacture, monthsOfUse, price, comment);
        this.processorFrequency = processorFrequency;
        this.ram = ram;
        this.internalStorage = internalStorage;
        this.batteryLife = batteryLife;
        this.cameraResolution = cameraResolution;
    }

    @Override
    public String toString() {
        return super.toString() + "Frekvencie procesora: " + this.processorFrequency + "Hz, RAM: " + this.ram + "GB, interná pamäť: " + this.internalStorage + "GB, výdrž batérie: " + this.batteryLife + "mAh, rozlíšenie fotoaparátu: " + this.cameraResolution + "megapixelov \n";
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

    public int getBatteryLife() {
        return this.batteryLife;
    }

    public int getCameraResolution() {
        
        return this.cameraResolution;
    }
    
}
