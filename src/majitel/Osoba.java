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
public class Osoba {
    private String aMeno;
    private String aPriezvisko; 
    private Datum aDatumNarodenia;
    private Lokalita aLokalita;
    public Osoba(String paMeno, String paPriezvisko, int paDen, int paMesiac, int paRok, String paLokalita, long paCislo) {
        this.aMeno = paMeno;
        this.aPriezvisko = paPriezvisko;
        this.aDatumNarodenia = new Datum( paDen, paMesiac, paRok);
        this.aLokalita = new Lokalita(paLokalita, paCislo);
    }
    
    public void vypisOsobu() {
        System.out.print(this.aMeno);
        System.out.print(" ");
        System.out.print(this.aPriezvisko + " ");
        this.aDatumNarodenia.vypis();
        this.aLokalita.vypis();
    }     
    
    public String getMeno() {
        return this.aMeno;
    }
    
    public String getPriezvisko() {
        return this.aPriezvisko;
    }
    
    public Datum getDatumNarodenia() {
        return this.aDatumNarodenia; 
    }
    
    public void setMeno (String paNoveMeno) {
        this.aMeno = paNoveMeno;   
    }
    
    public void setPriezvisko (String paNovePriezvisko) {
        this.aPriezvisko = paNovePriezvisko;   
    }
    
    public Lokalita getMesto() {
        return this.aLokalita;
    }
    
    public String toString () {
        String toString = this.aMeno + " " + this.aPriezvisko + " " + "narodeny:" + this.aDatumNarodenia.toString() + this.aLokalita.toString();
        return toString;
    }
    
    public int dajVek() {
        return (2017 - this.aDatumNarodenia.getRok());
    }
}

