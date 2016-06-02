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
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ReservaAmbNotificacio")
public class ReservaAmbNotificacio {
    
    private Date data;
    private Integer horainici;
    private Integer horafi;
    private String comentaris;
    private Usuari usuari;
    private Recurs recurs;
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
    
    @Id
    @Temporal(DATE)
    @Column(name = "datar", unique = true, nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Id
    @Column(name = "horaini", unique = true, nullable = false)
    public Integer getHorainici() {
        return horainici;
    }

    public void setHorainici(Integer horainici) {
        this.horainici = horainici;
    }
    
    @Id
    @Column(name = "horafi", unique = false, nullable = false)
    public Integer getHorafi() {
        return horafi;
    }

    public void setHorafi(Integer horafi) {
        this.horafi = horafi;
    }
    
    @Column(name = "comentaris", length = 255, unique = false, nullable = true)
    public String getComentaris() {
        return comentaris;
    }

    public void setComentaris(String comentaris) {
        this.comentaris = comentaris;
    }

    @ManyToOne
    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Id
    @Column(name = "recursreserva", length = 50, unique = true, nullable = false)
    @OneToOne
    public Recurs getRecurs() {
        return recurs;
    }

    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }    

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "esnotifica", joinColumns = {
        @JoinColumn(name = "recurs", nullable = false),
        @JoinColumn(name = "horaIni", nullable = false),
        @JoinColumn(name = "datar", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "username", nullable = false)})
    public Set<Usuari> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(Set<Usuari> notificacions) {
        this.notificacions = notificacions;
    }
    
    
    
}
