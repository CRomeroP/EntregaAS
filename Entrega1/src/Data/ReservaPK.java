/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import domain.Model.Recurs;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marc
 */
public class ReservaPK implements Serializable {
    protected Date data;
    protected Integer horainici;
    protected Recurs recurs;
    
    public ReservaPK() {
        
    }
    
    public ReservaPK(Date d, Integer horainici, Recurs rec) {
        this.data = d;
        this.horainici = horainici;
        this.recurs = rec;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.horainici);
        hash = 79 * hash + Objects.hashCode(this.recurs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservaPK other = (ReservaPK) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.horainici, other.horainici)) {
            return false;
        }
        if (!Objects.equals(this.recurs, other.recurs)) {
            return false;
        }
        return true;
    }
    
}
