/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Data.CtrlOrdinador;
import Data.CtrlRecurs;
import Data.CtrlReservaAmbNotificacio;
import Data.CtrlReservaSenseNotificacio;
import Data.CtrlUsuari;
import domain.Controladors.ControladorAssignarUsuaris;
import domain.Controladors.ControladorConsultaRecursosDisponiblesPerData;
import domain.Controladors.ControladorCrearReservaAmbNotificacio;
import domain.Factories.CtrlDataFactoria;
import domain.Model.Info;
import domain.Model.Ordinador;
import domain.Model.Projector;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.ReservaSenseNotificacio;
import domain.Model.Sala;
import domain.Model.Types;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public class main3 {
   
    public static void main(String[] args){
        //FUNCIO 1 obtinc recursos
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlOrdinador CtrlO = factory.getCtrlOrdinador();
        CtrlReservaSenseNotificacio CtrlRSN = factory.getCtrlReservaSenseNotificacio();
        CtrlUsuari CtrlU = factory.getCtrlUsuari();
        Date d = new Date(2016,6,8);
        int hi = 7;
        int hf = 9;
        Ordinador o = new Ordinador("ord", "sdmf","msd");
        Ordinador ord = new Ordinador("proj","radsf","lhdsaf");
        Usuari u = new Usuari("CR","dasfa","Carlos");
        ReservaSenseNotificacio rsn = new ReservaSenseNotificacio(d,hi,hf,"",u,o);
        CtrlO.insert(o);
        CtrlO.insert(ord);
        CtrlU.insert(u);
        CtrlRSN.insert(rsn);
        u = CtrlU.get("CR");
        System.out.println(u.getNom());
        ControladorConsultaRecursosDisponiblesPerData ctrlCR = new ControladorConsultaRecursosDisponiblesPerData();
        ArrayList<Info> result = ctrlCR.obteRecursosDisponiblesPerData(d, hi, hf);
        for (int i = 0; i < result.size(); ++i){
            System.out.println(result.get(i).getNom());
        }
        //RESULT son els recursos disponibles
        
        //FUNCIO2 reservo un recurs
        CtrlRecurs CtrlR = factory.getCtrlRecurs();
        Info info = result.get(0);
        String nomrecurs = info.getNom();
        Ordinador aRes = new Ordinador();
        if (CtrlR.get(nomrecurs).getType() == Types.Ordinador) {
            System.out.println("entrooooo");
            aRes.setNom(nomrecurs);
            CtrlO.insert(aRes);
        }
        /*else if (CtrlR.get(nomrecurs).getType() == Types.Sala) {
            Sala aRes = new Sala();
            aRes.setNom(nomrecurs);
            CtrlS.insert(aRes);
        }
        else if (CtrlR.get(nomrecurs).getType() == Types.Projector) {
            Projector aRes = new Projector();
            aRes.setNom(nomrecurs);
            CtrlP.insert(aRes);
        }*/
        Usuari u4 = new Usuari();
        u4.setUsername("marc");
        CtrlU.insert(u4);
        ControladorCrearReservaAmbNotificacio c2 = new ControladorCrearReservaAmbNotificacio();
        c2.crearReservaAmbNotificacio(nomrecurs, "marc", "victor gay");
        //es reserva un recurs
        
        
        //FUNCIO 3 obtinc usuaris assignar
        Usuari u2 = new Usuari();
        u2.setUsername("ramon");
        CtrlU.insert(u2);
        Usuari u3 = new Usuari();
        u3.setUsername("paco");
        CtrlU.insert(u3);
        CtrlReservaAmbNotificacio CtrlN = factory.getCtrlReservaAmbNotificacio();
        ReservaAmbNotificacio res = CtrlN.get(aRes, d, hi);
        Date d2 = new Date(2016,6,10);
        List<Usuari> llista = new ArrayList<Usuari>();
        llista.add(u2);
        res.setNotificacions(llista);
        ControladorAssignarUsuaris cu = new ControladorAssignarUsuaris();
        ArrayList<Usuari> usu = cu.obteUsuarisAAssignar(aRes, d2, 9);
        for (int i = 0; i < usu.size(); ++i){
            System.out.println(usu.get(i).getUsername());
        }
        //obtinc els candidats a ser assginats
        
        //FUNCIO 4 assigno usuaris
        Usuari u5 = new Usuari();
        u2.setUsername("manel");
        CtrlU.insert(u5);
        Usuari u6 = new Usuari();
        u3.setUsername("xavier");
        CtrlU.insert(u6);
        ArrayList<String> afegir = new ArrayList<>();
        afegir.add(u5.getUsername());
        afegir.add(u6.getUsername());
        cu.afegirUsuarisReserva(afegir);
        //assigno els usuaris a aquella reserva
    }
}
