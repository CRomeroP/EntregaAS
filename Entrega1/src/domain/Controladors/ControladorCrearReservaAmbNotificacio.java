/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Controladors;

import Data.CtrlRecurs;
import Data.CtrlReservaAmbNotificacio;
import Data.CtrlUsuari;
import domain.Factories.CtrlDataFactoria;
import domain.Model.Info;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.Types;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marc
 */
public class ControladorCrearReservaAmbNotificacio {
    
    private String nomR;
    private String username;
    private String comentari;
    private Date data;
    private int hi;
    private int hf;
    private ControladorAssignarUsuaris assignarUsuaris;
    
    public ControladorCrearReservaAmbNotificacio() {
        assignarUsuaris = new ControladorAssignarUsuaris();
        
    }
    
    public ArrayList<Info> obteRecursosDisponibles(Date d, int horain, int horafi) {
        ControladorConsultaRecursosDisponiblesPerData cd = new ControladorConsultaRecursosDisponiblesPerData();
        ArrayList<Info> recursos = cd.obteRecursosDisponiblesPerData(d, horain, horafi);
        this.data = d;
        this.hi = horain;
        this.hf = horafi;
        return recursos;
    }
    
    public ArrayList<Usuari> obteUsuarisAAssignar (String nomR, Date d, int hi) {
        CtrlDataFactoria factory = CtrlDataFactoria.getInstance();
        CtrlRecurs CtrlR = factory.getCtrlRecurs();
        Recurs r = CtrlR.get(nomR);
        return assignarUsuaris.obteUsuarisAAssignar(r, d, hi);
    }
    
    public void assignarUsuarisAReserva (ArrayList<String> usuaris) {
        assignarUsuaris.afegirUsuarisReserva(usuaris);
    }
    
    public void crearReservaAmbNotificacio (String nomR, String username, String comentari) {
        CtrlDataFactoria cf = CtrlDataFactoria.getInstance();
        CtrlUsuari cu = cf.getCtrlUsuari();
        Usuari usu = cu.get(username);
        CtrlRecurs CtrlR = cf.getCtrlRecurs();
        Recurs s = CtrlR.get(nomR);
        boolean b = usu.tensSalaReservada(data, hi, hf);
        if (b) {
            System.out.println("SalaSolapada");
        }
        else {
            ReservaAmbNotificacio resamb = new ReservaAmbNotificacio(data, hi, hf, comentari, usu, s);
            CtrlReservaAmbNotificacio CtrlA = cf.getCtrlReservaAmbNotificacio();
            CtrlA.insert(resamb);
            //GestioMissatge gm = cf.getGestioMissatge();
            String mail = usu.getEmail();
            /* ENVIAR MISSATGE */
            //gm.enviarDadesReserva();
            this.nomR = nomR;
            if (comentari != null) this.comentari = comentari;
            this.username = username;
        }
    }
    
}