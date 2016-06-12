/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Services;

import Excepcions.ServeiNoDisponible;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public class ServiceLocator {
     private static ServiceLocator instance = null;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    private ServiceLocator() {
    }

    private final Servei servei = new Servei();

    public Servei getServeiMissatgeria() {
        maybeFail();
        return servei;
    }   
    private void maybeFail() {
        int failChance = new Random().nextInt(3);
        if (failChance == 1) throw new ServeiNoDisponible("El servei no esta disponible");
    }
}
