/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owner;

/**
 *
 * @author Tomáš
 */
public class Location {
    private String city;
    private long phone;
    public Location(String city, long phone) {
        this.city = city;
        this.phone = phone;
    }
    
    public String getCity() { 
        return this.city;
    }
    
    public long getPhone() {
        return this.phone;
    }
    
    public String toString() {
        String text = " " + this.city + ", kontakt: " + this.getPhone() ;
        return text;  
    }
    
    public void print() { 
        System.out.print(this.toString());
    }
}
