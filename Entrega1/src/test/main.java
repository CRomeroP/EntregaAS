/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Data.CtrlRecurs;
import domain.Controladors.ControladorConsultaRecursosDisponiblesPerData;
import domain.DBInterfaces.CtrlDataFactoria;
import domain.Model.Info;
import domain.Model.Recurs;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class main {
   
    public static void main(String[] args){
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlRecurs CtrlR = factory.getCtrlRecurs();
        Date d = new Date(2016,6,8);
        int hi = 7;
        int hf = 9;
        Recurs r = new Recurs("rec");
        CtrlR.insert(r);
        ArrayList<Info> result = new ArrayList<Info>();
        ControladorConsultaRecursosDisponiblesPerData ctrlCR = new ControladorConsultaRecursosDisponiblesPerData();
        result = ctrlCR.obteRecursosDisponiblesPerData(d, hi, hf);
        for (int i = 0; i < result.size(); ++i){
            System.out.println(result.get(i).getNom());
        }
    }
}
