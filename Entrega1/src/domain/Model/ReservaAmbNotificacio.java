/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

import Data.CtrlReservaAmbNotificacio;
import Data.ReservaPK;
import Excepcions.ReservaATope;
import Excepcions.ReservaCaducada;
import domain.Adapters.IGestioMissatgeAdapter;
import domain.Factories.CtrlDataFactoria;
import domain.Factories.ServiceLocator;
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
        @JoinColumn(name = "recurs", nullable = false),
        @JoinColumn(name = "horaIni", nullable = false),
        @JoinColumn(name = "datar", nullable = false)},
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
        this.notificacions.add(usuari);
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
        CtrlDataFactoria factory = CtrlDataFactoria.getInstance();
        CtrlReservaAmbNotificacio CtrlR = factory.getCtrlReservaAmbNotificacio();
        for (int i = 0; i < notificacions.size(); ++i){
            System.out.println(i + " +++++++ " + notificacions.get(i).getUsername());
            CtrlR.afegirUsuariANotificacio(this, notificacions.get(i));
        }
    }
    
    public boolean estaDisponible (Date d, int horai, int horaf){
        System.out.println(d + " " + data + " " + horai + " " + horainici + " "+ horaf + " " + horafi);
        return ((((d.compareTo(this.data))==0 && ((horaf <= this.horainici) || (horai >= this.horafi)))) ||  (d.compareTo(this.data) != 0));
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
        Date fechaActual = new Date();
<<<<<<< HEAD
        int error = data.compareTo(fechaActual);
        if ((error == 1) || (error == 0 && horainici > fechaActual.getHours()));// throw new ReservaCaducada();
=======
        //int error = data.compareTo(fechaActual);
        if ((data.compareTo(fechaActual) < 0) || (data.compareTo(fechaActual) == 0 && horainici > fechaActual.getHours())) throw new ReservaCaducada();
        //if ((error == 1) || (error == 0 && horainici > fechaActual.getHours())) throw new ReservaCaducada();
>>>>>>> 67eef7c97baed4fe6e00baab95f47762638d68cf
        return getUsuarisSenseNot(u);
    }
    
    public boolean etsSala () {
        return recurs.etsSala();
    }
    
    
    public void afegirUsuaris(ArrayList<Usuari> u){
        if (notificacions.size() + u.size() > 10) throw new ReservaATope();
        ArrayList<String> emails = new ArrayList<>();
        CtrlDataFactoria factory = CtrlDataFactoria.getInstance();
        CtrlReservaAmbNotificacio CtrlR = factory.getCtrlReservaAmbNotificacio();

        for (int i = 0; i < u.size(); i++){
            if(u.get(i) == null) System.out.println("es null");
            emails.add(u.get(i).getEmail());
            notificacions.add(u.get(i));
            CtrlR.afegirUsuariANotificacio(this, u.get(i));
        }
        for (int i = 0; i < notificacions.size(); ++i) {
            System.out.println("A PARTIR DE AQUI: " + notificacions.get(i).getUsername());
        }
        String username = usuari.getEmail();
        ServiceLocator sv = ServiceLocator.getInstance();
        IGestioMissatgeAdapter gm = sv.getIGestioMissatgeAdapter();
        gm.enviarDadesReserva(this.recurs.getNom(), this.data, this.horainici, this.horafi, username,this.comentaris, emails);

    }
    
}
