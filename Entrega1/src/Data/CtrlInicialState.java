/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import domain.Factories.CtrlDataFactoria;
import domain.Model.Ordinador;
import domain.Model.Projector;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.ReservaSenseNotificacio;
import domain.Model.Sala;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marc
 */
public class CtrlInicialState {
    private CtrlDataFactoria factory;
    private Usuari u1;
    private Usuari u2;
    private Usuari u3;
    private Projector p1;
    private Projector p2;
    private Sala s1;
    private Sala s2;
    private Ordinador o1;
    private Ordinador o2;
    
    public CtrlInicialState (CtrlDataFactoria factory) {
        this.factory = factory;
    }
    
    public void inicialitzaUsuaris() {
        CtrlUsuari CtrlU = factory.getCtrlUsuari();
        //usuari 1
        u1 = new Usuari();
        u1.setEmail("marc116@hotmail.com");
        u1.setNom("marc");
        u1.setUsername("marc1161");
        CtrlU.insert(u1);
        //usuari 2
        u2 = new Usuari();
        u2.setEmail("victorggep@hotmail.com");
        u2.setNom("victor");
        u2.setUsername("victorggep");
        CtrlU.insert(u2);
        //usuari 3
        u3 = new Usuari();
        u3.setEmail("carlosromero@hotmail.com");
        u3.setNom("carlos");
        u3.setUsername("carlosromero");
        CtrlU.insert(u3);
        //usuari 4
        Usuari u4 = new Usuari();
        u4.setEmail("xavi.93@hotmail.com");
        u4.setNom("xavi");
        u4.setUsername("xavi.93");
        CtrlU.insert(u4);
        //usuari 5
        Usuari u5 = new Usuari();
        u5.setEmail("lidiafib@hotmail.com");
        u5.setNom("lidia");
        u5.setUsername("lidiafib");
        CtrlU.insert(u5);        
    }
    
    public void inicialitzaRecursos() {
        //Ordinadors
        CtrlOrdinador CtrlO = factory.getCtrlOrdinador();
        o1 = new Ordinador();
        o1.setMarca("HP");
        o1.setModel("222");
        o1.setNom("HP222");
        CtrlO.insert(o1);
        o2 = new Ordinador();
        o2.setMarca("ACER");
        o2.setModel("222");
        o2.setNom("ACER222");  
        CtrlO.insert(o2);
        //Projectors
        CtrlProjector CtrlP = factory.getCtrlProjector();
        p1 = new Projector();
        p1.setNom("BENQ333");
        p1.setResolucio("1920x1080");
        CtrlP.insert(p1);
        p2 = new Projector();
        p2.setNom("SAMSUNG333");  
        p2.setResolucio("1024x768");
        CtrlP.insert(p2);
        //Sales
        CtrlSala CtrlS = factory.getCtrlSala();
        s1 = new Sala();
        s1.setNom("Sala d'actes FIB");
        s1.setAforament(100);
        s1.setUbicacio("plaça fib");
        CtrlS.insert(s1);
        s2 = new Sala();
        s2.setNom("Sala d'actes Pompeu");
        s2.setAforament(300);
        s2.setUbicacio("Marina");
        CtrlS.insert(s2); 
    }
    
    public void inicialitzaReservesAmbNotificacio() {
        CtrlReservaAmbNotificacio CtrlAmb = factory.getCtrlReservaAmbNotificacio();
        //Reserva 1
        ReservaAmbNotificacio res1 = new ReservaAmbNotificacio();
        res1.setComentaris("Vull reservar l'ordinador HP222 i notificant");
        Date d = new Date(2016,7,10);
        res1.setData(d);
        res1.setHorainici(6);
        res1.setHorafi(15);
        res1.setRecurs(o1);
        res1.setUsuari(u1);
        CtrlAmb.insert(res1);
        //Reserva 2
        ReservaAmbNotificacio res2 = new ReservaAmbNotificacio();
        res2.setComentaris("Vull reservar la Sala d'actes FIB i notificant");
        Date d2 = new Date(2016,8,10);
        res2.setData(d2);
        res2.setHorainici(7);
        res2.setHorafi(15);
        res2.setRecurs(s1);
        res2.setUsuari(u2);
        ArrayList<Usuari> notificacions = new ArrayList<Usuari>();
        notificacions.add(u3);
        res2.setNotificacions((List)notificacions);
        CtrlAmb.insert(res2);
    }
    public void inicialitzaReservesSenseNotificacio() {
        CtrlReservaSenseNotificacio CtrlSense = factory.getCtrlReservaSenseNotificacio();
        //Reserva 1
        ReservaSenseNotificacio res3 = new ReservaSenseNotificacio();
        res3.setComentaris("Vull reservar l'ordinador HP222 sense notificar");
        Date d = new Date(2016,7,10);
        res3.setData(d);
        res3.setHorainici(10);
        res3.setHorafi(16);
        res3.setRecurs(o1);
        res3.setUsuari(u1);
        CtrlSense.insert(res3);
        //Reserva 2
        ReservaSenseNotificacio res4 = new ReservaSenseNotificacio();
        res4.setComentaris("Vull reservar la Sala d'actes FIB sense notificar");
        Date d2 = new Date(2016,8,10);
        res4.setData(d2);
        res4.setHorainici(8);
        res4.setHorafi(15);
        res4.setRecurs(s1);
        res4.setUsuari(u2);
        CtrlSense.insert(res4);
    }
}
