/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zahradneMasiny;

import bazar.INaPredaj;
import majitel.Osoba;

/**
 *
 * @author Tomáš
 */
public class Stroj implements INaPredaj {
    private Osoba majitel;
    private String typMasiny;
    private int prikonVKw;
    private double objem;
    private String znacka;
    private int rokVyroby;
    private int dobaPouzivaniaVMesiacoch;
    private int cena;
    private String komentar;

    public Stroj(Osoba majitel, String typMasiny, int prikonVKw, double objem, String znacka, int rokVyroby, int dobaPouzivaniaVMesiacoch, int cena, String komentar) {
        this.majitel = majitel;
        this.prikonVKw = prikonVKw;
        this.objem = objem;
        this.znacka = znacka;
        this.rokVyroby = rokVyroby;
        this.dobaPouzivaniaVMesiacoch = dobaPouzivaniaVMesiacoch;
        this.cena = cena;
        this.komentar = komentar;
        this.typMasiny = typMasiny;
    }
    
    public String toString() {
        String text = "Záhradná mašina " + this.typMasiny + " " + this.znacka + ", s prikonom: " + this.prikonVKw + " KW, objem motora " + this.objem + ", vyrobené v roku " + this.rokVyroby; 
        String text2 = "používané starým majiteľom " + this.dobaPouzivaniaVMesiacoch + " mesiacov, ponúka: " + this.majitel.toString() + " za cenu " + this.cena + "€\n";
        String komentar1 = "Komentár použivateľa: " + this.komentar;
        return text + text2 + komentar1;
    }
    
    public void vypis() {
        System.out.println(this.toString());
    }

    public Osoba getMajitela() {
        return this.majitel;
    }

    public int getPrikonVKw() {
        return this.prikonVKw;
    }

    public double getObjem() {
        return this.objem;
    }

    public String getZnacka() {
        return this.znacka;
    }

    public int getRokVyroby() {
        return this.rokVyroby;
    }

    public int getDobaPouzivaniaVMesiacoch() {
        return this.dobaPouzivaniaVMesiacoch;
    }

    public int getCena() {
        return this.cena;
    }

    public String getKomentar() {
        return this.komentar;
    }

    public String getTypMasiny() {
        return this.typMasiny;
    }
    
    
    
}
