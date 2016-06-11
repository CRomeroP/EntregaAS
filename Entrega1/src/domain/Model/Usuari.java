package domain.Model;
// Generated 14-abr-2016 8:24:58 by Hibernate Tools 4.3.1

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;




/**
 * usuari generated by hbm2java
 */
@Entity
@Table(name = "usuari")
public class Usuari  implements java.io.Serializable {

    @Id   
    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;
    @Column(name = "nom", length = 50)
    private String nom;
    @Column(name = "email", length = 50)    
    private String email;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuari")
    private List<ReservaAmbNotificacio> reservasambnotificacio;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuari")
    private List<ReservaSenseNotificacio> reservassensenotificacio;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "notificacions")
    private List<ReservaAmbNotificacio> notificacions = new ArrayList<ReservaAmbNotificacio>();

    public Usuari() {
    }

    public Usuari(String username, String nom, String email) {
        this.username = username;
        this.nom = nom;
        this.email = email;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
       
    public List<ReservaAmbNotificacio> getReservasambnotificacio() {
	return this.reservasambnotificacio;
    }

    public void setReservasambnotificacio(List<ReservaAmbNotificacio> reservas) {
	this.reservasambnotificacio = reservas;
    }
    
    public List<ReservaSenseNotificacio> getReservasSenseNotificacio() {
	return this.reservassensenotificacio;
    }

    public void setReservasSenseNotificacio(List<ReservaSenseNotificacio> reservas) {
	this.reservassensenotificacio = reservas;
    }
    
    public List<ReservaAmbNotificacio> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(List<ReservaAmbNotificacio> notificacions) {
        this.notificacions = notificacions;
    }
    
    public boolean tensSalaReservada(Date d, int hi, int hf) {
        boolean ret = false; 
        boolean b = true;
        for (int i = 0; i < reservasambnotificacio.size() && b ; ++i) {
            b = reservasambnotificacio.get(i).estaDisponible(d, hi, hf);
            if (!b && reservasambnotificacio.get(i).etsSala()) return false;
            else b = true;
        }
        for (int j = 0; j < reservassensenotificacio.size() && !b; ++j) {
            b = reservassensenotificacio.get(j).estaDisponible(d, hi, hf); //crearlo
            if (!b && reservassensenotificacio.get(j).etsSala()) return false;
            else b = true;
        }
        return true;
    }
    	
}


