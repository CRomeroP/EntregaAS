package Entrega;
// Generated 14-abr-2016 8:24:58 by Hibernate Tools 4.3.1

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




/**
 * usuari generated by hbm2java
 */
@Entity
@Table(name = "usuari")
public class Usuari  implements java.io.Serializable {

     private String username;
     private String nom;
     private String email;
     private Set<ReservaAmbNotificacio> reservasambnotificacio;
     private Set<ReservaSenseNotificacio> reservassensenotificacio;
     private Set<ReservaAmbNotificacio> notificacions;

    public Usuari() {
    }

    public Usuari(String username, String nom, String email) {
        this.username = username;
        this.nom = nom;
        this.email = email;
    }
    
    @Id
    
    @Column(name = "username", length = 50, unique = true, nullable = false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "nom", length = 50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Column(name = "email", length = 50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuari")
    public Set<ReservaAmbNotificacio> getReservasambnotificacio() {
	return this.reservasambnotificacio;
    }

    public void setReservasambnotificacio(Set<ReservaAmbNotificacio> reservas) {
	this.reservasambnotificacio = reservas;
    }
    
    @OneToMany(mappedBy = "usuari")
    public Set<ReservaSenseNotificacio> getReservasSenseNotificacio() {
	return this.reservassensenotificacio;
    }

    public void setReservasSenseNotificacio(Set<ReservaSenseNotificacio> reservas) {
	this.reservassensenotificacio = reservas;
    }
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "notificacions")
    public Set<ReservaAmbNotificacio> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(Set<ReservaAmbNotificacio> notificacions) {
        this.notificacions = notificacions;
    }
	
}


