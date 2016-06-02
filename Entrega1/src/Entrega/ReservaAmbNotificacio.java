/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrega;

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
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ReservaAmbNotificacio")
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
    private Usuari usuari;
    @Id
    @OneToOne
    private Recurs recurs;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "esnotifica", joinColumns = {
        @JoinColumn(name = "recurs", nullable = false),
        @JoinColumn(name = "horaIni", nullable = false),
        @JoinColumn(name = "datar", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "username", nullable = false)})
    private Set<Usuari> notificacions = new HashSet<Usuari>(0);

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

    public ReservaAmbNotificacio(Set<Usuari> notificacions) {
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

    public Set<Usuari> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(Set<Usuari> notificacions) {
        this.notificacions = notificacions;
    }
    
    
    
}