/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Controladors;

import Data.CtrlRecurs;
import domain.Model.Recurs;
import java.util.Date;
import domain.Factories.CtrlDataFactoria;
import domain.Model.Info;
import java.util.ArrayList;

/**
 *
 * @author Víctor
 */
public class ControladorConsultaRecursosDisponiblesPerData {

    public ControladorConsultaRecursosDisponiblesPerData() {
    }
    
    public ArrayList<Info> obteRecursosDisponiblesPerData(Date d, int horain, int horafi){
        
        if (horafi < horain) System.out.println("PeriodeErroni");
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlRecurs cr = factory.getCtrlRecurs();
        ArrayList<Recurs> r = cr.getAll(); 
        ArrayList<Info> recursos = new ArrayList<Info>();
        Info inf = new Info();
        for (int i=0;i<r.size();++i){      
            inf = r.get(i).infoDisponible(d, horain, horafi);
            if (inf != null)recursos.add(inf);
        }
        if (recursos.isEmpty()) System.out.println("NoHiHaRecursos");
        return recursos;
    }  
}
