/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Adapters;

import domain.Services.Servei;
import domain.Services.ServiceLocator;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Víctor
 */
public class GestioMissatgeAdapter implements IGestioMissatgeAdapter{

    @Override
    public void enviarDadesReserva(String nomR, Date data, int horaIni, int horaFi, String username, String comentari, ArrayList<String> emails){
        ServiceLocator sv = ServiceLocator.getInstance();
        Servei s = sv.getServeiMissatgeria();
        s.enviarDadesReserva(nomR, data, horaIni, horaFi, username, comentari, emails);
    }

    
}
