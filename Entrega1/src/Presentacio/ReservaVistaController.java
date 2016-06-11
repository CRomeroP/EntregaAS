/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    @FXML
    private Label lael;
    
    static Stage stageactual;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final Callback<DatePicker, DateCell> dayCellFactory;
        dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        LocalDate d = LocalDate.now();
                        if (item.getDayOfYear() < d.getDayOfYear() || item.getYear() < d.getYear()) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                       
                    }
                };
            }
        };
        this.calendario.setDayCellFactory(dayCellFactory);
    }
    
    @FXML
    private void handleOkAction(ActionEvent event) {
        lael.setText("entramos en la funcion");                
        
    }
    
    @FXML
    private void handleExitAction(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        
    }
    
}