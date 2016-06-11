/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Controladors;

import Data.CtrlReservaAmbNotificacio;
import Data.CtrlUsuari;
import Data.CtrlRecurs;
import Data.CtrlReservaSenseNotificacio;
import domain.Factories.CtrlDataFactoria;
import domain.Model.Recurs;
import java.util.Date;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.ReservaSenseNotificacio;
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
            
    public ArrayList<Usuari> obteUsuarisAAssignar(Recurs nomR, Date d, int hi){
       CtrlDataFactoria factory = new CtrlDataFactoria();
       CtrlUsuari cu = factory.getCtrlUsuari();
       ArrayList<Usuari> u = cu.getAll();
       CtrlReservaAmbNotificacio cr = factory.getCtrlReservaAmbNotificacio();
       CtrlReservaSenseNotificacio cr2 = factory.getCtrlReservaSenseNotificacio();
       ReservaAmbNotificacio r = cr.get(nomR,d,hi);
       ReservaSenseNotificacio r2 = cr2.get(nomR,d,hi);
       if (r == null && r2 == null) System.out.println("NoExisteixLaReserva");
       else if (r == null && r != null) System.out.println("NoReservaAmbNotificacio");
       ArrayList<Usuari> result = r.getPossiblesUsuaris(u);
       if (result.isEmpty()) System.out.println("noHiHaProuUsuaris");
       this.nom = nomR.getNom();
       this.data = d;
       this.horai = hi;
       return result;
    }
    
    public void afegirUsuarisReserva (ArrayList<String> usuaris){
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlRecurs CtrlR = factory.getCtrlRecurs();
        Recurs r = CtrlR.get(this.nom);
        CtrlReservaAmbNotificacio cr = factory.getCtrlReservaAmbNotificacio();
        ReservaAmbNotificacio rm = cr.get(r, this.data, this.horai);
        CtrlUsuari cu = factory.getCtrlUsuari();
        ArrayList<Usuari> u = new ArrayList<>();
        for (int i = 0; i < usuaris.size(); i++) u.add(cu.get(usuaris.get(i)));
        rm.afegirUsuaris(u);
    }
}
