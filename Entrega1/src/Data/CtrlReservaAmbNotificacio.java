/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import domain.Model.ReservaAmbNotificacio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface CtrlReservaAmbNotificacio {

    public void insert(ReservaAmbNotificacio reserva);

    public ReservaAmbNotificacio get(String nomRecurs, Date d, int hi);

    public Boolean exists(String nomRecurs, Date d, int hi) throws Exception;

    public List<ReservaAmbNotificacio> getAll();

}
