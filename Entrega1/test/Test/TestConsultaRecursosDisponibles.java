/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Data.CtrlRecurs;
import domain.DBInterfaces.CtrlDataFactoria;
import domain.Model.Recurs;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author carlos
 */
public class TestConsultaRecursosDisponibles {
    
    @Test
    public void Test(){
        Date dini = new Date(2016,6,6);
        ArrayList<Recurs> recursos = new ArrayList<Recurs>();
        CtrlDataFactoria CtrlDF = new CtrlDataFactoria();
        CtrlRecurs CtrlR = CtrlDF.getCtrlRecurs();
        recursos = CtrlR.getAll();
    }
    
}
