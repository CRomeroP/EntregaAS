/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import Data.CtrlInicialState;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author xavier
 */
public class Main extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //ReservaVistaController.display(stage);
        
        Parent root = FXMLLoader.load(getClass().getResource("NuevaReservaVista.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        CtrlInicialState cis = new CtrlInicialState();
        launch(args);
    }
}
