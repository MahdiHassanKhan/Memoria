/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class AfterLoginsecondpageController implements Initializable {
    @FXML
    private AnchorPane AfterLoginSecondPagepane;
    @FXML
    private Button radLbutton;
    @FXML
    private Button awefulLbutton;
    @FXML
    private Button badLbutton;
    @FXML
    private Button mehLbutton;
    @FXML
    private Button goodLbutton;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  dateTextField.setText("hi");
    }    

    @FXML
    private void moodOnActionButton(ActionEvent event) {
    }

    private void dateFunction(ActionEvent event) {
       // String s;
      //  s = getDate();
       // System.out.println(s);
    //    dateTextField.setText("hi");
    }
    
/* String getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        System.out.println(dateFormat.format(d));
      //  dateText.setText(dateFormat.format(d));
        
        return dateFormat.format(d);
        
        
    }*/

   

    
    
    
}
