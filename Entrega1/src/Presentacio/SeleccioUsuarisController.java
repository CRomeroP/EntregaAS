/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import domain.Controladors.ControladorCrearReservaAmbNotificacio;
import domain.Model.Info;
import domain.Model.Usuari;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author xavier
 */
public class SeleccioUsuarisController implements Initializable {

    
    
    @FXML
    private Label totalusers;
    @FXML
    private Button buttonok;
    @FXML
    private Button buttoncancel;
    @FXML
    private ListView  listusers;
    
    private String nomrecurs;
    
    private String nom;
    
    private Date data;
    
    private int horai;
    
    private int totaluserscount = 1;
            
    private ControladorCrearReservaAmbNotificacio ccran = new ControladorCrearReservaAmbNotificacio();

    public void inicial(String nomrecurs, int horai, Date d) {
        this.nomrecurs = nomrecurs;
        this.horai = horai;
        this.data = d;
        ArrayList<String> result = ccran.obteUsuarisAAssignar(nomrecurs, data, horai);

        ObservableList<String> lnoms = FXCollections.observableList(result);
        listusers.setItems(lnoms);
        
    }    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        listusers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }    
    
    @FXML 
    public void handleMouseClick(ActionEvent event) {
        
        totaluserscount = listusers.getSelectionModel().getSelectedIndices().size() + 1;
        if(totaluserscount > 10) {
            totalusers.setTextFill(Color.web("#ff0000"));
        } else {
            totalusers.setTextFill(Color.web("#00ff00"));
        }
        totalusers.setText("Usuaris seleccionats: " + totaluserscount + "/10");
        
    }
    
    
    @FXML
    private void ok(ActionEvent event)  throws Exception{
        ArrayList<String> noms = new ArrayList<String>();
        for (Object nom : listusers.getSelectionModel().getSelectedItems()) {
            noms.add(nom.toString());
            
        }
        ccran.assignarUsuarisAReserva(noms);
        

    }
    
    @FXML
    private void exit(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        
    }
    
    
}
