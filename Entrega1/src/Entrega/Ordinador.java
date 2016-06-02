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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ordinador")
@AttributeOverrides({
        @AttributeOverride(name="nom", column=@Column(name="nomordinador")),
})
public class Ordinador extends Recurs{
   
    private String marca;
    private String model;
    private Sala sala;
    
    public Ordinador() {
        
    }
    
    public Ordinador(String name, String marca, String model){
        super(name);
        this.marca = marca;   
        this.model = model;
        new Recurs(name);
    }
    
    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    } 
    
    @OneToOne
    @PrimaryKeyJoinColumn
    @Column(name = "nomsala")
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
