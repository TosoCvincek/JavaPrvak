/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazaar;

/**
 *
 * @author Tomáš
 */
public class InvalidSearchParametersException extends IllegalArgumentException {
    /**
     * Vyuziva konstruktor predka pomocou super
     * @param parameters 
     */
    public InvalidSearchParametersException (String parameters) {
        super ("Parameters: " + parameters + " do not match any listing, we are sorry.");
    }
}
