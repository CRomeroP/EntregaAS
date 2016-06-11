/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Controladors;

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
    
    public ControladorCrearReservaAmbNotificacio() {
        
    }
    
    public ArrayList<Info> obteRecursosDisponibles(Date d, int horain, int horafi) {
        ControladorConsultaRecursosDisponiblesPerData cd = new ControladorConsultaRecursosDisponiblesPerData();
        ArrayList<Info> recursos = cd.obteRecursosDisponiblesPerData(d, horain, horafi);
        this.data = data;
        this.hi = horain;
        this.hf = horafi;
        return recursos;
    }
    
    public ArrayList<Usuari> obteUsuarisAAssignar (Recurs nomR, Date d, int hi) {
        ControladorAssignarUsuaris cau = new ControladorAssignarUsuaris();
        ArrayList<Usuari> usuaris = cau.obteUsuarisAAssignar(nomR, d, hi);
        return usuaris;
    }
    
    public void assignarUsuarisAReserva (ArrayList<String> usuaris) {
        ControladorAssignarUsuaris cau = new ControladorAssignarUsuaris();
        cau.afegirUsuarisReserva(usuaris);
    }
    
    public void crearReservaAmbNotificacio (String nomR, String username, String comentari) {
        CtrlDataFactoria cf = new CtrlDataFactoria();
        CtrlUsuari cu = cf.getCtrlUsuari();
        Usuari usu = cu.get(username);
        Recurs s = new Recurs(nomR,Types.Ordinador);
        boolean b = usu.tensSalaReservada(data, hi, hf);
        if (b) {
            System.out.println("SalaSolapada");
        }
        else {
            Recurs rec = new Recurs(nomR,Types.Ordinador);
            ReservaAmbNotificacio resamb = new ReservaAmbNotificacio(data, hi, hi, comentari, usu, rec);
            CtrlReservaAmbNotificacio CtrlR = cf.getCtrlReservaAmbNotificacio();
            CtrlR.insert(resamb);
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