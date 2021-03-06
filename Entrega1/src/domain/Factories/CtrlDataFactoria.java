/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Factories;

import Data.CtrlOrdinador;
import Data.CtrlOrdinadorDB;
import Data.CtrlProjector;
import Data.CtrlProjectorDB;
import Data.CtrlRecurs;
import Data.CtrlRecursDB;
import Data.CtrlReservaAmbNotificacio;
import Data.CtrlReservaAmbNotificacioDB;
import Data.CtrlReservaSenseNotificacio;
import Data.CtrlReservaSenseNotificacioDB;
import Data.CtrlSala;
import Data.CtrlSalaDB;
import Data.CtrlUsuari;
import Data.CtrlUsuariDB;
import Data.Sessio;
import domain.Adapters.GestioMissatgeAdapter;
import domain.Adapters.IGestioMissatgeAdapter;
import domain.Controladors.ControladorCrearReservaAmbNotificacio;
/**
 *
 * @author carlos
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = null;

    public static CtrlDataFactoria getInstance() {
        if (ourInstance == null)
        {
            ourInstance = new CtrlDataFactoria();
        }
        return ourInstance;
    }

    public CtrlDataFactoria(){}

    private final CtrlUsuari ctrlUsuari = new CtrlUsuariDB();
    
    public CtrlUsuari getCtrlUsuari(){ return ctrlUsuari; }
    
    private final CtrlRecurs ctrlRecurs = new CtrlRecursDB();
    
    public CtrlRecurs getCtrlRecurs(){ return ctrlRecurs; }
    
    private final CtrlOrdinador ctrlOrdinador = new CtrlOrdinadorDB();
    
    public CtrlOrdinador getCtrlOrdinador(){ return ctrlOrdinador; }
    
    private final CtrlReservaAmbNotificacio ctrlReservaAmbNotificacio = new CtrlReservaAmbNotificacioDB();
    
    public CtrlReservaAmbNotificacio getCtrlReservaAmbNotificacio() { return ctrlReservaAmbNotificacio; }
    
    private final CtrlReservaSenseNotificacio ctrlReservaSenseNotificacio = new CtrlReservaSenseNotificacioDB();
    
    public CtrlReservaSenseNotificacio getCtrlReservaSenseNotificacio() { return ctrlReservaSenseNotificacio; }
    
    private final CtrlSala ctrlSala = new CtrlSalaDB();
    
    public CtrlSala getCtrlSala() { return ctrlSala; }
 
    private final CtrlProjector ctrlProjector = new CtrlProjectorDB();
    
    public CtrlProjector getCtrlProjector() { return ctrlProjector; }
    
    private final ControladorCrearReservaAmbNotificacio ctrlRan = new ControladorCrearReservaAmbNotificacio();
    
    public ControladorCrearReservaAmbNotificacio getControladorCrearReservaAmbNotificacio() { return ctrlRan; }
    
}
