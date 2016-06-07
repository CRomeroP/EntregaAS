/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.DBInterfaces;

import Data.CtrlUsuariDB;
/**
 *
 * @author carlos
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    private CtrlDataFactoria(){}

    public CtrlUsuari getCtrlCasella(){
        return new CtrlUsuariDB();
        }
    
}
