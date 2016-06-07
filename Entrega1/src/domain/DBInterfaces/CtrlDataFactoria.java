/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.DBInterfaces;

import Data.CtrlUsuari;
import Data.CtrlUsuariDB;
import Data.Sessio;
/**
 *
 * @author carlos
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    public CtrlDataFactoria(){}

    public CtrlUsuari getCtrlUsuari(){
        return new CtrlUsuariDB();
        }
    public CtrlRecurs getCtrlRecurs(){
        return new CtrlUsuariDB();
        }
    
}
