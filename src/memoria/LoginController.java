/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import utils.ConnectionUtil;
/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
        private Label LoginLabel;
    

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public LoginController() throws SQLException
      {
        //  con = ConnectionUtil.conDB();
          
              
      }
}
