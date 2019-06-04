/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majitel;

/**
 *
 * @author Tomáš
 */
public class Datum {
    private int aDen;
    private int aMesiac;
    private int aRok;
    public Datum(int paDen, int paMesiac, int paRok) {    
        this.aRok = paRok;
        if ( paMesiac > 12 ) {
            System.out.println("Zadaný mesiac neexistuje.");
            this.aMesiac = 12;
        } else {
            this.aDen = paDen;
            this.aMesiac = paMesiac;
        }
        if (this.aMesiac == (1 | 3 | 5 | 8 | 7 | 10 | 12) && this.aDen > 31) {
            System.out.println("Zadaný deň neexistuje.");
            this.aDen = 31;
        } else if (this.aMesiac == (4 | 6 | 9 | 11) && this.aDen > 30) {
            System.out.println("Zadaný deň neexistuje.");
            this.aDen = 30;
        } else if (this.aMesiac == 2 && this.jePriestupny() /* == true */ && this.aDen > 29) {
            System.out.println("Zadaný deň neexistuje.");
            this.aDen = 29;
        } else if (this.aMesiac == 2 && this.jePriestupny() /* == false */ && this.aDen > 28) {
            System.out.println("Zadaný deň neexistuje.");
            this.aDen = 28;
        }
        
    }
    
    public String toString() {
        String text = this.aDen + "." + this.aMesiac + "." + this.aRok; 
        return text;
    }
    
    public boolean jePriestupny() {
        return (( this.aRok % 4 == 0 && this.aRok % 100 != 0 ) || (this.aRok % 400 == 0));
    }
    
    public int dajPocetDniVMesiaci() {
        int pocetdni;
        switch (this.aMesiac) {
            case 1: 
                pocetdni = 31; 
                break;
            case 2: 
                if ( this.jePriestupny() ) {
                    pocetdni = 29;
                } else {
                    pocetdni = 28;
                }
                break;
            case 3: 
                pocetdni = 31;
                break;
            case 4: 
                pocetdni = 30;
                break;
            case 5: 
                pocetdni = 31;
                break;
            case 6: 
                pocetdni = 30;
                break;
            case 7: 
                pocetdni = 31;
                break;
            case 8: 
                pocetdni = 31;
                break;
            case 9: 
                pocetdni = 30;
                break;
            case 10: 
                pocetdni = 31;
                break;
            case 11: 
                pocetdni = 30;
                break;
            case 12: 
                pocetdni = 31;
                break;
            default: 
                pocetdni = 0;
                break;
        }
        return pocetdni;
    } 
 
    public String dajZajtra() {
        int den = this.aDen; 
        int mesiac = this.aMesiac;
        int rok = this.aRok;
        if (den < this.dajPocetDniVMesiaci() ) {
            den = den + 1;
        } else if (den == this.dajPocetDniVMesiaci() ) {
            den = 1;
            if (mesiac < 12) {
                mesiac = mesiac + 1;
            } else {
                mesiac = 1;
                rok = rok + 1;
            }
        }
        return ("Zajtra je: " + den + "." + mesiac + "." + rok);
    }
    
    public int getDen() {
        return this.aDen;
    }
    public int getMesiac() {
        return this.aMesiac;
    }
    public int getRok() {
        return this.aRok;
    }
    
    public void vypis() {
        System.out.print(this.aDen + "." );
        System.out.print(this.aMesiac + "." );
        System.out.print(this.aRok );
    }
}

