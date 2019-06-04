/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naKolesach;

import majitel.Osoba;

/**
 *
 * @author Tomáš
 */
public class Autobus extends Vozidlo {
    private String emisnaTrieda;
    private int pocetMiestNaSedenie;
    
    public Autobus(Osoba paOsoba, String typVozidla, String paZnacka, String paModel, int paVykon, int paRokVyroby, double paObsahMotora, int paNajazdeneKm, String paKaroseria, String paFarba, int paCena, String palivo, int pocetMiestNaSedenie, String emisnaTrieda, String paKomentar) {
        super(paOsoba, typVozidla, paZnacka, paModel, paVykon, paRokVyroby, paObsahMotora, paNajazdeneKm, paKaroseria, paFarba, paCena, palivo, paKomentar);
        this.pocetMiestNaSedenie = pocetMiestNaSedenie;
        this.emisnaTrieda = emisnaTrieda;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Pocet miest na sedenie: " + this.pocetMiestNaSedenie + ", emisná trieda: " + this.emisnaTrieda + "\n";
    }

    @Override
    public void vypis() {
        System.out.println(this.toString());
    }

    public String getEmisnaTrieda() {
        return this.emisnaTrieda;
    }

    public int getPocetMiestNaSedenie() {
        return this.pocetMiestNaSedenie;
    }
      
}
