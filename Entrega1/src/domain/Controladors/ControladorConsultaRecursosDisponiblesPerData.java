/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Controladors;

import Data.CtrlRecurs;
import domain.Model.Recurs;
import java.util.Date;
import domain.DBInterfaces.CtrlDataFactoria;
import domain.Model.Info;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Víctor
 */
public class ControladorConsultaRecursosDisponiblesPerData {

    public ControladorConsultaRecursosDisponiblesPerData() {
    }
    
    public ArrayList<Info> obteRecursosDisponiblesPerData(Date d, int horain, int horafi){
        
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlRecurs cr = factory.getCtrlRecurs();
        List<Recurs> r = cr.getAll();
        ArrayList<Info> recursos = new ArrayList<>();
        for (int i=0;i<r.size();i++){
            recursos.add(r.get(i).infoDisponible(d, horain, horafi));
        }
        return recursos;
    }
    
}
