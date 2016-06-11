/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Data.CtrlInicialState;
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
    }
}
