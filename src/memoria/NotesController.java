/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class NotesController implements Initializable {

    @FXML
    private AnchorPane recordNotespane;
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
    private Button logoutButton;
    @FXML
    private Button exitbutton;
    @FXML
    private TextField writenotestextfield;
    @FXML
    private Button addButton;
    private TextArea mynotestextarea;
    @FXML
    private TableView<NotesTable> mynotestable;
    @FXML
    private TableColumn<NotesTable, String> mynotescolumn;
    @FXML
    private Button deleteButton;

    /**
     * Initializes the controller class.
     */
    String user;

    void username() throws IOException {
        File file = new File("username.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            user = sc.nextLine();
            //System.out.println(s);
            usernameLabel.setText(user);
        }

    }

    ObservableList<NotesTable> list = FXCollections.observableArrayList();
    @FXML
    private ScrollPane scrollpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            // mynotestable.scrollTo(100);
            username();
        } catch (IOException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        usernameLabel.setText(user);

        mynotestable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        DatabaseConnection db = new DatabaseConnection();
        try {
            NotesTable.list = db.getNotes(user);
        } catch (SQLException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mynotescolumn.setCellValueFactory(new PropertyValueFactory<NotesTable, String>("notes"));
        mynotestable.setItems(NotesTable.list);

    }

    @FXML
    private void entryButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("entry.fxml"));

        recordNotespane.getChildren().setAll(pane2);

    }

    @FXML
    private void goalsButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("goals.fxml"));

        recordNotespane.getChildren().setAll(pane2);

    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        recordNotespane.getChildren().setAll(pane);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }

    String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        System.out.println(dateFormat.format(d));

        return dateFormat.format(d);

    }

    @FXML
    private void addButtonAction(ActionEvent event) throws SQLException {
        String s = writenotestextfield.getText();

        moodActivity newMood = new moodActivity(getDate(), "", s, "", "0", 0, 0, 0, 0, 0, 0, 0, 0);
        DatabaseConnection db = new DatabaseConnection();
        db.saveMoodEntry(newMood, user);

        try {
            NotesTable.list = db.getNotes(user);
        } catch (SQLException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mynotescolumn.setCellValueFactory(new PropertyValueFactory<NotesTable, String>("notes"));
        mynotestable.setItems(NotesTable.list);

        // NotesTable n = new NotesTable(s);
        // list.add(n);
        writenotestextfield.clear();

    }

    @FXML
    private void deletenoteAction(ActionEvent event) throws SQLException, IOException { 
        username();
         ObservableList<NotesTable>selectedItems=FXCollections.observableArrayList();
         selectedItems=mynotestable.getSelectionModel().getSelectedItems();
         DatabaseConnection db = new DatabaseConnection();
         db.deleteNotes(user, selectedItems);
          try {
            NotesTable.list = db.getNotes(user);
        } catch (SQLException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mynotescolumn.setCellValueFactory(new PropertyValueFactory<NotesTable, String>("notes"));
        mynotestable.setItems(NotesTable.list);
         //NotesTable.list.removeAll(selectedItems); 
         
       //  mynotestable.setEditable ( true);
      /*  list.removeAll(mynotestable.getSelectionModel().getSelectedItems());
         mynotestable.getSelectionModel().clearSelection();*/
        //ObservableList<NotesTable> selectedItems = FXCollections.observableArrayList();
       // selectedItems = mynotestable.getSelectionModel().getSelectedItems();
       // list.removeAll(selectedItems);
        //  NotesTable gt = mynotestable.getSelectionModel().getSelectedItem();
        //list.remove(gt);
    }

    @FXML
    private void statsonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stats.fxml"));

        recordNotespane.getChildren().setAll(pane);
    }
}
