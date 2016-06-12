/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Data.CtrlInicialState;
import Data.CtrlOrdinador;
import Data.CtrlProjector;
import Data.CtrlRecurs;
import Data.CtrlReservaAmbNotificacio;
import Data.CtrlReservaSenseNotificacio;
import Data.CtrlSala;
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
public class main4 {
   
    public static void main(String[] args){
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlInicialState inicial = new CtrlInicialState(factory);
        inicial.inicialitzaUsuaris();
        System.out.println("Usuaris inicialitzats");
        inicial.inicialitzaRecursos();
        System.out.println("Recursos inicialitzats");
        inicial.inicialitzaReservesSenseNotificacio();
        System.out.println("Reserves Sense Notiifcacio inicialitzades");
        inicial.inicialitzaReservesAmbNotificacio();
        System.out.println("Reserves Amb Notiifcacio inicialitzades");
        
        //CAS US 3.1
        ControladorCrearReservaAmbNotificacio c1 = new ControladorCrearReservaAmbNotificacio();
        Date d = new Date(2016,7,10);
        Date d2 = new Date(2016,8,10);
        ArrayList<Info> info = new ArrayList<>();
        info = c1.obteRecursosDisponibles(d2, 19, 23);
        for (int i = 0; i < info.size(); ++i) {
            System.out.println(info.get(i).getNom());
        }
        //CAS US 3.2
        c1.crearReservaAmbNotificacio("Sala d'actes Pompeu", "marc1161", "fdkflfk");
        //CAS US 3.3 
        CtrlSala cs = factory.getCtrlSala();
        CtrlUsuari cu = factory.getCtrlUsuari();
        Sala s1 =  cs.get("Sala d'actes Pompeu");
        ArrayList<Usuari> usuaris = c1.obteUsuarisAAssignar("Sala d'actes Pompeu", d2, 19);
        System.out.println("size notificacions " + (cu.get("marc1161")).getNotificacions().size());
        ArrayList<String> noms = new ArrayList<String>();
        for (int i = 0; i < usuaris.size(); ++i) {
            noms.add(usuaris.get(i).getUsername());
        }
        System.out.println(noms.size());
        //CAS US 3.4      
        c1.assignarUsuarisAReserva(noms);
    }
}
