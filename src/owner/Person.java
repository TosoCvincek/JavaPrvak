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
public class Person {
    private String firstName;
    private String lastName; 
    private Date dateOfBirth;
    private Location location;
    public Person(String firstName, String lastName, int day, int month, int year, String city, long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new Date( day, month, year);
        this.location = new Location(city, phone);
    }
    
    public void printPerson() {
        System.out.print(this.firstName);
        System.out.print(" ");
        System.out.print(this.lastName + " ");
        this.dateOfBirth.print();
        this.location.print();
    }     
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public Date getDateOfBirth() {
        return this.dateOfBirth; 
    }
    
    public void setFirstName (String newFirstName) {
        this.firstName = newFirstName;   
    }
    
    public void setLastName (String newLastName) {
        this.lastName = newLastName;   
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public String toString () {
        String toString = this.firstName + " " + this.lastName + " " + "born:" + this.dateOfBirth.toString() + this.location.toString();
        return toString;
    }
    
    public int getAge() {
        return (2017 - this.dateOfBirth.getYear());
    }
}
