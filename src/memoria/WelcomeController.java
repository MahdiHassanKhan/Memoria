/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class WelcomeController implements Initializable {
    @FXML
    private AnchorPane welcomePane;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button getStartedButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getStartedAction(ActionEvent event) throws IOException {
        AnchorPane pane =  FXMLLoader.load(getClass().getResource("afsignup1.fxml"));
          welcomePane.getChildren().setAll(pane);

    }
    
}
