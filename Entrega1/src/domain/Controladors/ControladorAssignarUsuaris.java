/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Controladors;

import Data.CtrlReservaAmbNotificacio;
import Data.CtrlReservaSenseNotificacio;
import Data.CtrlUsuari;
import domain.DBInterfaces.CtrlDataFactoria;
import java.util.Date;
import domain.Model.InfoUsuari;
import domain.Model.Usuari;
import java.util.List;
/**
 *
 * @author Víctor
 */
public class ControladorAssignarUsuaris {

    public ControladorAssignarUsuaris() {
    }
    
    
    public InfoUsuari obteUsuarisAAssignar(String nomR, Date d, int hi){
       CtrlDataFactoria factory = new CtrlDataFactoria();
       CtrlUsuari cu = factory.getCtrlUsuari();
       List<Usuari> u = cu.getAll();
       CtrlReservaAmbNotificacio ra = factory.getCtrlReservaAmbNotificacio();
       CtrlReservaSenseNotificacio rs = factory.getCtrlReservaSenseNotificacio();
       return null;
    }
}
