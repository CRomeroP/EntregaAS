/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

import Data.ReservaPK;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.IdClass;
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
@Table(name = "ReservaSenseNotificacio")
@Check(constraints = "(horafi > horaini) AND (horaini >= 0 AND horaini < 24) AND (horafi > 0 AND horafi < 25)")
public class ReservaSenseNotificacio implements Serializable{
    @Id
    @Temporal(DATE)
    @Column(name = "datar")    
    private Date data;
    @Id
    @Column(name = "horaini")
    private int horainici;
    @Column(name = "horafi", unique = false, nullable = false)
    private int horafi;
    @Column(name = "comentaris", length = 255, unique = false, nullable = true)
    private String comentaris;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Usuari usuari;
    @Id
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Recurs recurs;

    public ReservaSenseNotificacio() {
    }

    public ReservaSenseNotificacio(Date data, int horainici, int horafi, String comentaris, Usuari usuari, Recurs recurs) {
        this.data = data;
        this.horainici = horainici;
        this.horafi = horafi;
        this.comentaris = comentaris;
        this.usuari = usuari;
        this.recurs = recurs;
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
    
    /*public boolean estaDisponible (Date d, int horai, int horaf){
        System.out.println(d + " " + data + " " + horai + " " + horainici + " "+ horaf + " " + horafi);
        return !((d == this.data) && ((horaf >= this.horainici) && (horai <= this.horafi)));
    }*/
    
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

    public boolean etsSala () {
        return recurs.etsSala();
    }
    
}
