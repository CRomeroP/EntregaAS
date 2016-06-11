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
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.LocalTimeStringConverter;

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
        // TODO
        SpinnerValueFactory<LocalTime> spinini = new SpinnerValueFactory<LocalTime>() {
            
                {
                    //setConverter(new LocalTimeStringConverter(FormatStyle.MEDIUM));
                     setConverter(new LocalTimeStringConverter(DateTimeFormatter.ofPattern("HH:mm"), DateTimeFormatter.ofPattern("HH:mm")));

                }
            @Override
            public void decrement(int i) {
                System.out.println("i");
                if (getValue() == null){
                    setValue(LocalTime.now());
                    System.out.println("i");
                }
                else {
                    LocalTime time = (LocalTime) getValue();
                    setValue(time.minusMinutes(30));
                    System.out.println("i");
                }
            }

            @Override
            public void increment(int i) {
                System.out.println("i");
                if (this.getValue() == null){
                    System.out.println("i");
                    setValue(LocalTime.now());
                }
                else {
                    LocalTime time = (LocalTime) getValue();
                    setValue(time.plusMinutes(30));
                    System.out.println("i");
                }
            }
        };
        int seconds = LocalTime.now().getSecond();
        spinini.setValue(LocalTime.now().minusSeconds(seconds).minusMinutes(LocalTime.now().getMinute()).plusHours(1));
        spinhini.setValueFactory(spinini);
        spinhini.setEditable(true);
        /*spininsi();
        
        
        spinhini.setValueFactory(LocalTime.now());*/
        SpinnerValueFactory<LocalTime> spinfi = new SpinnerValueFactory<LocalTime>() {
                {
                    //setConverter(new LocalTimeStringConverter(FormatStyle.MEDIUM));
                     setConverter(new LocalTimeStringConverter(DateTimeFormatter.ofPattern("HH:mm"), DateTimeFormatter.ofPattern("HH:mm")));

                }
            @Override
            public void decrement(int i) {
                System.out.println("i");
                if (getValue() == null){
                    setValue(LocalTime.now());
                    System.out.println("i");
                }
                else {
                    LocalTime time = (LocalTime) getValue();
                    setValue(time.minusMinutes(30));
                    System.out.println("i");
                }
            }

            @Override
            public void increment(int i) {
                System.out.println("i");
                if (this.getValue() == null){
                    System.out.println("i");
                    setValue(LocalTime.now());
                }
                else {
                    LocalTime time = (LocalTime) getValue();
                    setValue(time.plusMinutes(30));
                    System.out.println("i");
                }
            }
        };
        spinfi.setValue(LocalTime.now().minusSeconds(seconds).minusMinutes(LocalTime.now().getMinute()).plusHours(2));
        spinhfi.setValueFactory(spinfi);
        spinhfi.setEditable(true);
    }
    
    @FXML
    private void handleOkAction(ActionEvent event) throws Exception{
        lael.setText("entramos en la funcion");  
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SeleccioRecursVista.fxml"));
        SeleccioRecursVistaController  controller = fxmlLoader.<SeleccioRecursVistaController>getController();
        controller.setData(calendario.getValue());
        controller.setHfi(spinhini.getValue());
        controller.setHini(spinhfi.getValue());
        Parent root = (Parent)fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void handleExitAction(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        
    }
    
}