/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazar;

import elektronika.ElektronickyPristroj;
import elektronika.Elektronika;
import elektronika.Mobil;
import elektronika.Pocitac;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import majitel.Osoba;
import naKolesach.Auto;
import naKolesach.Autobus;
import naKolesach.Kamion;
import naKolesach.Motorka;
import naKolesach.Vozidlo;
import zahradneMasiny.Kosacka;
import zahradneMasiny.Krovinorez;
import zahradneMasiny.MotorovaPila;
import zahradneMasiny.Stroj;

/**
 *
 * @author Tomáš
 */
public class Inzerat {
    private ArrayList<INaPredaj> databaza;

    public Inzerat() {
        this.databaza = new ArrayList<INaPredaj>();
    }
    
    public int dajPocet() {
        return this.databaza.size();
    }
    public INaPredaj poskytniInzerat (int index) {
        try {
            return this.databaza.get(index);
        } catch (NullPointerException ex) {
            throw ex;
        }
    }
    public boolean pridajInzerat(INaPredaj inzerat) {
        return this.databaza.add(inzerat);
    }
    
    public boolean odoberInzerat(int index) {
        this.databaza.remove(index);
        return true;
    }
    
    @Override
    public String toString() {
        String retazec = "Vypis: \n";
        for (INaPredaj aktualny : this.databaza) {
            retazec = retazec + aktualny.toString() + "\n";
        }
        return retazec;
    }
    /**
     * Metóda zapisuje databázu do binárneho súboru, jednotlivo, po prvkoch arraylistu.
     * V prípade problémov vyhodí výnimku pomocou JOptionPane
     *
     * @throws java.io.IOException
    */
    public void zapisDatabazu() throws IOException {
        boolean koniec = false;
        DataOutputStream zapisovac = null;
        try {
            File subor = new File ("databaza.bin");
            FileOutputStream zapis = new FileOutputStream(subor);
            zapisovac = new DataOutputStream(zapis);
            for (INaPredaj aktualny: this.databaza) {
                if (aktualny instanceof Vozidlo) {
                    if (aktualny instanceof Auto) {
                        zapisovac.writeUTF("Auto");
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Vozidlo)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getTypVozdila());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getZnacka());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getModel());
                        zapisovac.writeInt(((Vozidlo)aktualny).getVykon());
                        zapisovac.writeInt(((Vozidlo)aktualny).getRokVyroby());
                        zapisovac.writeDouble(((Vozidlo)aktualny).getObsahMotora());
                        zapisovac.writeInt(((Vozidlo)aktualny).getNajazdeneKm());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKaroseria());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getFarba());
                        zapisovac.writeInt(((Vozidlo)aktualny).getCena());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getPalivo());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKomentar());
                    } else if (aktualny instanceof Kamion) {
                        zapisovac.writeUTF("Kamion");
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Vozidlo)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getTypVozdila());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getZnacka());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getModel());
                        zapisovac.writeInt(((Vozidlo)aktualny).getVykon());
                        zapisovac.writeInt(((Vozidlo)aktualny).getRokVyroby());
                        zapisovac.writeDouble(((Vozidlo)aktualny).getObsahMotora());
                        zapisovac.writeInt(((Vozidlo)aktualny).getNajazdeneKm());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKaroseria());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getFarba());
                        zapisovac.writeInt(((Vozidlo)aktualny).getCena());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getPalivo());
                        zapisovac.writeInt(((Kamion)((Vozidlo)aktualny)).getMaximalnaNosnost());
                        zapisovac.writeUTF(((Kamion)((Vozidlo)aktualny)).getEmisnaTrieda());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKomentar());
                    } else if (aktualny instanceof Autobus) {
                        zapisovac.writeUTF("Autobus");
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Vozidlo)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getTypVozdila());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getZnacka());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getModel());
                        zapisovac.writeInt(((Vozidlo)aktualny).getVykon());
                        zapisovac.writeInt(((Vozidlo)aktualny).getRokVyroby());
                        zapisovac.writeDouble(((Vozidlo)aktualny).getObsahMotora());
                        zapisovac.writeInt(((Vozidlo)aktualny).getNajazdeneKm());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKaroseria());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getFarba());
                        zapisovac.writeInt(((Vozidlo)aktualny).getCena());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getPalivo());
                        zapisovac.writeInt(((Autobus)((Vozidlo)aktualny)).getPocetMiestNaSedenie());
                        zapisovac.writeUTF(((Autobus)((Vozidlo)aktualny)).getEmisnaTrieda());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKomentar());
                    } else if (aktualny instanceof Motorka) {
                        zapisovac.writeUTF("Motorka");
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Vozidlo)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Vozidlo)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getTypVozdila());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getZnacka());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getModel());
                        zapisovac.writeInt(((Vozidlo)aktualny).getVykon());
                        zapisovac.writeInt(((Vozidlo)aktualny).getRokVyroby());
                        zapisovac.writeDouble(((Vozidlo)aktualny).getObsahMotora());
                        zapisovac.writeInt(((Vozidlo)aktualny).getNajazdeneKm());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKaroseria());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getFarba());
                        zapisovac.writeInt(((Vozidlo)aktualny).getCena());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getPalivo());
                        zapisovac.writeUTF(((Vozidlo)aktualny).getKomentar());
                    }  
                } else if (aktualny instanceof Stroj) {
                    if (aktualny instanceof Krovinorez) {
                        zapisovac.writeUTF("Krovinorez");
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Stroj)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Stroj)aktualny).getTypMasiny());
                        zapisovac.writeInt(((Stroj)aktualny).getPrikonVKw());
                        zapisovac.writeDouble(((Stroj)aktualny).getObjem());
                        zapisovac.writeUTF(((Stroj)aktualny).getZnacka());
                        zapisovac.writeInt(((Stroj)aktualny).getRokVyroby());
                        zapisovac.writeInt(((Stroj)aktualny).getDobaPouzivaniaVMesiacoch());
                        zapisovac.writeInt(((Stroj)aktualny).getCena());
                        zapisovac.writeUTF(((Stroj)aktualny).getKomentar());
                    } else if (aktualny instanceof Kosacka) {
                        zapisovac.writeUTF("Kosacka");
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Stroj)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Stroj)aktualny).getTypMasiny());
                        zapisovac.writeInt(((Stroj)aktualny).getPrikonVKw());
                        zapisovac.writeDouble(((Stroj)aktualny).getObjem());
                        zapisovac.writeUTF(((Stroj)aktualny).getZnacka());
                        zapisovac.writeInt(((Stroj)aktualny).getRokVyroby());
                        zapisovac.writeInt(((Stroj)aktualny).getDobaPouzivaniaVMesiacoch());
                        zapisovac.writeInt(((Stroj)aktualny).getCena());
                        zapisovac.writeUTF(((Stroj)aktualny).getKomentar());
                    } else if (aktualny instanceof MotorovaPila) {
                        zapisovac.writeUTF("MotorovaPila");
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((Stroj)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((Stroj)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((Stroj)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((Stroj)aktualny).getTypMasiny());
                        zapisovac.writeInt(((Stroj)aktualny).getPrikonVKw());
                        zapisovac.writeDouble(((Stroj)aktualny).getObjem());
                        zapisovac.writeUTF(((Stroj)aktualny).getZnacka());
                        zapisovac.writeInt(((Stroj)aktualny).getRokVyroby());
                        zapisovac.writeInt(((Stroj)aktualny).getDobaPouzivaniaVMesiacoch());
                        zapisovac.writeInt(((Stroj)aktualny).getCena());
                        zapisovac.writeUTF(((Stroj)aktualny).getKomentar());
                    }
                } else if (aktualny instanceof ElektronickyPristroj) {
                    if (aktualny instanceof Pocitac) {
                        zapisovac.writeUTF("Pocitac");
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((ElektronickyPristroj)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getTyp());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getZnacka());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getRokVyroby());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getDobaPouzivaniaVMesiacoch());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getCena());
                        zapisovac.writeInt(((Pocitac)((ElektronickyPristroj)aktualny)).getFrekvenciaProcesora());
                        zapisovac.writeDouble(((Pocitac)((ElektronickyPristroj)aktualny)).getRam());
                        zapisovac.writeDouble(((Pocitac)((ElektronickyPristroj)aktualny)).getInternaPamat());
                        zapisovac.writeInt(((Pocitac)((ElektronickyPristroj)aktualny)).getUhlopriecka());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getKomentar());
                    } else if (aktualny instanceof Mobil) {
                        zapisovac.writeUTF("Mobil");
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((ElektronickyPristroj)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getTyp());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getZnacka());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getRokVyroby());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getDobaPouzivaniaVMesiacoch());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getCena());
                        zapisovac.writeInt(((Mobil)((ElektronickyPristroj)aktualny)).getFrekvenciaProcesora());
                        zapisovac.writeDouble(((Mobil)((ElektronickyPristroj)aktualny)).getRam());
                        zapisovac.writeDouble(((Mobil)((ElektronickyPristroj)aktualny)).getInternaPamat());
                        zapisovac.writeInt(((Mobil)((ElektronickyPristroj)aktualny)).getVydrzBaterie());
                        zapisovac.writeInt(((Mobil)((ElektronickyPristroj)aktualny)).getRozliseniefotaku());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getKomentar());
                    } else if (aktualny instanceof Elektronika) {
                        zapisovac.writeUTF("Elektronika");
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getMeno());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getPriezvisko());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getDen());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getMesiac());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getMajitela().getDatumNarodenia().getRok());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getMajitela().getMesto().dajLokalitu());
                        zapisovac.writeLong(((ElektronickyPristroj)aktualny).getMajitela().getMesto().dajTelefon());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getTyp());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getZnacka());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getRokVyroby());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getDobaPouzivaniaVMesiacoch());
                        zapisovac.writeInt(((ElektronickyPristroj)aktualny).getCena());
                        zapisovac.writeUTF(((ElektronickyPristroj)aktualny).getKomentar());
                    }
                }   
            } 
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Chyba! " + ex.getMessage());
        } finally {
            if (zapisovac != null) {
                try {
                    zapisovac.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Chyba! " + ex.getMessage());
                }
            }
        }
    }
    /**
     * Metóda nacita databazu zo suboru postupne, tak ako sa ukladá, tak sa aj cíta.
     * Pri chybe sa výnimka rethrowuje do nadradenej triedy
     * @return boolean
     * @throws IOException 
     */
    
    
    public boolean nacitajDatabazu() throws IOException {
        boolean koniecSuboru = false;
        DataInputStream citac = null;
        try {
            File subor = new File ("databaza.bin");
            FileInputStream citaj = new FileInputStream(subor);
            citac = new DataInputStream(citaj);
            do {
                try {
                    String typ = citac.readUTF();
                    if (typ.equals("Auto")) {
                        this.pridajInzerat(new Auto (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));                                            
                    } else if (typ.equals("Motorka")) {
                        this.pridajInzerat(new Motorka (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));                                            
                    } else if (typ.equals("Kamion")) {
                        this.pridajInzerat(new Kamion (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));
                    } else if (typ.equals("Autobus")) {
                        this.pridajInzerat(new Autobus (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readInt(), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readInt(), citac.readUTF(), citac.readUTF()));
                    } else if (typ.equals("Kosacka")) {
                        this.pridajInzerat(new Kosacka (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readInt(), citac.readDouble(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (typ.equals("Krovinorez")) {
                        this.pridajInzerat(new Krovinorez (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readInt(), citac.readDouble(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (typ.equals("MotorovaPila")) {
                        this.pridajInzerat(new MotorovaPila (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readInt(), citac.readDouble(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (typ.equals("Elektronika")) {
                        this.pridajInzerat(new Elektronika (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    } else if (typ.equals("Pocitac")) {
                        this.pridajInzerat(new Pocitac (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readDouble(), citac.readInt(), citac.readUTF()));
                    } else if (typ.equals("Mobil")) {
                        this.pridajInzerat(new Mobil (new Osoba (citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readUTF(), citac.readLong()), citac.readUTF(), citac.readUTF(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readInt(), citac.readDouble(), citac.readDouble(), citac.readInt(), citac.readInt(), citac.readUTF()));
                    }
                } catch (EOFException ex) {
                    koniecSuboru = true;
                }
            } while (!koniecSuboru);
        } catch (FileNotFoundException ex) {
            throw ex;
        } finally {
            if (citac != null) {
                try {
                    citac.close();
                } catch (FileNotFoundException ex) {
                    throw ex;
                }
            }
        }
        return true;
    }
}
