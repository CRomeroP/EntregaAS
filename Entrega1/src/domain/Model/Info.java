/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Model;

import domain.Factories.CtrlDataFactoria;

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
    private int aforament;
    private String ubicacio;
    private String marcaOrdSala;
    private String modelOrdSala;
    private String resolucioProjSala;
    private CtrlDataFactoria factory;

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

    public void setAforament(int aforament) {
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

    public int getAforament() {
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
    
    public String toString(){
        String s = "";
        s += nom + "; ";
        if(marca != null) s += "Ordinador(marca:" + marca + ", model:" + model + ")";
        if(resolucio != null) s+= "Projector(resolucio:" + resolucio + ")";
        if(ubicacio != null) {
            s+= "Sala(aforament:" + Integer.toString(aforament) + " , ubicacio:" + ubicacio;
            if(marcaOrdSala != null) s+= ", OrdSala(marca:" + marcaOrdSala + ", model:" + modelOrdSala +")";
            if(resolucioProjSala != null) s+= ", ProjSala(resolucio:" + resolucioProjSala + ")";
            s+= ")";
        }
        return s;
    }
    
}
