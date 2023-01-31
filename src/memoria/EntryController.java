/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class EntryController implements Initializable {

    @FXML
    private Button entrybutton;
    @FXML
    private Button statButton;
    @FXML
    private Button goalButton;
    @FXML
    private Button calendarButton;
    @FXML
    private TextField usernameLabel;
    @FXML
    private TableView<TableInfo> table;
    @FXML
    private TableColumn<TableInfo, String> name;
    @FXML
    private TableColumn<TableInfo, String> mood;
    @FXML
    private TableColumn<TableInfo, String> activity;

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
    /*
     ObservableList<TableInfo>list=FXCollections.observableArrayList(
    
     new TableInfo("Zunayed","rad","work"),
     new TableInfo("Nafisha","meh","date"),
     new TableInfo("Mahdi","good","work"),
     new TableInfo("Peom","awf","work"),
     new TableInfo("Ahnaf","rad","work"),
     new TableInfo("Mustofa","good","work")
     );*/
    @FXML
    private AnchorPane recordEntrypane;
    @FXML
    private Button entrylogoutButton;
    @FXML
    private Button exitbutton;

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
            Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseConnection db = new DatabaseConnection();
        try {
            TableInfo.moodList = db.getMoodEntry(s);
        } catch (SQLException ex) {
            Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        usernameLabel.setText(s);

        name.setCellValueFactory(new PropertyValueFactory<TableInfo, String>("name"));
        mood.setCellValueFactory(new PropertyValueFactory<TableInfo, String>("mood"));
        activity.setCellValueFactory(new PropertyValueFactory<TableInfo, String>("activity"));

        table.setItems(TableInfo.moodList);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        recordEntrypane.getChildren().setAll(pane);
    }

    @FXML
    private void goalsButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("goals.fxml"));

        recordEntrypane.getChildren().setAll(pane2);

    }

    @FXML
    private void notesButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("notes.fxml"));

        recordEntrypane.getChildren().setAll(pane);
    }

    @FXML
    private void statsonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stats.fxml"));

        recordEntrypane.getChildren().setAll(pane);
    }
}
