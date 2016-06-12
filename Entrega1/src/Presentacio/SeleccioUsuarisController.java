/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import domain.Controladors.ControladorCrearReservaAmbNotificacio;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author xavier
 */
public class SeleccioUsuarisController implements Initializable {

    
    
    @FXML
    private Button buttonok;
    @FXML
    private ListView  listRecurs;
    
    private String nomrecurs;
    
    private String nom;
    
    private Date data;
    
    private int horai;
            
    private ControladorCrearReservaAmbNotificacio ccran = new ControladorCrearReservaAmbNotificacio();

    public void inicial(String nomrecurs, int horai, Date d) {
        this.nomrecurs = nomrecurs;
        this.horai = horai;
        this.data = d;
        ccran.obteUsuarisAAssignar(nomrecurs, data, horai);
        
        
        
        
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
