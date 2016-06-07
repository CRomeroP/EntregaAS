package domain.Model;
// Generated 14-abr-2016 8:24:58 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




/**
 * Recurs generated by hbm2java
 */
@Entity
@Table(name = "recurs")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Recurs  implements java.io.Serializable {
    
    @Id
    @Column(name = "nom")
    private String nom;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recurs")
    private ArrayList<ReservaAmbNotificacio> reservasambnotificacio;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recurs")
    private ArrayList<ReservaSenseNotificacio> reservassensenotificacio;
    @Column(name = "type", unique = false, nullable = true, length = 50)
    private String type;     

    public Recurs() {
    }
      
    public Recurs(String nom) {
        this.nom = nom;
    }
     
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public ArrayList<ReservaAmbNotificacio> getReservasAmbNotificacio() {
	return this.reservasambnotificacio;
    }

    public void setReservasAmbNotificacio(ArrayList<ReservaAmbNotificacio> reservas) {
	this.reservasambnotificacio = reservas;
    }

   
    public ArrayList<ReservaSenseNotificacio> getReservasSenseNotificacio() {
        return reservassensenotificacio;
    }

    public void setReservasSenseNotificacio(ArrayList<ReservaSenseNotificacio> reservassensenotificacio) {
        this.reservassensenotificacio = reservassensenotificacio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Info infoDisponible(Date d, int horai, int horaf){
        Info result = null;
        Boolean b = true;
        int i = 0;
        while (i < this.reservasambnotificacio.size() && i < this.reservassensenotificacio.size() && b){
            if (i < this.reservasambnotificacio.size()){
                if (!this.reservasambnotificacio.get(i).estaDisponible(d, horai, horaf)) b = false;
            }
            if (i < reservassensenotificacio.size()){
                if (!this.reservasambnotificacio.get(i).estaDisponible(d, horai, horaf)) b = false;
            }
        }
        return null;
    }
}


