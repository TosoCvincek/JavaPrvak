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
public class Auto extends Vozidlo {

    public Auto(Osoba paOsoba, String typVozidla, String paZnacka, String paModel, int paVykon, int paRokVyroby, double paObsahMotora, int paNajazdeneKm, String paKaroseria, String paFarba, int paCena, String palivo, String paKomentar) {
        super(paOsoba, typVozidla, paZnacka, paModel, paVykon, paRokVyroby, paObsahMotora, paNajazdeneKm, paKaroseria, paFarba, paCena, palivo, paKomentar);
    }
    
}
