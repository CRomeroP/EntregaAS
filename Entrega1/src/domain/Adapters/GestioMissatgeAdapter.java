/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Adapters;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Víctor
 */
public class GestioMissatgeAdapter implements IGestioMissatgeAdapter{

    @Override
    public void enviarDadesReserva(String nomR, Date data, int horaIni, int horaFi, String username, String comentari, ArrayList<String> emails){
        System.out.println("arriba al servei");
    }

    
}
