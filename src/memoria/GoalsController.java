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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class GoalsController implements Initializable {

    @FXML
    private AnchorPane goalsrecordpane;
    @FXML
    private Button entrybutton;
    @FXML
    private Button statButton;
    @FXML
    private Button goalButton;
    @FXML
    private Button calendarButton;
  //  vbox2.getChildren().addAll(c1);
    //   private CheckBox c1;
    @FXML
    private TextField usernameLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private Button exitbutton;

    @FXML
    private VBox vbox4;
    @FXML
    private TableView<GoalsTable> goalsTable;
    @FXML
    private TableColumn<GoalsTable, String> goalsColumn;
    @FXML
    private TableColumn<GoalsTable, String> duedateColumn;
    @FXML
    private Button DoneButton;
    @FXML
    private TextField addgoalTextField;
    @FXML
    private TextField duedatetextfield;
    @FXML
    private TextField somethingaboutgoaltextfield;

    String user;
    static ObservableList<GoalsTable> list = FXCollections.observableArrayList();

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

   // c1.setOnAction(e->checkBoxAction(c1,vbox1,vbox2));
    String b = "";
    String d = "";
    String f = "";

    /*ObservableList<GoalsTable>list=FXCollections.observableArrayList(
     
     // new GoalsTable(s,d)
     //   new GoalsTable("i","no"),
     // new GoalsTable("am",""),
     //new GoalsTable("hating",""),
     // new GoalsTable("this","")
     
           
     
     
     );*/
    @FXML
    private Button deletButton;
    String s;
    @FXML
    private TableColumn<GoalsTable, String> whythisgoalcolumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            //__________________________________________ N E W C O D E_______________________________________________________________
            username();
        } catch (IOException ex) {
            Logger.getLogger(GoalsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        usernameLabel.setText(user);

        goalsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseConnection db = new DatabaseConnection();
        try {
            GoalsTable.list = db.getGoals(user);
        } catch (SQLException ex) {
            Logger.getLogger(GoalsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        goalsColumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("Goals"));
        duedateColumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("Date"));
        whythisgoalcolumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("statement"));

        goalsTable.setItems(GoalsTable.list);

    }

    @FXML
    private void doneButtonActio(ActionEvent event) throws SQLException {

        b = addgoalTextField.getText();
        d = duedatetextfield.getText();
        f = somethingaboutgoaltextfield.getText();

        moodActivity newMood = new moodActivity(d, "", f, b, "", 0, 0, 0, 0, 0, 0, 0, 0);
        DatabaseConnection db = new DatabaseConnection();
        db.setGoals(newMood, user);
        GoalsTable.list = db.getGoals(user);

        //GoalsTable g = new GoalsTable(b,d,f);
        // list.add(g);
        addgoalTextField.clear();
        duedatetextfield.clear();
        somethingaboutgoaltextfield.clear();

        //  goalsTable.getColumns().addAll(goalsColumn,c);
        goalsColumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("Goals"));
        duedateColumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("Date"));
        whythisgoalcolumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("statement"));
        goalsTable.setItems(GoalsTable.list);

    }

    @FXML
    private void entryButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("entry.fxml"));

        goalsrecordpane.getChildren().setAll(pane2);

    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        goalsrecordpane.getChildren().setAll(pane);

    }

    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }
    /*
     void CheckBoxAction()
     {
     if(c1.isSelected())
     {
     goal1Label.setText("Goal 1 Completed!");
     }
     else
     {
     goal1Label.setText(null);
     }
     if(c2.isSelected())
     {
     goal2Label.setText("Goal 2 Completed!");
     }
     else
     {
     goal2Label.setText(null);
     }
     if(c3.isSelected())
     {
     goal3Label.setText("Goal 3 Completed!");
     }
     else
     {
     goal3Label.setText(null);
     }
     if(c4.isSelected())
     {
     goal4label.setText("Goal 4 Completed!");
     }
     else
     {
     goal4label.setText(null);
     }
     }*/

    @FXML
    private void deletebuttonAction(ActionEvent event) throws IOException, SQLException {
        username();
        //  GoalsTable gt = goalsTable.getSelectionModel().getSelectedItem();
        //list.remove(gt);
       // ObservableList<GoalsTable> selectedItems = FXCollections.observableArrayList();
        //selectedItems = goalsTable.getSelectionModel().getSelectedItems();
        //list.removeAll(selectedItems);
        // goalsTable.getItems().removeAll()
        ObservableList<GoalsTable>selectedItems=FXCollections.observableArrayList();
         selectedItems=goalsTable.getSelectionModel().getSelectedItems();
         DatabaseConnection db = new DatabaseConnection();
         db.deleteGoals(user, selectedItems);
          try {
            GoalsTable.list = db.getGoals(user);
        } catch (SQLException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         goalsColumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("Goals"));
        duedateColumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("Date"));
        whythisgoalcolumn.setCellValueFactory(new PropertyValueFactory<GoalsTable, String>("statement"));
        goalsTable.setItems(GoalsTable.list);
    }

    @FXML
    private void notesButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("notes.fxml"));

        goalsrecordpane.getChildren().setAll(pane);
    }

    @FXML
    private void statsonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stats.fxml"));

        goalsrecordpane.getChildren().setAll(pane);
    }

}
