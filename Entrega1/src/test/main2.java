/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Data.CtrlRecurs;
import Data.CtrlReservaAmbNotificacio;
import Data.CtrlUsuari;
import domain.Controladors.ControladorAssignarUsuaris;
import domain.Controladors.ControladorConsultaRecursosDisponiblesPerData;
import domain.Factories.CtrlDataFactoria;
import domain.Model.Info;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.Types;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public class main2 {
   
    public static void main(String[] args){
        CtrlDataFactoria factory = new CtrlDataFactoria();
        
        CtrlUsuari CtrlU = factory.getCtrlUsuari();
        Usuari u = new Usuari();
        u.setUsername("marc");
        CtrlU.insert(u);
        Usuari u2 = new Usuari();
        u2.setUsername("ramon");
        CtrlU.insert(u2);
        Usuari u3 = new Usuari();
        u3.setUsername("paco");
        u3.setEmail("a@a.com");
        CtrlU.insert(u3);
        
        CtrlRecurs CtrlR = factory.getCtrlRecurs();
        Recurs r = new Recurs("rec", Types.Ordinador);
        CtrlR.insert(r);
        Date d = new Date(2016,6,10);
        int hi = 7;
        int hf = 9;
        CtrlReservaAmbNotificacio CtrlN = factory.getCtrlReservaAmbNotificacio();
        ReservaAmbNotificacio res = new ReservaAmbNotificacio();
        Date d2 = new Date(2016,6,10);
        res.setData(d2);
        res.setHorainici(7);
        res.setHorafi(9);
        res.setRecurs(r);
        res.setUsuari(u);
        CtrlN.insert(res);
        List<Usuari> llista = new ArrayList<Usuari>();
        llista.add(u2);
        res.setNotificacions(llista);
        List<Usuari> l = res.getNotificacions();
        ControladorAssignarUsuaris cu = new ControladorAssignarUsuaris();
        ArrayList<Usuari> usu = cu.obteUsuarisAAssignar(r, d2, 7);
        for (int i = 0; i < usu.size(); ++i){
            System.out.println(usu.get(i).getUsername());
        }
        ArrayList<String> us = new ArrayList<>();
        us.add("paco");
        cu.afegirUsuarisReserva(us);
    }
}
