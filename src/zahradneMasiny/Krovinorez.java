/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zahradneMasiny;

import majitel.Osoba;

/**
 *
 * @author Tomáš
 */
public class Krovinorez extends Stroj {
    
    public Krovinorez(Osoba majitel, String typMasiny, int prikonVKw, double objem, String znacka, int rokVyroby, int dobaPouzivaniaVMesiacoch, int cena, String komentar) {
        super(majitel, typMasiny, prikonVKw, objem, znacka, rokVyroby, dobaPouzivaniaVMesiacoch, cena, komentar);
    }
    
    
}
