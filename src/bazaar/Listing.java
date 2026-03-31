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
        String result = "Vypis: \n";
        for (IForSale current : this.database) {
            result = result + current.toString() + "\n";
        }
        return result;
    }
    /**
     * Metóda zapisuje databázu do binárneho súboru, jednotlivo, po prvkoch arraylistu.
     * V prípade problémov vyhodí výnimku pomocou JOptionPane
     *
     * @throws java.io.IOException
    */
    public void saveDatabase() throws IOException {
        boolean koniec = false;
        DataOutputStream zapisovac = null;
        try {
            File subor = new File ("databaza.bin");
            FileOutputStream zapis = new FileOutputStream(subor);
            zapisovac = new DataOutputStream(zapis);
            for (IForSale current: this.database) {
                if (current instanceof Vehicle) {
                    if (current instanceof Car) {
                        zapisovac.writeUTF("Auto");
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLastName());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Vehicle)current).getVehicleType());
                        zapisovac.writeUTF(((Vehicle)current).getBrand());
                        zapisovac.writeUTF(((Vehicle)current).getModel());
                        zapisovac.writeInt(((Vehicle)current).getPower());
                        zapisovac.writeInt(((Vehicle)current).getYearOfManufacture());
                        zapisovac.writeDouble(((Vehicle)current).getEngineDisplacement());
                        zapisovac.writeInt(((Vehicle)current).getDrivenKm());
                        zapisovac.writeUTF(((Vehicle)current).getBodyType());
                        zapisovac.writeUTF(((Vehicle)current).getColor());
                        zapisovac.writeInt(((Vehicle)current).getPrice());
                        zapisovac.writeUTF(((Vehicle)current).getFuel());
                        zapisovac.writeUTF(((Vehicle)current).getComment());
                    } else if (current instanceof Truck) {
                        zapisovac.writeUTF("Kamion");
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLastName());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Vehicle)current).getVehicleType());
                        zapisovac.writeUTF(((Vehicle)current).getBrand());
                        zapisovac.writeUTF(((Vehicle)current).getModel());
                        zapisovac.writeInt(((Vehicle)current).getPower());
                        zapisovac.writeInt(((Vehicle)current).getYearOfManufacture());
                        zapisovac.writeDouble(((Vehicle)current).getEngineDisplacement());
                        zapisovac.writeInt(((Vehicle)current).getDrivenKm());
                        zapisovac.writeUTF(((Vehicle)current).getBodyType());
                        zapisovac.writeUTF(((Vehicle)current).getColor());
                        zapisovac.writeInt(((Vehicle)current).getPrice());
                        zapisovac.writeUTF(((Vehicle)current).getFuel());
                        zapisovac.writeInt(((Truck)((Vehicle)current)).getMaxLoadCapacity());
                        zapisovac.writeUTF(((Truck)((Vehicle)current)).getEmissionClass());
                        zapisovac.writeUTF(((Vehicle)current).getComment());
                    } else if (current instanceof Bus) {
                        zapisovac.writeUTF("Autobus");
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLastName());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Vehicle)current).getVehicleType());
                        zapisovac.writeUTF(((Vehicle)current).getBrand());
                        zapisovac.writeUTF(((Vehicle)current).getModel());
                        zapisovac.writeInt(((Vehicle)current).getPower());
                        zapisovac.writeInt(((Vehicle)current).getYearOfManufacture());
                        zapisovac.writeDouble(((Vehicle)current).getEngineDisplacement());
                        zapisovac.writeInt(((Vehicle)current).getDrivenKm());
                        zapisovac.writeUTF(((Vehicle)current).getBodyType());
                        zapisovac.writeUTF(((Vehicle)current).getColor());
                        zapisovac.writeInt(((Vehicle)current).getPrice());
                        zapisovac.writeUTF(((Vehicle)current).getFuel());
                        zapisovac.writeInt(((Bus)((Vehicle)current)).getSeatCount());
                        zapisovac.writeUTF(((Bus)((Vehicle)current)).getEmissionClass());
                        zapisovac.writeUTF(((Vehicle)current).getComment());
                    } else if (current instanceof Motorcycle) {
                        zapisovac.writeUTF("Motorka");
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLastName());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Vehicle)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Vehicle)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Vehicle)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Vehicle)current).getVehicleType());
                        zapisovac.writeUTF(((Vehicle)current).getBrand());
                        zapisovac.writeUTF(((Vehicle)current).getModel());
                        zapisovac.writeInt(((Vehicle)current).getPower());
                        zapisovac.writeInt(((Vehicle)current).getYearOfManufacture());
                        zapisovac.writeDouble(((Vehicle)current).getEngineDisplacement());
                        zapisovac.writeInt(((Vehicle)current).getDrivenKm());
                        zapisovac.writeUTF(((Vehicle)current).getBodyType());
                        zapisovac.writeUTF(((Vehicle)current).getColor());
                        zapisovac.writeInt(((Vehicle)current).getPrice());
                        zapisovac.writeUTF(((Vehicle)current).getFuel());
                        zapisovac.writeUTF(((Vehicle)current).getComment());
                    }  
                } else if (current instanceof Machine) {
                    if (current instanceof BrushCutter) {
                        zapisovac.writeUTF("Krovinorez");
                        zapisovac.writeUTF(((Machine)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Machine)current).getOwner().getLastName());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Machine)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Machine)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Machine)current).getMachineType());
                        zapisovac.writeInt(((Machine)current).getPowerInKw());
                        zapisovac.writeDouble(((Machine)current).getVolume());
                        zapisovac.writeUTF(((Machine)current).getBrand());
                        zapisovac.writeInt(((Machine)current).getYearOfManufacture());
                        zapisovac.writeInt(((Machine)current).getMonthsOfUse());
                        zapisovac.writeInt(((Machine)current).getPrice());
                        zapisovac.writeUTF(((Machine)current).getComment());
                    } else if (current instanceof LawnMower) {
                        zapisovac.writeUTF("Kosacka");
                        zapisovac.writeUTF(((Machine)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Machine)current).getOwner().getLastName());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Machine)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Machine)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Machine)current).getMachineType());
                        zapisovac.writeInt(((Machine)current).getPowerInKw());
                        zapisovac.writeDouble(((Machine)current).getVolume());
                        zapisovac.writeUTF(((Machine)current).getBrand());
                        zapisovac.writeInt(((Machine)current).getYearOfManufacture());
                        zapisovac.writeInt(((Machine)current).getMonthsOfUse());
                        zapisovac.writeInt(((Machine)current).getPrice());
                        zapisovac.writeUTF(((Machine)current).getComment());
                    } else if (current instanceof Chainsaw) {
                        zapisovac.writeUTF("MotorovaPila");
                        zapisovac.writeUTF(((Machine)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((Machine)current).getOwner().getLastName());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((Machine)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((Machine)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((Machine)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((Machine)current).getMachineType());
                        zapisovac.writeInt(((Machine)current).getPowerInKw());
                        zapisovac.writeDouble(((Machine)current).getVolume());
                        zapisovac.writeUTF(((Machine)current).getBrand());
                        zapisovac.writeInt(((Machine)current).getYearOfManufacture());
                        zapisovac.writeInt(((Machine)current).getMonthsOfUse());
                        zapisovac.writeInt(((Machine)current).getPrice());
                        zapisovac.writeUTF(((Machine)current).getComment());
                    }
                } else if (current instanceof ElectronicDevice) {
                    if (current instanceof Computer) {
                        zapisovac.writeUTF("Pocitac");
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getLastName());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((ElectronicDevice)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((ElectronicDevice)current).getType());
                        zapisovac.writeUTF(((ElectronicDevice)current).getBrand());
                        zapisovac.writeInt(((ElectronicDevice)current).getYearOfManufacture());
                        zapisovac.writeInt(((ElectronicDevice)current).getMonthsOfUse());
                        zapisovac.writeInt(((ElectronicDevice)current).getPrice());
                        zapisovac.writeInt(((Computer)((ElectronicDevice)current)).getProcessorFrequency());
                        zapisovac.writeDouble(((Computer)((ElectronicDevice)current)).getRam());
                        zapisovac.writeDouble(((Computer)((ElectronicDevice)current)).getInternalStorage());
                        zapisovac.writeInt(((Computer)((ElectronicDevice)current)).getDisplayDiagonal());
                        zapisovac.writeUTF(((ElectronicDevice)current).getComment());
                    } else if (current instanceof Mobile) {
                        zapisovac.writeUTF("Mobil");
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getLastName());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((ElectronicDevice)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((ElectronicDevice)current).getType());
                        zapisovac.writeUTF(((ElectronicDevice)current).getBrand());
                        zapisovac.writeInt(((ElectronicDevice)current).getYearOfManufacture());
                        zapisovac.writeInt(((ElectronicDevice)current).getMonthsOfUse());
                        zapisovac.writeInt(((ElectronicDevice)current).getPrice());
                        zapisovac.writeInt(((Mobile)((ElectronicDevice)current)).getProcessorFrequency());
                        zapisovac.writeDouble(((Mobile)((ElectronicDevice)current)).getRam());
                        zapisovac.writeDouble(((Mobile)((ElectronicDevice)current)).getInternalStorage());
                        zapisovac.writeInt(((Mobile)((ElectronicDevice)current)).getBatteryLife());
                        zapisovac.writeInt(((Mobile)((ElectronicDevice)current)).getCameraResolution());
                        zapisovac.writeUTF(((ElectronicDevice)current).getComment());
                    } else if (current instanceof Electronics) {
                        zapisovac.writeUTF("Elektronika");
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getFirstName());
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getLastName());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getDay());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getMonth());
                        zapisovac.writeInt(((ElectronicDevice)current).getOwner().getDateOfBirth().getYear());
                        zapisovac.writeUTF(((ElectronicDevice)current).getOwner().getLocation().getCity());
                        zapisovac.writeLong(((ElectronicDevice)current).getOwner().getLocation().getPhone());
                        zapisovac.writeUTF(((ElectronicDevice)current).getType());
                        zapisovac.writeUTF(((ElectronicDevice)current).getBrand());
                        zapisovac.writeInt(((ElectronicDevice)current).getYearOfManufacture());
                        zapisovac.writeInt(((ElectronicDevice)current).getMonthsOfUse());
                        zapisovac.writeInt(((ElectronicDevice)current).getPrice());
                        zapisovac.writeUTF(((ElectronicDevice)current).getComment());
                    }
                }   
            } 
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Chyba! " + ex.getMessage());
        } finally {
            if (zapisovac != null) {
                try {
                    zapisovac.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Chyba! " + ex.getMessage());
                }
            }
        }
    }
    /**
     * Metóda nacita databazu zo suboru postupne, tak ako sa ukladá, tak sa aj cíta.
     * Pri chybe sa výnimka rethrowuje do nadradenej triedy
     * @return boolean
     * @throws IOException 
     */
    
    
    public boolean loadDatabase() throws IOException {
        boolean koniecSuboru = false;
        DataInputStream citac = null;
        try {
            File subor = new File ("databaza.bin");
            FileInputStream citaj = new FileInputStream(subor);
            citac = new DataInputStream(citaj);
            do {
                try {
                    String type = citac.readUTF();
                    if (type.equals("Auto")) {
                        this.addListing(new Car (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));                                            
                    } else if (type.equals("Motorka")) {
                        this.addListing(new Motorcycle (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));                                            
                    } else if (type.equals("Kamion")) {
                        this.addListing(new Truck (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));
                    } else if (type.equals("Autobus")) {
                        this.addListing(new Bus (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));
                    } else if (type.equals("Kosacka")) {
                        this.addListing(new LawnMower (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readInt(), citac.readDouble(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (type.equals("Krovinorez")) {
                        this.addListing(new BrushCutter (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readInt(), citac.readDouble(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (type.equals("MotorovaPila")) {
                        this.addListing(new Chainsaw (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readInt(), citac.readDouble(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (type.equals("Elektronika")) {
                        this.addListing(new Electronics (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (type.equals("Pocitac")) {
                        this.addListing(new Computer (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readDouble(), citac.readInt(), citac.readUTF()));
                    } else if (type.equals("Mobil")) {
                        this.addListing(new Mobile (new Person (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readDouble(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    }
                } catch (EOFException ex) {
                    koniecSuboru = true;
                }
            } while (!koniecSuboru);
        } catch (FileNotFoundException ex) {
            throw ex;
        } finally {
            if (citac != null) {
                try {
                    citac.close();
                } catch (FileNotFoundException ex) {
                    throw ex;
                }
            }
        }
        return true;
    }
}
