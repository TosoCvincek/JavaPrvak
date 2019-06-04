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
public class Lokalita {
    private String mesto; //mesto, kde osoba býva
    private long telefon; //telefónne číslo bez úvodnej nuly
    public Lokalita(String paMesto, long paCislo) {
        this.mesto = paMesto;
        this.telefon = paCislo;
    }
    
    public String dajLokalitu() { 
        return this.mesto; //klasická get metóda - sprístupnenie hodnoty atribútu
    }
    
    public long dajTelefon() {
        //String sNulou = "0" + this.telefon;
        //return sNulou;  //nápodobne, ďalšia get metóda, s úpravou úvodnej nuly, číslo už nie je int ale reťazec
        return this.telefon;
    }
    
    public String toString() { //metóda pre výpis, spájanie reťazcov
        String text = " " + this.mesto + ", kontakt: " + this.dajTelefon() ;
        return text;  
    }
    
    public void vypis() { 
        System.out.print(this.toString());
    }
}
