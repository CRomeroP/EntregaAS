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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ordinador")
@PrimaryKeyJoinColumn(name = "nom")
public class Ordinador extends Recurs{
   
    @Column(name = "marca")
    private String marca;
    @Column(name = "model")
    private String model;
    @OneToOne(mappedBy = "nomordinador")
    private Sala sala;
    
    public Ordinador() {
        
    }
    
    public Ordinador(String name, String marca, String model){
        this.marca = marca;   
        this.model = model;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    } 
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Override
    public Info getInfo(Info i){
        i.setMarca(this.marca);
        i.setModel(this.model);
        return i;
    }
    
    @Override
    public boolean etsSala() {
        return true;
    }
}
