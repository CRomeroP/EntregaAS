/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Controladors;

import Data.CtrlReservaAmbNotificacio;
import Data.CtrlUsuari;
import domain.DBInterfaces.CtrlDataFactoria;
import java.util.Date;
import domain.Model.InfoUsuari;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Víctor
 */
public class ControladorAssignarUsuaris {

    public ControladorAssignarUsuaris() {
    }
    
    private String nom;
    
    private Date data;
    
    private int horai;
            
    public ArrayList<InfoUsuari> obteUsuarisAAssignar(String nomR, Date d, int hi){
       CtrlDataFactoria factory = new CtrlDataFactoria();
       CtrlUsuari cu = factory.getCtrlUsuari();
       ArrayList<Usuari> u = cu.getAll();
       CtrlReservaAmbNotificacio cr = factory.getCtrlReservaAmbNotificacio();
       ReservaAmbNotificacio r = cr.get(nomR,d,hi);
       ArrayList<InfoUsuari> result = r.getPossiblesUsuaris(u);
       this.nom = nomR;
       this.data = d;
       this.horai = hi;
       return result;
    }
}
