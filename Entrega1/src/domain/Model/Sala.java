/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Check;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "sala")
@Check(constraints = "aforament > 0")
@AttributeOverrides({
        @AttributeOverride(name="nom", column=@Column(name="nomsala")),
})
public class Sala extends Recurs{
    
    @Column(name = "ubicacio")
    private String ubicacio;
    @Column(name = "aforament")
    private Integer aforament;
    @OneToOne
    @JoinColumn(name = "sala_ordinador", nullable = true)
    private Ordinador nomordinador;
    @OneToOne
    @JoinColumn(name = "sala_projector", nullable = true)
    private Projector nomprojector; 

    public Sala(){
        
    }
    
    public Sala(String name, String ubicacio, Integer aforament, Projector nomProj, Ordinador nomPc){
        this.ubicacio = ubicacio;
        this.aforament = aforament;
        this.nomprojector = nomProj;
        this.nomordinador = nomPc;
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
    
    public Info getInfo(Info i){
        i.setAforament(this.aforament);
        i.setUbicacio(this.ubicacio);
        if (this.nomordinador != null){
            i.setModelOrdSala(this.nomordinador.getModel());
            i.setMarcaOrdSala(this.nomordinador.getMarca());
        }
        if (this.nomordinador != null){
            i.setResolucioProjSala(this.nomprojector.getResolucio());
        }
        return i;
    }
    @Override
    public boolean etsSala() {
        return true;
    }
}
