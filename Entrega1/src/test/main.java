/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Data.CtrlOrdinador;
import Data.CtrlRecurs;
import Data.CtrlReservaSenseNotificacio;
import Data.CtrlUsuari;
import domain.Controladors.ControladorConsultaRecursosDisponiblesPerData;
import domain.DBInterfaces.CtrlDataFactoria;
import domain.Model.Info;
import domain.Model.Ordinador;
import domain.Model.Projector;
import domain.Model.Recurs;
import domain.Model.ReservaSenseNotificacio;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class main {
   
    public static void main(String[] args){
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
        ControladorConsultaRecursosDisponiblesPerData ctrlCR = new ControladorConsultaRecursosDisponiblesPerData();
        ArrayList<Info> result = ctrlCR.obteRecursosDisponiblesPerData(d, hi, hf);
        for (int i = 0; i < result.size(); ++i){
            System.out.println(result.get(i).getNom());
        }
    }
}
