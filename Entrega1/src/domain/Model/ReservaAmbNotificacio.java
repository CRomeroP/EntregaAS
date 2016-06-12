/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

import Data.CtrlReservaAmbNotificacio;
import Data.CtrlUsuari;
import Data.ReservaPK;
import Excepcions.ReservaATope;
import Excepcions.ReservaCaducada;
import domain.Adapters.IGestioMissatgeAdapter;
import domain.Factories.CtrlDataFactoria;
import domain.Factories.CtrlAdaptersFactoria;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import static javax.persistence.TemporalType.DATE;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author carlos
 */


@Entity
@IdClass(ReservaPK.class)
@Table(name = "ReservaAmbNotificacio")
@Check(constraints = "(horafi > horaini) AND (horaini >= 0 AND horaini < 24) AND (horafi > 0 AND horafi < 25)")
public class ReservaAmbNotificacio implements Serializable{
    
    @Id
    @Temporal(DATE)
    @Column(name = "datar")    
    private Date data;
    @Id
    @Column(name = "horaini")
    private Integer horainici;
    @Column(name = "horafi", unique = false, nullable = false)
    private Integer horafi;
    @Column(name = "comentaris", length = 255, unique = false, nullable = true)
    private String comentaris;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Usuari usuari;
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Recurs recurs;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "esnotifica", joinColumns = {
        @JoinColumn(name = "datar", nullable = false),
        @JoinColumn(name = "horaIni", nullable = false),
        @JoinColumn(name = "recurs", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "username", nullable = false)})
    private List<Usuari> notificacions = new ArrayList<Usuari>();

    public ReservaAmbNotificacio() {
    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, Usuari usuari, Recurs recurs) {
        this.data = data;
        this.horainici = horainici;
        this.horafi = horafi;
        this.comentaris = comentaris;
        this.usuari = usuari;
        this.recurs = recurs;
    }

    public ReservaAmbNotificacio(ArrayList<Usuari> notificacions) {
        this.notificacions = notificacions;
    }
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getHorainici() {
        return horainici;
    }

    public void setHorainici(Integer horainici) {
        this.horainici = horainici;
    }
    

    public Integer getHorafi() {
        return horafi;
    }

    public void setHorafi(Integer horafi) {
        this.horafi = horafi;
    }
    
    public String getComentaris() {
        return comentaris;
    }

    public void setComentaris(String comentaris) {
        this.comentaris = comentaris;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Recurs getRecurs() {
        return recurs;
    }

    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }    

    public List<Usuari> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(List<Usuari> notificacions) {
        this.notificacions.addAll(notificacions);
    }
    
    public boolean estaDisponible (Date d, int horai, int horaf){
        int year = data.getYear();
        int month = data.getMonth();
        int year2 = d.getYear() + 1900;
        int month2 = d.getMonth()+ 1;
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int day2 = c.get(Calendar.DAY_OF_MONTH);
        c.setTime(data);
        int day = c.get(Calendar.DAY_OF_MONTH);
        
        System.out.println("PROBA MARC ----------------------------------");
        System.out.println("Reserva Presentacio " + year2 + " " + month2 + " " + day2);
        System.out.println("Reserva Real " + year + " " + month + " " + day);
        //System.out.println("VICTOR FEO----------------" + d + " " + year + " " + month + " " + day + " " + day2 + " " + horai + " " + horainici + " "+ horaf + " " + horafi);
        boolean b = (year == year2 && month == month2 && day == day2);
        System.out.println("BOOLEAN B" + b);
        return (((b && ((horaf <= this.horainici) || (horai >= this.horafi)))) ||  (!b));
    }
    
    /*public boolean estaDisponible (Date d, int horai, int horaf){
        System.out.println(d + " " + data + " " + horai + " " + horainici + " "+ horaf + " " + horafi);
        return !((d == this.data) && ((horaf >= this.horainici) && (horai <= this.horafi)));
    }*/
    
    private ArrayList<Usuari> getUsuarisSenseNot(ArrayList<Usuari> u){
        boolean b;
        for (int i = 0; i < notificacions.size(); ++i){
           b = true;
           for (int j = 0; j < u.size() && b; ++j){
               if((notificacions.get(i).getUsername()).equals(u.get(j).getUsername())){
                   u.remove(j);
                   b = false;
               }
           }
        }
        return u;
    }
    
    public ArrayList<Usuari> getPossiblesUsuaris(ArrayList<Usuari> u){
        int year2 = data.getYear() + 1900;
        int month2 = data.getMonth()+ 1;
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        int day2 = c.get(Calendar.DAY_OF_MONTH);
        Date d = c.getTime();
        c.setTime(data);
                
        if (d.after(data)) throw new ReservaCaducada("La reserva ha caducat");
        return getUsuarisSenseNot(u);
    }
    
    public boolean etsSala () {
        return recurs.etsSala();
    }
    
    
    public void afegirUsuaris(ArrayList<Usuari> u){
        if (notificacions.size() + u.size() > 10) throw new ReservaATope("La reserva esta a tope");
        System.out.println("NOTIFICACIONS SIZE " + notificacions.size());
        ArrayList<String> emails = new ArrayList<>();
        CtrlDataFactoria factory = CtrlDataFactoria.getInstance();
        CtrlReservaAmbNotificacio CtrlR = factory.getCtrlReservaAmbNotificacio();
        int j = notificacions.size();
        for (int i = 0; i < u.size(); i++){
            System.out.println("UserName             " + u.get(i).getUsername());
            emails.add(u.get(i).getEmail());
            u.get(i).addNotificacio(this);
        }
        setNotificacions(u);
        CtrlAdaptersFactoria ca = CtrlAdaptersFactoria.getInstance();
        IGestioMissatgeAdapter gm = ca.getIGestioMissatgeAdapter();
        String username = usuari.getUsername();
        gm.enviarDadesReserva(this.recurs.getNom(), this.data, this.horainici, this.horafi, username,this.comentaris, emails);
        CtrlR.afegirUsuariANotificacio(this);

    }
    
    public void addNotificacio(Usuari u){
        this.notificacions.add(u);
    } 
}
