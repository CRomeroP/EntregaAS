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

    @Column(name = "resolucio")    
    private String resolucio; 
    @OneToOne(mappedBy = "nomprojector")
    private Sala sala;
    
    public Projector(){
        
    }
    
    public Projector(String name, String resolucio){
        super(name);
        this.resolucio = resolucio;
        new Recurs(name);
    }
    
    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }  
    
    @Override
    public Info getInfo(Info i){
        i.setResolucio(this.resolucio);
        return i;
    }
    
    @Override
    public boolean etsSala() {
        return false;
    }
           
}
