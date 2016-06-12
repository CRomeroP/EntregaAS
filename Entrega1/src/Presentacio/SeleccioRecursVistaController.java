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
import java.time.ZoneId;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;




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
    private ArrayList<Info> info;

    public void setdatas(LocalDate data, LocalTime hfi, LocalTime hini) {
        this.hini = hini;
        this.hfi = hfi;
        this.data = data;
        filldata();
    }
    private ControladorCrearReservaAmbNotificacio ccran = new ControladorCrearReservaAmbNotificacio();
    
    /*public void setHini(LocalTime hini) {

    }*/
    public void filldata() { 
    
        Date d = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        info = ccran.obteRecursosDisponibles(d, hini.getHour(), hfi.getHour());
        ArrayList<String> nom;
        nom = new ArrayList<String>();
        for (Info info1 : info) {
            nom.add(info1.toString());
        }
        ObservableList<String> lnoms = FXCollections.observableList(nom);
        listRecurs.setItems(lnoms);
        
    }
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

    }    
    
    @FXML
    private void ok(ActionEvent event)  throws Exception{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SeleccioUsuaris.fxml"));
        SeleccioUsuarisController  controller = fxmlLoader.<SeleccioUsuarisController>getController();

        controller.inicial(info.get(listRecurs.getSelectionModel().getSelectedIndex()).getNom(), hini.getHour(), Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Parent root = (Parent)fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void exit(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        
    }
    
}
