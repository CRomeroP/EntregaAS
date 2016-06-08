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
import domain.Model.ReservaAmbNotificacio;
import domain.Model.Usuari;
import java.util.ArrayList;
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
            
    public ArrayList<Usuari> obteUsuarisAAssignar(String nomR, Date d, int hi){
       CtrlDataFactoria factory = new CtrlDataFactoria();
       CtrlUsuari cu = factory.getCtrlUsuari();
       ArrayList<Usuari> u = cu.getAll();
       CtrlReservaAmbNotificacio cr = factory.getCtrlReservaAmbNotificacio();
       ReservaAmbNotificacio r = cr.get(nomR,d,hi);
       ArrayList<Usuari> result = r.getPossiblesUsuaris(u);
       if (result.isEmpty());//activa[noHiHaUsuaris]
       this.nom = nomR;
       this.data = d;
       this.horai = hi;
       return result;
    }
    
    public void afegirUsuarisReserva (ArrayList<Usuari> usuaris){
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlReservaAmbNotificacio cr = factory.getCtrlReservaAmbNotificacio();
        ReservaAmbNotificacio rm = cr.get(this.nom, this.data, this.horai);
        CtrlUsuari cu = factory.getCtrlUsuari();
        ArrayList<Usuari> u = new ArrayList<>();
        for (int i = 0; i < usuaris.size(); i++) u.add(cu.get(usuaris.get(i).getUsername()));
        //rm.afegirUsuaris(u);
    }
}
