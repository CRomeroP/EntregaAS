/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import domain.Model.Recurs;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public interface CtrlRecurs {

    public void insert(Recurs recurs);

    public Recurs get(String nom);

    public Boolean exists(String nom) throws Exception;

    public ArrayList<Recurs> getAll();

}
