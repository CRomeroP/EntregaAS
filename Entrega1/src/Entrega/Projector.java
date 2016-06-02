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
@Table(name = "projector")
@AttributeOverrides({
        @AttributeOverride(name="nom", column=@Column(name="nomprojector")),
})
public class Projector extends Recurs{
    
    private String resolucio;
    private Sala sala;
    
    public Projector(){
        
    }
    
    public Projector(String name, String resolucio){
        super(name);
        this.resolucio = resolucio;
        new Recurs(name);
    }
    
    @Column(name = "resolucio")
    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
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
