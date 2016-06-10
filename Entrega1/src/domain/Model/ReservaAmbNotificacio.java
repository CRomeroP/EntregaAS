/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

import Data.CtrlReservaAmbNotificacio;
import domain.DBInterfaces.CtrlDataFactoria;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.PrimaryKeyJoinColumn;
import static javax.persistence.TemporalType.DATE;
import org.hibernate.annotations.Check;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ReservaAmbNotificacio")
@Check(constraints = "(horafi > horaini) AND (horaini >= 0 AND horaini < 24) AND (horafi > 0 AND horafi < 25)")
public class ReservaAmbNotificacio implements Serializable{
    
    @Id
    @Temporal(DATE)
    @Column(name = "datar", unique = true, nullable = false)    
    private Date data;
    @Id
    @Column(name = "horaini", unique = true, nullable = false)
    private Integer horainici;
    @Column(name = "horafi", unique = false, nullable = false)
    private Integer horafi;
    @Column(name = "comentaris", length = 255, unique = false, nullable = true)
    private String comentaris;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Usuari usuari;
    @Id
    @OneToOne
    private Recurs recurs;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
        CtrlDataFactoria factory = new CtrlDataFactoria();
        CtrlReservaAmbNotificacio CtrlR = factory.getCtrlReservaAmbNotificacio();
        for (int i = 0; i < notificacions.size(); ++i){
            CtrlR.afegirUsuariANotificacio(this, notificacions.get(i));
        }
        System.out.println(this.notificacions.size());
    }
    
    public boolean estaDisponible (Date d, int horai, int horaf){
        return true;
    }
    
    private ArrayList<Usuari> getUsuarisSenseNot(ArrayList<Usuari> u){
        for (int i = 0; i < this.notificacions.size(); i++){
            System.out.println(u.indexOf(this.notificacions.get(i)));
        }
        return u;
    }
    
    public ArrayList<Usuari> getPossiblesUsuaris(ArrayList<Usuari> u){
        //llançar excepcio data
        return getUsuarisSenseNot(u);
          
    }
    
    public boolean etsSala () {
        return false;
    }
    
    
    public void afegirUsuaris(ArrayList<Usuari> u){
        if (notificacions.size() + u.size() > 10); //activa[reservaATope]
        ArrayList<String> emails = new ArrayList<>();
        for (int i = 0; i < u.size(); i++){
            emails.add(u.get(i).getEmail());
            notificacions.add(u.get(i));
        }
        String username = usuari.getEmail();
    }
    
}
