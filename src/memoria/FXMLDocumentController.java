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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.ConnectionUtil;

/**
 *
 * @author NafishA
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label label;
    @FXML
    private ImageView mLogo;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnSignin;
    @FXML
    private Label lblError;
    @FXML
    private Button loginToSignUp;

    //__________________________________________ N E W C O D E_______________________________________________________________
    String s = "";
    int x = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        //etay press korle login page e chole jay
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootPane.getChildren().setAll(pane);

        //  rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void loginToAccount(ActionEvent event) throws IOException {
          //etay press korle login page e chole jay
        // AnchorPane pane =  FXMLLoader.load(getClass().getResource("Login.fxml"));
        // rootPane.getChildren().setAll(pane);
        //  rootpane.getChildren().setAll(pane);

        if (event.getSource() == btnSignin) {
              // login here

            if (signIn().equals("Success")) //signIn();
            {
                //ekhane change korbi
                AnchorPane p;
                p = FXMLLoader.load(getClass().getResource("welcome.fxml"));
                rootPane.getChildren().setAll(p);
         // ActivityController a = new ActivityController();
                // a.passUsername(s);

            }
            //System.out.println("Hey");
        }

    }

//SIGN UP BUTTON E CHAP DILE OR "HAVEN'T SIGNED UP YET?" BUTTON E CHAP DILE EI FUNCTION CALL HOY
    @FXML
    private void signup(ActionEvent event) throws IOException {
        //Ei funtion e shobshomoy dhukbe. Condition ekhane dibo; match hoile nicher kaaj hobe
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        rootPane.getChildren().setAll(pane);
        //  rootpane.getChildren().setAll(pane);

    }

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    private String signIn() throws IOException {
          //New Code for FILE

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        System.out.println(username);
        System.out.println(password);
        File file = new File("username.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fWriter = new FileWriter(file);
        fWriter.write(username);
        fWriter.close();
          //query
        // ActivityController a = new ActivityController();
        // a.passUsername(username);
        String sql = "SELECT * FROM userinfo Where username = ? and password = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
//            preparedStatement.setString(3,"pass3");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                lblError.setTextFill(Color.TOMATO);
                lblError.setText("WRONG PASSWORD");
                System.out.println("Wrong Logins");
                return "Error";
            } else {
                lblError.setTextFill(Color.GREEN);
                System.out.println("Successfull");
                lblError.setText("Login SUCCESSFULL");
                System.out.println("Successfull Login");
                s = username;

                return "Success";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Exception";
        }

    }

    public FXMLDocumentController() throws SQLException {
        con = ConnectionUtil.conDB();

    }

}
