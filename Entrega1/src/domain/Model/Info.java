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
public class Info {

    public Info() {
    }
    private String nom;
    private String marca;
    private String model;
    private String resolucio;
    private String aforament;
    private String ubicacio;
    private String marcaOrdSala;
    private String modelOrdSala;
    private String resolucioProjSala;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }

    public void setAforament(String aforament) {
        this.aforament = aforament;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public void setMarcaOrdSala(String marcaOrdSala) {
        this.marcaOrdSala = marcaOrdSala;
    }

    public void setModelOrdSala(String modelOrdSala) {
        this.modelOrdSala = modelOrdSala;
    }

    public void setResolucioProjSala(String resolucioProjSala) {
        this.resolucioProjSala = resolucioProjSala;
    }

    public String getNom() {
        return nom;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getResolucio() {
        return resolucio;
    }

    public String getAforament() {
        return aforament;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public String getMarcaOrdSala() {
        return marcaOrdSala;
    }

    public String getModelOrdSala() {
        return modelOrdSala;
    }

    public String getResolucioProjSala() {
        return resolucioProjSala;
    }
    
}
