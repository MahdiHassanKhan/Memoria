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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class SignupController implements Initializable, globalUsername {

    @FXML
    private AnchorPane signupPane;
    @FXML
    private Button submitButton;
    @FXML
    private Label LastNameLabel;
    @FXML
    private Label SignUpLabel;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField mailID;
    @FXML
    private TextField accountName;

    @FXML
    private PasswordField confirmpassword;
    @FXML
    private PasswordField passwordfield;
    @FXML
    private Label emptylabel;
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     *
     * @param event
     * @param url
     * @param rb
     * @throws java.io.IOException
     */
    /**
     * Initializes the controller class.
     *
     * @param event
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    // String temp="";

    @FXML
    private void submitAction(ActionEvent event) throws IOException, SQLException {
        AnchorPane p;

        String username = accountName.getText();
        String password = passwordfield.getText();
        String repassword = confirmpassword.getText();
        String firstName = fName.getText();
        String lastName = lName.getText();
        String email = mailID.getText();
        // userGlobal = ""+username;
        if (username.equals("") || password.equals("") || repassword.equals("") || firstName.equals("") || lastName.equals("") || email.equals("")) {
            System.out.println("Empty");
             emptylabel.setText("PLEASE FILL UP ALLL THE FIELDS!");
            return;// Returns if any field is empty
        }
        if (!(password.equals(repassword))) {
            System.out.println("Not matching");
            emptylabel.setText("Passwords not matching");
            return; // Returns if password and retypes password doesnt match
        }
        System.out.println("Clicking");
        User user = new User(username, password, email, firstName, lastName); //Created a new User

        //Database Actions
        DatabaseConnection db = new DatabaseConnection();

        db.insertUserSignUp(user);

         //Create users own database
         /*
         db.createUserDatabase(User user);
         
         
         */
        db.createUserDatabase(user);

        //Stage primaryStage = new Stage();
        //FXMLLoader loader = new FXMLLoader();
         //Pane root = (Pane) loader.load(getClass().getResource("Afsignup1Controller.fxml").openStream()); 
        // Afsignup1Controller any = (Afsignup1Controller)loader.getController();
        //any.userInfoCollect(accountName.getText());
        //   Scene scene = new Scene(root);      
        //  stage.setScene(scene);
        // stage.show();
        /*FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("afsignup1.fxml"));
         p= (AnchorPane) loader.load();
         Afsignup1Controller t1 = loader.getController();
         t1.userInfoCollect(accountName.getText());
         */
        File file = new File("username.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fWriter = new FileWriter(file);
        fWriter.write(username);
        fWriter.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("afsignup1.fxml"));
        AnchorPane temp = (AnchorPane) loader.load();
        Afsignup1Controller t1 = loader.getController();
        t1.userInfoCollect(accountName.getText());

       //  signupPane =(AnchorPane) loader.load();
        // Afsignup1Controller signup1 =loader.getController();
        //  signup1.userInfoCollect(user.getUsername());
        //clear up codes
        System.out.println("Here");
        accountName.clear();
        passwordfield.clear();
        confirmpassword.clear();
        fName.clear();
        lName.clear();
        mailID.clear();

        //Next Page Code
        p = FXMLLoader.load(getClass().getResource("afsignup1.fxml"));
        signupPane.getChildren().setAll(p);
        System.out.println("hey");
    }

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
         AnchorPane pane =  FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         signupPane.getChildren().setAll(pane);
    }

}
