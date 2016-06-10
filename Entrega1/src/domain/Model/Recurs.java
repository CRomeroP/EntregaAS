package domain.Model;
// Generated 14-abr-2016 8:24:58 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;




/**
 * Recurs generated by hbm2java
 */
@Entity
@Table(name = "recurs")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Recurs  implements java.io.Serializable{
    
    @Id
    @Column(name = "nom")
    private String nom;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recurs")
    private List<ReservaAmbNotificacio> reservasambnotificacio;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recurs")
    private List<ReservaSenseNotificacio> reservassensenotificacio;
    @Column(name = "type", unique = false, nullable = true, length = 50)
    private Types type;     

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
    
    public List<ReservaAmbNotificacio> getReservasAmbNotificacio() {
	return this.reservasambnotificacio;
    }

    public void setReservasAmbNotificacio(List<ReservaAmbNotificacio> reservas) {
	this.reservasambnotificacio = reservas;
    }

   
    public List<ReservaSenseNotificacio> getReservasSenseNotificacio() {
        return reservassensenotificacio;
    }

    public void setReservasSenseNotificacio(ArrayList<ReservaSenseNotificacio> reservassensenotificacio) {
        this.reservassensenotificacio = reservassensenotificacio;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
    
    public Info getInfo(Info i){
        return null;
    }
    
    public Info infoDisponible(Date d, int horai, int horaf){
        Boolean b = true;
        int i = 0;
        while ((i < this.reservasambnotificacio.size() || i < this.reservassensenotificacio.size()) && b){
            if (i < this.reservasambnotificacio.size()){
                System.out.println("hi");
                if (!this.reservasambnotificacio.get(i).estaDisponible(d, horai, horaf)) return null;
            }
            if (i < reservassensenotificacio.size()){
                if (!this.reservassensenotificacio.get(i).estaDisponible(d, horai, horaf)) return null;
            }
            ++i;
        }
        Info result = new Info();
        result.setNom(this.nom);
        result = getInfo(result);
        return result;
    }
    
    public boolean etsSala() {
        return false;
    }
}


