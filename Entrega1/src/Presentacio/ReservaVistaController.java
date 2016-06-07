/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

/**
 * FXML Controller class
 *
 * @author xavier
 */
public class ReservaVistaController implements Initializable {

    
    @FXML
    private DatePicker calendario;
    @FXML
    private Spinner<LocalTime> spinhini;
    @FXML
    private Spinner<LocalTime> spinhfi;
    @FXML
    private Button buttonok;
    @FXML
    private Button buttoncancel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void ok(ActionEvent event) {
    }
    
    @FXML
    private void exit(ActionEvent event) {
    }
    


    

    
    
}
