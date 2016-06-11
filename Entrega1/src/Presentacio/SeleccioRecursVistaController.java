/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import domain.Controladors.ControladorCrearReservaAmbNotificacio;
import domain.Model.Info;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;




/**
 * FXML Controller class
 *
 * @author xavier
 */
public class SeleccioRecursVistaController implements Initializable {

    
    
    
    @FXML
    private Button buttoncancel;
    @FXML
    private TextField nametxt;
    @FXML
    private TextArea comentxt;
    @FXML
    private Button buttonok;
    @FXML
    private ListView  listRecurs;
    
    private LocalTime hini;
    private LocalTime hfi;
    private LocalDate data;

    public void setHini(LocalTime hini) {
        this.hini = hini;
    }

    public void setHfi(LocalTime hfi) {
        this.hfi = hfi;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    private ControladorCrearReservaAmbNotificacio ccran = new ControladorCrearReservaAmbNotificacio();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Date d = new Date();
        
        
        ArrayList<Info> info = ccran.obteRecursosDisponibles(d, 1, 18);
        ArrayList<String> nom;
        nom = new ArrayList<String>();
        for (Info info1 : info) {
            nom.add(info1.getNom());
        }
        ObservableList<String> lnoms = FXCollections.observableList(nom);
        listRecurs.setItems(lnoms);

    }    
    
        @FXML
    private void ok(ActionEvent event) {
        
    }
    
    @FXML
    private void exit(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        
    }
    
}
