/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrega;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "sala")
@AttributeOverrides({
        @AttributeOverride(name="nom", column=@Column(name="nomsala")),
})
public class Sala extends Recurs{
    
    @Column(name = "ubicacio")
    private String ubicacio;
    @Column(name = "aforament")
    private Integer aforament;
    @OneToOne(mappedBy="sala")
    private Ordinador nomordinador;
    @OneToOne(mappedBy="sala")
    private Projector nomprojector; 

    public Sala(){
        
    }
    
    public Sala(String name, String ubicacio, Integer aforament){
        super(name);
        this.ubicacio = ubicacio;
        this.aforament = aforament;
        new Recurs(name);
    }
    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public Integer getAforament() {
        return aforament;
    }

    public void setAforament(Integer aforament) {
        this.aforament = aforament;
    }
    
    public Ordinador getNomordinador() {
        return nomordinador;
    }

    public void setNomordinador(Ordinador nomordinador) {
        this.nomordinador = nomordinador;
    }

    public Projector getNomprojector() {
        return nomprojector;
    }

    public void setNomprojector(Projector nomprojector) {
        this.nomprojector = nomprojector;
    }   
}
