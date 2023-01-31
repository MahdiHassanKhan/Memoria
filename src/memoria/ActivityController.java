/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class ActivityController implements Initializable {

    @FXML
    private AnchorPane recordpane;
    @FXML
    private Button exitbutton;
    @FXML
    private Button logoutButton;
    @FXML
    private TextField usernameLabel;
    @FXML
    private Button entrybutton;
    @FXML
    private Button statButton;
    @FXML
    private Button goalButton;
    @FXML
    private Button calendarButton;
    //FIle er kaaj
    //__________________________________________ N E W C O D E_______________________________________________________________
    String s;

    void username() throws IOException {
        File file = new File("username.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            s = sc.nextLine();
            System.out.println(s);
            usernameLabel.setText(s);
        }

    }

    //__________________________________________ N E W C O D E_______________________________________________________________

    /**
     * Initializes the controller class.
     */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //__________________________________________ N E W C O D E_______________________________________________________________
            username();
        } catch (IOException ex) {
            Logger.getLogger(ActivityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        usernameLabel.setText(s);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        recordpane.getChildren().setAll(pane);
    }

    public void passUsername(String s) {
        usernameLabel.setText(s);
    }

    @FXML
    private void entryButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("entry.fxml"));

        recordpane.getChildren().setAll(pane2);

    }

    @FXML
    private void goalsButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("goals.fxml"));

        recordpane.getChildren().setAll(pane);
    }

    @FXML
    private void notesButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("notes.fxml"));

        recordpane.getChildren().setAll(pane);
    }

    @FXML
    private void statsonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stats.fxml"));

        recordpane.getChildren().setAll(pane);
    }
}
