/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazaar;

import electronics.ElectronicDevice;
import electronics.Electronics;
import electronics.Mobile;
import electronics.Computer;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import owner.Person;
import onWheels.Car;
import onWheels.Bus;
import onWheels.Truck;
import onWheels.Motorcycle;
import onWheels.Vehicle;
import gardenMachines.LawnMower;
import gardenMachines.BrushCutter;
import gardenMachines.Chainsaw;
import gardenMachines.Machine;

/**
 *
 * @author Tomáš
 */
public class Listing {
    private ArrayList<IForSale> database;

    public Listing() {
        this.database = new ArrayList<IForSale>();
    }
    
    public int getCount() {
        return this.database.size();
    }
    public IForSale getListing (int index) {
        try {
            return this.database.get(index);
        } catch (NullPointerException ex) {
            throw ex;
        }
    }
    public boolean addListing(IForSale listing) {
        return this.database.add(listing);
    }
    
    public boolean removeListing(int index) {
        this.database.remove(index);
        return true;
    }
    
    @Override
    public String toString() {
        String result = "Listing: \n";
        for (IForSale current : this.database) {
            result = result + current.toString() + "\n";
        }
        return result;
    }
    /**
     * Method writes the database to a binary file, element by element from the ArrayList.
     * In case of problems, throws an exception using JOptionPane
     *
     * @throws java.io.IOException
    */
    public void saveDatabase() throws IOException {
        DataOutputStream writer = null;
        try {
            File file = new File ("database.bin");
            FileOutputStream output = new FileOutputStream(file);
            writer = new DataOutputStream(output);
            for (IForSale current: this.database) {
                if (current instanceof Vehicle) {
                    if (current instanceof Car) {
                        writer.writeUTF("Car");
                        writer.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        writer.writeUTF(((Vehicle)current).getOwner().getLastName());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Vehicle)current).getVehicleType());
                        writer.writeUTF(((Vehicle)current).getBrand());
                        writer.writeUTF(((Vehicle)current).getModel());
                        writer.writeInt(((Vehicle)current).getPower());
                        writer.writeInt(((Vehicle)current).getYearOfManufacture());
                        writer.writeDouble(((Vehicle)current).getEngineDisplacement());
                        writer.writeInt(((Vehicle)current).getDrivenKm());
                        writer.writeUTF(((Vehicle)current).getBodyType());
                        writer.writeUTF(((Vehicle)current).getColor());
                        writer.writeInt(((Vehicle)current).getPrice());
                        writer.writeUTF(((Vehicle)current).getFuel());
                        writer.writeUTF(((Vehicle)current).getComment());
                    } else if (current instanceof Truck) {
                        writer.writeUTF("Truck");
                        writer.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        writer.writeUTF(((Vehicle)current).getOwner().getLastName());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Vehicle)current).getVehicleType());
                        writer.writeUTF(((Vehicle)current).getBrand());
                        writer.writeUTF(((Vehicle)current).getModel());
                        writer.writeInt(((Vehicle)current).getPower());
                        writer.writeInt(((Vehicle)current).getYearOfManufacture());
                        writer.writeDouble(((Vehicle)current).getEngineDisplacement());
                        writer.writeInt(((Vehicle)current).getDrivenKm());
                        writer.writeUTF(((Vehicle)current).getBodyType());
                        writer.writeUTF(((Vehicle)current).getColor());
                        writer.writeInt(((Vehicle)current).getPrice());
                        writer.writeUTF(((Vehicle)current).getFuel());
                        writer.writeInt(((Truck)((Vehicle)current)).getMaxLoadCapacity());
                        writer.writeUTF(((Truck)((Vehicle)current)).getEmissionClass());
                        writer.writeUTF(((Vehicle)current).getComment());
                    } else if (current instanceof Bus) {
                        writer.writeUTF("Bus");
                        writer.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        writer.writeUTF(((Vehicle)current).getOwner().getLastName());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Vehicle)current).getVehicleType());
                        writer.writeUTF(((Vehicle)current).getBrand());
                        writer.writeUTF(((Vehicle)current).getModel());
                        writer.writeInt(((Vehicle)current).getPower());
                        writer.writeInt(((Vehicle)current).getYearOfManufacture());
                        writer.writeDouble(((Vehicle)current).getEngineDisplacement());
                        writer.writeInt(((Vehicle)current).getDrivenKm());
                        writer.writeUTF(((Vehicle)current).getBodyType());
                        writer.writeUTF(((Vehicle)current).getColor());
                        writer.writeInt(((Vehicle)current).getPrice());
                        writer.writeUTF(((Vehicle)current).getFuel());
                        writer.writeInt(((Bus)((Vehicle)current)).getSeatCount());
                        writer.writeUTF(((Bus)((Vehicle)current)).getEmissionClass());
                        writer.writeUTF(((Vehicle)current).getComment());
                    } else if (current instanceof Motorcycle) {
                        writer.writeUTF("Motorcycle");
                        writer.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        writer.writeUTF(((Vehicle)current).getOwner().getLastName());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Vehicle)current).getVehicleType());
                        writer.writeUTF(((Vehicle)current).getBrand());
                        writer.writeUTF(((Vehicle)current).getModel());
                        writer.writeInt(((Vehicle)current).getPower());
                        writer.writeInt(((Vehicle)current).getYearOfManufacture());
                        writer.writeDouble(((Vehicle)current).getEngineDisplacement());
                        writer.writeInt(((Vehicle)current).getDrivenKm());
                        writer.writeUTF(((Vehicle)current).getBodyType());
                        writer.writeUTF(((Vehicle)current).getColor());
                        writer.writeInt(((Vehicle)current).getPrice());
                        writer.writeUTF(((Vehicle)current).getFuel());
                        writer.writeUTF(((Vehicle)current).getComment());
                    }  
                } else if (current instanceof Machine) {
                    if (current instanceof BrushCutter) {
                        writer.writeUTF("BrushCutter");
                        writer.writeUTF(((Machine)current).getOwner().getFirstName());
                        writer.writeUTF(((Machine)current).getOwner().getLastName());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Machine)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Machine)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Machine)current).getMachineType());
                        writer.writeInt(((Machine)current).getPowerInKw());
                        writer.writeDouble(((Machine)current).getVolume());
                        writer.writeUTF(((Machine)current).getBrand());
                        writer.writeInt(((Machine)current).getYearOfManufacture());
                        writer.writeInt(((Machine)current).getMonthsOfUse());
                        writer.writeInt(((Machine)current).getPrice());
                        writer.writeUTF(((Machine)current).getComment());
                    } else if (current instanceof LawnMower) {
                        writer.writeUTF("LawnMower");
                        writer.writeUTF(((Machine)current).getOwner().getFirstName());
                        writer.writeUTF(((Machine)current).getOwner().getLastName());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Machine)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Machine)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Machine)current).getMachineType());
                        writer.writeInt(((Machine)current).getPowerInKw());
                        writer.writeDouble(((Machine)current).getVolume());
                        writer.writeUTF(((Machine)current).getBrand());
                        writer.writeInt(((Machine)current).getYearOfManufacture());
                        writer.writeInt(((Machine)current).getMonthsOfUse());
                        writer.writeInt(((Machine)current).getPrice());
                        writer.writeUTF(((Machine)current).getComment());
                    } else if (current instanceof Chainsaw) {
                        writer.writeUTF("Chainsaw");
                        writer.writeUTF(((Machine)current).getOwner().getFirstName());
                        writer.writeUTF(((Machine)current).getOwner().getLastName());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((Machine)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((Machine)current).getOwner().getLocation().getCity());
                        writer.writeLong(((Machine)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((Machine)current).getMachineType());
                        writer.writeInt(((Machine)current).getPowerInKw());
                        writer.writeDouble(((Machine)current).getVolume());
                        writer.writeUTF(((Machine)current).getBrand());
                        writer.writeInt(((Machine)current).getYearOfManufacture());
                        writer.writeInt(((Machine)current).getMonthsOfUse());
                        writer.writeInt(((Machine)current).getPrice());
                        writer.writeUTF(((Machine)current).getComment());
                    }
                } else if (current instanceof ElectronicDevice) {
                    if (current instanceof Computer) {
                        writer.writeUTF("Computer");
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getFirstName());
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getLastName());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getLocation().getCity());
                        writer.writeLong(((ElectronicDevice)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((ElectronicDevice)current).getType());
                        writer.writeUTF(((ElectronicDevice)current).getBrand());
                        writer.writeInt(((ElectronicDevice)current).getYearOfManufacture());
                        writer.writeInt(((ElectronicDevice)current).getMonthsOfUse());
                        writer.writeInt(((ElectronicDevice)current).getPrice());
                        writer.writeInt(((Computer)((ElectronicDevice)current)).getProcessorFrequency());
                        writer.writeDouble(((Computer)((ElectronicDevice)current)).getRam());
                        writer.writeDouble(((Computer)((ElectronicDevice)current)).getInternalStorage());
                        writer.writeInt(((Computer)((ElectronicDevice)current)).getDisplayDiagonal());
                        writer.writeUTF(((ElectronicDevice)current).getComment());
                    } else if (current instanceof Mobile) {
                        writer.writeUTF("Mobile");
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getFirstName());
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getLastName());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getLocation().getCity());
                        writer.writeLong(((ElectronicDevice)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((ElectronicDevice)current).getType());
                        writer.writeUTF(((ElectronicDevice)current).getBrand());
                        writer.writeInt(((ElectronicDevice)current).getYearOfManufacture());
                        writer.writeInt(((ElectronicDevice)current).getMonthsOfUse());
                        writer.writeInt(((ElectronicDevice)current).getPrice());
                        writer.writeInt(((Mobile)((ElectronicDevice)current)).getProcessorFrequency());
                        writer.writeDouble(((Mobile)((ElectronicDevice)current)).getRam());
                        writer.writeDouble(((Mobile)((ElectronicDevice)current)).getInternalStorage());
                        writer.writeInt(((Mobile)((ElectronicDevice)current)).getBatteryLife());
                        writer.writeInt(((Mobile)((ElectronicDevice)current)).getCameraResolution());
                        writer.writeUTF(((ElectronicDevice)current).getComment());
                    } else if (current instanceof Electronics) {
                        writer.writeUTF("Electronics");
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getFirstName());
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getLastName());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getDay());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getMonth());
                        writer.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getYear());
                        writer.writeUTF(((ElectronicDevice)current).getOwner().getLocation().getCity());
                        writer.writeLong(((ElectronicDevice)current).getOwner().getLocation().getPhone());
                        writer.writeUTF(((ElectronicDevice)current).getType());
                        writer.writeUTF(((ElectronicDevice)current).getBrand());
                        writer.writeInt(((ElectronicDevice)current).getYearOfManufacture());
                        writer.writeInt(((ElectronicDevice)current).getMonthsOfUse());
                        writer.writeInt(((ElectronicDevice)current).getPrice());
                        writer.writeUTF(((ElectronicDevice)current).getComment());
                    }
                }   
            } 
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error! " + ex.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error! " + ex.getMessage());
                }
            }
        }
    }
    /**
     * Method loads the database from a file sequentially, reading it the same way it was written.
     * On error, the exception is rethrown to the parent class.
     * @return boolean
     * @throws IOException 
     */
    
    
    public boolean loadDatabase() throws IOException {
        boolean endOfFile = false;
        DataInputStream reader = null;
        try {
            File file = new File ("database.bin");
            FileInputStream inputStream = new FileInputStream(file);
            reader = new DataInputStream(inputStream);
            do {
                try {
                    String type = reader.readUTF();
                    if (type.equals("Car")) {
                        this.addListing(new Car (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readDouble(), reader.readInt(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readUTF(), reader.readUTF()));                                            
                    } else if (type.equals("Motorcycle")) {
                        this.addListing(new Motorcycle (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readDouble(), reader.readInt(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readUTF(), reader.readUTF()));                                            
                    } else if (type.equals("Truck")) {
                        this.addListing(new Truck (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readDouble(), reader.readInt(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readUTF(), reader.readInt(), reader.readUTF(), reader.readUTF()));
                    } else if (type.equals("Bus")) {
                        this.addListing(new Bus (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readDouble(), reader.readInt(), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readUTF(), reader.readInt(), reader.readUTF(), reader.readUTF()));
                    } else if (type.equals("LawnMower")) {
                        this.addListing(new LawnMower (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readInt(), reader.readDouble(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF()));
                    } else if (type.equals("BrushCutter")) {
                        this.addListing(new BrushCutter (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readInt(), reader.readDouble(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF()));
                    } else if (type.equals("Chainsaw")) {
                        this.addListing(new Chainsaw (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readInt(), reader.readDouble(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF()));
                    } else if (type.equals("Electronics")) {
                        this.addListing(new Electronics (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF()));
                    } else if (type.equals("Computer")) {
                        this.addListing(new Computer (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readDouble(), reader.readDouble(), reader.readInt(), reader.readUTF()));
                    } else if (type.equals("Mobile")) {
                        this.addListing(new Mobile (new Person (reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readUTF(), reader.readLong()), reader.readUTF(), reader.readUTF(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readInt(), reader.readDouble(), reader.readDouble(), reader.readInt(), reader.readInt(), reader.readUTF()));
                    }
                } catch (EOFException ex) {
                    endOfFile = true;
                }
            } while (!endOfFile);
        } catch (FileNotFoundException ex) {
            throw ex;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (FileNotFoundException ex) {
                    throw ex;
                }
            }
        }
        return true;
    }
}
