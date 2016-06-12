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
public class ServeiNoDisponible extends RuntimeException{

    public ServeiNoDisponible(String message) {
        super(message);
    }

}
