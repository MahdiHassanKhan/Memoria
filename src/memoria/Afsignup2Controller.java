/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class Afsignup2Controller implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private Button workButton;
    @FXML
    private AnchorPane activityPane;
    @FXML
    private Button dateButton;
    @FXML
    private Button friendsButton;
    @FXML
    private Button familyButton;
    @FXML
    private Button goodMealButton;
    @FXML
    private Button musicButton;
    @FXML
    private Button workoutButton;
    @FXML
    private Button readingButton;
    @FXML
    private Button next;

    /**
     * Initializes the controller class.
     */
    //NEW CODE
    //__________________________________________ N E W C O D E_______________________________________________________________
    String moodString = "";
    int work = 0;
    int family = 0;
    int friends = 0;
    int date = 0;
    int reading = 0;
    int workout = 0;
    int music = 0;
    int goodMeal = 0;
    String activity = "";
    String user;

    void username() throws IOException {
        File file = new File("username.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            user = sc.nextLine();
           // System.out.println(s);
            // usernameLabel.setText(s);
        }

    }

    String receiveMood() throws FileNotFoundException, IOException {
        String mood = "";
        File file = new File("mood.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            mood = sc.nextLine();
            System.out.println(mood);

        }
        return mood;
    }

    //NEW CODE

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        System.exit(0);
    }
    /*
     private void activitybuttonOnAction(ActionEvent event) throws IOException {
     System.out.println(receiveMood());
     AnchorPane pane =  FXMLLoader.load(getClass().getResource("activity.fxml"));
     activityPane.getChildren().setAll(pane);
     }
    
     */

    //NEW CODE
    //__________________________________________ N E W C O D E_______________________________________________________________

    String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        System.out.println(dateFormat.format(d));

        return dateFormat.format(d);

    }

    @FXML
    private void nextButton(ActionEvent event) throws IOException, SQLException {
        System.out.println(receiveMood());
        String time = getDate();
        if (activity.endsWith(",")) {
            activity = activity.substring(0, activity.length() - 1);
        }
        moodActivity newMood = new moodActivity(time, receiveMood(), "", "", activity, work, family, friends, date, reading, workout, music, goodMeal);
        System.out.println(newMood);
        DatabaseConnection db = new DatabaseConnection();
        username();
        db.saveMoodEntry(newMood, user);

        AnchorPane pane = FXMLLoader.load(getClass().getResource("activity.fxml"));
        activityPane.getChildren().setAll(pane);
    }

    @FXML
    private void dateButton(ActionEvent event) {
        date = 1;
        activity = activity + "date,";
        dateButton.setStyle("-fx-background-color:  #EC5569;");
    }

    @FXML
    private void friendsButton(ActionEvent event) {
        friends = 1;
        activity = activity + "friends,";
        friendsButton.setStyle("-fx-background-color:  #E9122F;");
    }

    @FXML
    private void familyButton(ActionEvent event) {
        family = 1;
        activity = activity + "family,";
        familyButton.setStyle("-fx-background-color:   #1E7889;");
    }

    @FXML
    private void workButton(ActionEvent event) {
        work = 1;
        activity = activity + "work,";
        workButton.setStyle("-fx-background-color:  #EB9605;");
    }

    @FXML
    private void goodMealButton(ActionEvent event) {
        goodMeal = 1;
        activity = activity + "good meal,";
        goodMealButton.setStyle("-fx-background-color:   #EB9605;");
    }

    @FXML
    private void musicButton(ActionEvent event) {
        music = 1;
        activity = activity + "music,";
        musicButton.setStyle("-fx-background-color:   #FB636F;");
    }

    @FXML
    private void workoutButton(ActionEvent event) {
        workout = 1;
        activity = activity + "workout,";
        workoutButton.setStyle("-fx-background-color:   #E9122F;");
    }

    @FXML
    private void readingButton(ActionEvent event) {
        reading = 1;
        activity = activity + "reading,";
        readingButton.setStyle("-fx-background-color:   #FF4F19;");
    }
    //NEW CODES

    //__________________________________________ N E W C O D E_______________________________________________________________
}
