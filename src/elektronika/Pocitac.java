/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elektronika;

import majitel.Osoba;

/**
 *
 * @author Tomáš
 */
public class Pocitac extends ElektronickyPristroj {
    private int frekvenciaProcesora;
    private double ram;
    private double internaPamat;
    private int ulhopriecka;

    public Pocitac(Osoba majitel, String typ, String znacka, int rokVyroby, int dobaPouzivaniaVMesiacoch, int cena, int frekvenciaProcesora, double ram, double internaPamat, int ulhopriecka, String komentar) {
        super(majitel, typ, znacka, rokVyroby, dobaPouzivaniaVMesiacoch, cena, komentar);
        this.frekvenciaProcesora = frekvenciaProcesora;
        this.ram = ram;
        this.internaPamat = internaPamat;
        this.ulhopriecka = ulhopriecka;
    }

    @Override
    public String toString() {
        return super.toString() + "Frekvencie procesora: " + this.frekvenciaProcesora + "Hz, RAM: " + this.ram + "GB, interná pamäť: " + this.internaPamat + "GB, uhlopriečka displeja: " + this.ulhopriecka + "cm \n";
    }
    
    @Override
    public void vypis() {
        System.out.println(this.toString());
    }
    
    public int getFrekvenciaProcesora() {
        return this.frekvenciaProcesora;
    }

    public double getRam() {
        return this.ram;
    }

    public double getInternaPamat() {
        return this.internaPamat;
    }

    public int getUhlopriecka() {
        return this.ulhopriecka;
    }

}
