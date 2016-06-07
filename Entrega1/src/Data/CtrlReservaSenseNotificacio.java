/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import domain.Model.ReservaSenseNotificacio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface CtrlReservaSenseNotificacio {

    public void insert(ReservaSenseNotificacio reserva);

    public ReservaSenseNotificacio get(String username, String nomRecurs, Date d, int hi);

    public Boolean exists(String username, String nomRecurs, Date d, int hi) throws Exception;

    public List<ReservaSenseNotificacio> getAll();

}
