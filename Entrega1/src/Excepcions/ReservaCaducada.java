/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcions;

/**
 *
 * @author Víctor
 */
public class ReservaCaducada extends RuntimeException{

    public ReservaCaducada(String message) {
        super(message);
    }
    
}
