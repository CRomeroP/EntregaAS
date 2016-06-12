/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Factories;

import Excepcions.ServeiNoDisponible;
import domain.Adapters.GestioMissatgeAdapter;
import domain.Adapters.IGestioMissatgeAdapter;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public class CtrlAdaptersFactoria {
    private static CtrlAdaptersFactoria instance;

    public static CtrlAdaptersFactoria getInstance() {
        if (instance == null) {
            instance = new CtrlAdaptersFactoria();
        }
        return instance;
    }

    public CtrlAdaptersFactoria() {}
       
    private final IGestioMissatgeAdapter IGestioMissatgeAdapter = new GestioMissatgeAdapter();
    
    public IGestioMissatgeAdapter getIGestioMissatgeAdapter() { 
        maybeFail();
        return IGestioMissatgeAdapter; 
    }
    
        /**
     * Per simular que un servei pot no estar disponible.
     */
    private void maybeFail() {
        int failChance = new Random().nextInt(10);
        if (failChance == 5) throw new ServeiNoDisponible("El servei no esta disponible");
    }
}
