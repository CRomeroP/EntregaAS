/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import Excepcions.DadesNoIntroduides;
import Excepcions.PeriodeErroni;
import domain.Controladors.ControladorCrearReservaAmbNotificacio;
import domain.Model.Info;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    
    private Stage s;
    private ControladorCrearReservaAmbNotificacio ccran = new ControladorCrearReservaAmbNotificacio();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calendario.setValue(LocalDate.now());
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
                    setValue(time.minusMinutes(60));
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
                    setValue(time.plusMinutes(60));
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
        try{
            if(calendario.getValue() == null || spinhini.getValue() == null || spinhfi.getValue() == null) throw new DadesNoIntroduides("Dades no introduides");
            if((calendario.getValue().compareTo(LocalDate.now()) == 0) && spinhini.getValue().getHour() <= LocalTime.now().getHour()) throw new PeriodeErroni("error en el periode");
            ArrayList<Info> info;
            info = ccran.obteRecursosDisponibles(Date.from(calendario.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),spinhini.getValue().getHour(),spinhfi.getValue().getHour());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SeleccioRecursVista.fxml"));

            Scene scene = new Scene((Parent)fxmlLoader.load());
            s = (Stage) buttoncancel.getScene().getWindow();
            s.close();
            s.setScene(scene);

            SeleccioRecursVistaController  controller = fxmlLoader.<SeleccioRecursVistaController>getController();

            
            
                    

            controller.setdatas(calendario.getValue(),spinhfi.getValue(),spinhini.getValue(),info);


            s.show();
        }
        catch(Exception ex){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText(ex.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                
                
                
            }
        }
    }
    
    @FXML
    private void handleExitAction(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) buttoncancel.getScene().getWindow();
        // do what you have to do
        stage.close();
        System.exit(0);
        
    }
    
}
