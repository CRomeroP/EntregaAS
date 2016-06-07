/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

/**
 *
 * @author Víctor
 */
public class InfoUsuari {

    public InfoUsuari() {
    }
    
    private String username;
    
    private String nom;
    
    private String email;
    

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
