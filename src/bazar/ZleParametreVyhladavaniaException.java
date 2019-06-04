/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazar;

/**
 *
 * @author Tomáš
 */
public class ZleParametreVyhladavaniaException extends IllegalArgumentException {
    /**
     * Vyuziva konstruktor predka pomocou super
     * @param parametre 
     */
    public ZleParametreVyhladavaniaException (String parametre) {
        super ("Paramtetre: " + parametre + " nevyhovujú žiadnému inzerátu, je nám ľúto.");
    }
}
