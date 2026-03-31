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
public class Date {
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year) {    
        this.year = year;
        if ( month > 12 ) {
            System.out.println("Invalid month entered.");
            this.month = 12;
        } else {
            this.day = day;
            this.month = month;
        }
        if (this.month == (1 | 3 | 5 | 8 | 7 | 10 | 12) && this.day > 31) {
            System.out.println("Invalid day entered.");
            this.day = 31;
        } else if (this.month == (4 | 6 | 9 | 11) && this.day > 30) {
            System.out.println("Invalid day entered.");
            this.day = 30;
        } else if (this.month == 2 && this.isLeapYear() /* == true */ && this.day > 29) {
            System.out.println("Invalid day entered.");
            this.day = 29;
        } else if (this.month == 2 && this.isLeapYear() /* == false */ && this.day > 28) {
            System.out.println("Invalid day entered.");
            this.day = 28;
        }
        
    }
    
    public String toString() {
        String text = this.day + "." + this.month + "." + this.year; 
        return text;
    }
    
    public boolean isLeapYear() {
        return (( this.year % 4 == 0 && this.year % 100 != 0 ) || (this.year % 400 == 0));
    }
    
    public int getDaysInMonth() {
        int daysCount;
        switch (this.month) {
            case 1: 
                daysCount = 31; 
                break;
            case 2: 
                if ( this.isLeapYear() ) {
                    daysCount = 29;
                } else {
                    daysCount = 28;
                }
                break;
            case 3: 
                daysCount = 31;
                break;
            case 4: 
                daysCount = 30;
                break;
            case 5: 
                daysCount = 31;
                break;
            case 6: 
                daysCount = 30;
                break;
            case 7: 
                daysCount = 31;
                break;
            case 8: 
                daysCount = 31;
                break;
            case 9: 
                daysCount = 30;
                break;
            case 10: 
                daysCount = 31;
                break;
            case 11: 
                daysCount = 30;
                break;
            case 12: 
                daysCount = 31;
                break;
            default: 
                daysCount = 0;
                break;
        }
        return daysCount;
    } 
 
    public String getTomorrow() {
        int den = this.day; 
        int mesiac = this.month;
        int rok = this.year;
        if (den < this.getDaysInMonth() ) {
            den = den + 1;
        } else if (den == this.getDaysInMonth() ) {
            den = 1;
            if (mesiac < 12) {
                mesiac = mesiac + 1;
            } else {
                mesiac = 1;
                rok = rok + 1;
            }
        }
        return ("Tomorrow is: " + den + "." + mesiac + "." + rok);
    }
    
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }
    
    public void print() {
        System.out.print(this.day + "." );
        System.out.print(this.month + "." );
        System.out.print(this.year );
    }
}
