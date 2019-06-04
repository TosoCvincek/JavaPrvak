/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naKolesach;

import bazar.INaPredaj;
import majitel.Osoba;

/**
 *
 * @author Tomáš
 */
/**
 * Trieda Auto ohsahuje atribúty, ktoré sú parametrom auta, ktoré bude neskôr inzerátom. 
 * Niektoré sú primitívnych tipov, niektoré typu String a atribút majitel je typu Osoba.
 * Majitel je vkladaný asociáciou, pretože aj jedna osoba môže mať viac aut.
 * @author Tomáš Cvinček
 * @version 2.0
 */
public class Vozidlo implements INaPredaj {
    private Osoba majitel; //atribút majitel je typu Osoba, je prepojený asociáciou, pretože sa nevylučuje možnosť, že jedna osoba môže vlastniť viac áut.
    private String typVozdila;
    private String znacka;
    private String model;
    private int vykon;
    private int rokVyroby;
    private double obsahMotora;
    private int najazdeneKm;
    private String karoseria;
    private String farba;
    private int cena;
    private String komentar;
    private String palivo;
     /**
     * V konštruktore sa vytvorí inštancia auto, ktorá musí mať vopred definované vlastnosti a majiteľa, preto parametrami konšturktora sú všetky paramatre vozidla.
     * @param paOsoba majiteľ vozidla typu Osoba
     * @param paZnacka značka auta
     * @param paModel model auta
     * @param paVykon výkon motora v KW
     * @param paRokVyroby rok, kedy bolo auto vyrobené
     * @param paObsahMotora obsah motora v metroch kubických 
     * @param paNajazdeneKm doposiaľ odjazdených km na danom aute 
     * @param paKaroseria karoséria vozidla
     * @param paFarba farba vozidla
     * @param paCena cena vozidla v €
     * @param paKomentar dodotočný komentár autora
     */
    public Vozidlo(Osoba paOsoba, String typVozidla, String paZnacka, String paModel, int paVykon, int paRokVyroby, double paObsahMotora, int paNajazdeneKm, String paKaroseria, String paFarba, int paCena, String palivo, String paKomentar) {
        this.majitel = paOsoba;
        this.znacka = paZnacka;
        this.model = paModel;
        this.vykon = paVykon;
        this.rokVyroby = paRokVyroby;
        this.najazdeneKm = paNajazdeneKm;
        this.karoseria = paKaroseria;
        this.farba = paFarba;
        this.obsahMotora = paObsahMotora;
        this.cena = paCena;
        this.komentar = paKomentar;
        this.typVozdila = typVozidla;
        this.palivo = palivo;
                
    }
    
    /**
     *Metóda toString() je metóda, v ktorej sa snažím získať hodnoty atribútov v zmysluplnej vete, obsahuje spájanie reťazcov.
     *@return reťazec, ktorý hovorí o parametroch vozidla
     */
    public String toString() {
        String text = this.typVozdila + " " + this.znacka + " " + this.model + " " + this.karoseria + ", " + this.palivo + ", " + this.obsahMotora + ", " + this.farba + ", vyrobené v roku " + this.rokVyroby; 
        String text2 = " s výkonom " + this.vykon + "KW, ktoré má nabehané " + this.najazdeneKm + "km ponúka: " + this.majitel.toString() + " za cenu " + this.cena + "€\n";
        String komentar1 = "Komentár použivateľa: " + this.komentar;
        return text + text2 + komentar1;
    }
    
    /**
     *Metóda vypis() je metóda, v ktorej sa snažím vypísať metódu toString() na terminál.
     * 
     */
    public void vypis() {
        System.out.println(this.toString());
    }
    
    /**
     *Vrátí značku auta.
     *@return značka vozidla
     */
    public String getZnacka() {
        return this.znacka;
    }

    /**
     *Vrátí model auta.
     *@return model vozidla
     */
    public String getModel() {
        return this.model;
    }
    
    /**
     *Vrátí majiteľa vozidla
     *@return Objekt typu osoba 
     */
    public Osoba getMajitela() {
        return this.majitel;
    }
    
    /**
     *Vrátí výkon motora vozidla v KW.
     *@return výkon motora v KW
     */
    public int getVykon() {
        return this.vykon;
    }   
    
    /**
     *Vrátí rok výroby vozidla.
     *@return rok výroby auta 
     */
    public int getRokVyroby() {
        return this.rokVyroby;
    }
    
    /**
     *Vrátí doposiaľ najazdené km vozidla.
     *@return najazdené km auta
     */
    public int getNajazdeneKm() {
        return this.najazdeneKm;
    }
    
    /**
     *Vrátí typ karosérie vozidla.
     *@return karoséria auta
     */
    public String getKaroseria() {
        return this.karoseria;
    }
    
    /**
     *Vrátí farbu vozidla.
     *@return farba auta
     */
    public String getFarba() {
        return this.farba;
    }
    
    /**
     *Vrátí obsah motora vozidla v metroch kubických.
     *@return obsah motora auta
     */
    public double getObsahMotora() {
        return this.obsahMotora;
    }
    
    /**
     *Vrátí cenu vozidla v €.
     *@return cena vozidla
     */
    public int getCena() {
        return this.cena;
    }
    
    /**
     *Vrátí typ vozidla.
     *@return typ vozidla
     */
    public String getTypVozdila() {
        return this.typVozdila;
    }
    
    /**
     *Vrátí komentar pouzivatela.
     *@return komentar pouzivatela
     */
    public String getKomentar() {
        return this.komentar;
    }
    
    /**
     *Vrátí palivo vozidla. 
     *@return palivo vozidla
     */
    public String getPalivo() {
        return this.palivo;
    }
    
    
}

