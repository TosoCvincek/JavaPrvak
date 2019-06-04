/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elektronika;

import bazar.INaPredaj;
import majitel.Osoba;

/**
 *
 * @author Tomáš
 */
public class ElektronickyPristroj implements INaPredaj {
    private Osoba majitel;
    private String typ;
    private String znacka;
    private int rokVyroby;
    private int dobaPouzivaniaVMesiacoch;
    private int cena;
    private String komentar;

    public ElektronickyPristroj(Osoba majitel, String typ, String znacka, int rokVyroby, int dobaPouzivaniaVMesiacoch, int cena, String komentar) {
        this.majitel = majitel;
        this.typ = typ;
        this.znacka = znacka;
        this.rokVyroby = rokVyroby;
        this.dobaPouzivaniaVMesiacoch = dobaPouzivaniaVMesiacoch;
        this.cena = cena;
        this.komentar = komentar;
    }
    
    public String toString() {
        String text = this.typ + " " + this.znacka + ", vyrobené v roku " + this.rokVyroby; 
        String text2 = " používané starým majiteľom " + this.dobaPouzivaniaVMesiacoch + " mesiacov, ponúka: " + this.majitel.toString() + " za cenu " + this.cena + "€\n";
        String komentar1 = "Komentár použivateľa: " + this.komentar;
        return text + text2 + komentar1;
    }
    
    public void vypis() {
        System.out.println(this.toString());
    }

    public Osoba getMajitela() {
        return this.majitel;
    }

    public String getTyp() {
        return this.typ;
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

    
}
