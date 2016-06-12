/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import Excepcions.NoHiHaProuUsuaris;
import Excepcions.NoHiHaUsuaris;
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
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;




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
    
    private Stage s;
    

    public void setdatas(LocalDate data, LocalTime hfi, LocalTime hini, ArrayList<Info> i) {
        this.hini = hini;
        this.hfi = hfi;
        this.data = data;
        this.info = i;
        filldata();
    }
    private ControladorCrearReservaAmbNotificacio ccran = new ControladorCrearReservaAmbNotificacio();
    
    public void filldata() { 
    
        try{
            Date d = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("LOCAL " + d);

            ArrayList<String> nom;
            nom = new ArrayList<String>();
            for (Info info1 : info) {
                nom.add(info1.toString());
            }
            ObservableList<String> lnoms = FXCollections.observableList(nom);
            listRecurs.setItems(lnoms);
        }
        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText(ex.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                s.show();
            }
        }

    }
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

    }    
    
    @FXML
    private void ok(ActionEvent event)  throws Exception{
        
        try {
            
        String nomr = info.get(listRecurs.getSelectionModel().getSelectedIndex()).getNom();
        ccran.crearReservaAmbNotificacio(nomr, nametxt.getText(), comentxt.getText());
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SeleccioUsuaris.fxml"));
        

        
        Parent root = (Parent)fxmlLoader.load();
        Scene scene = new Scene(root);
        s = (Stage) buttoncancel.getScene().getWindow();
        s.close();
        s.setScene(scene);
        SeleccioUsuarisController controller = fxmlLoader.<SeleccioUsuarisController>getController();
        controller.inicial(nomr, hini.getHour(), Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        s.show();
            
        } catch(Exception ex) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText(ex.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                if(ex.getClass() == NoHiHaProuUsuaris.class){
                    s.close();
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setTitle("Info Dialog");
                    al.setHeaderText("ok");
                    al.setContentText("Reserva realitzada correctament.");
                    al.showAndWait();
                } else {
                s.show();
                }
            }
            
        }

        
    }
    
    @FXML
    private void exit(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        System.exit(0);

        
    }
    
}
