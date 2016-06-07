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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Check;

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
   
    @Column(name = "marca")
    private String marca;
    @Column(name = "model")
    private String model;
    @OneToOne
    @JoinColumn(name = "sala_ordinaror", nullable = true)
    private Sala sala;
    
    public Ordinador() {
        
    }
    
    public Ordinador(String name, String marca, String model){
        super(name);
        this.marca = marca;   
        this.model = model;
        new Recurs(name);
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
}
