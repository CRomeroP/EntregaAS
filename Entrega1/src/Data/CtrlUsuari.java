/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import domain.Model.Usuari;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface CtrlUsuari {

    public void insert(Usuari usuari);

    public Usuari get(String username);

    public Boolean exists(String username) throws Exception;

    public List<Usuari> getAll();

}
