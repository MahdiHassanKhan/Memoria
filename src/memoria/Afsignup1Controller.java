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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author NafishA
 */

public class Afsignup1Controller implements Initializable {
    @FXML
    private AnchorPane Aftersignuppane;
    @FXML
    private Button radSbutton;
    @FXML
    private Button awfulSbutton;
    @FXML
    private Button badSbutton;
    @FXML
    private Button mehSbutton;
    @FXML
    private Button goodSbutton;
    @FXML
    private TextField date;
    /**
     * Initializes the controller class.
     */
    //__________________________________________ N E W C O D E_______________________________________________________________
    String s,time;
    void saveMoodFile(String str) throws IOException
    {
        File file = new File("mood.txt");
          if(!file.exists()) file.createNewFile();
          FileWriter fWriter = new FileWriter(file);
          fWriter.write(str);
          fWriter.close();
    }
     void username() throws IOException
    {
    File file = new File("username.txt");
          if(!file.exists()) file.createNewFile();
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
        {
             s = sc.nextLine();
            System.out.println(s);
           // usernameLabel.setText(s);
        }
    
    }
     //__________________________________________ N E W C O D E_______________________________________________________________
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //   String s = getDate();
            // date.setText(s);
            //__________________________________________ N E W C O D E_______________________________________________________________
            username();
        } catch (IOException ex) {
            Logger.getLogger(Afsignup1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    @FXML
    private void hey(ActionEvent event) {
          String s = getDate();
        date.setText(s);
    }
    public void userInfoCollect(String username)
    {
        
      // onno.setText(username);
        System.out.println(username);
    }
    //__________________________________________ N E W C O D E_______________________________________________________________
    @FXML
    private void moodRadOnActionButton(ActionEvent event) throws IOException {               
          System.out.println("Mood is Rad");
          saveMoodFile("Rad");
             
          AnchorPane pane =  FXMLLoader.load(getClass().getResource("afsignup2.fxml"));
          Aftersignuppane.getChildren().setAll(pane);
    }

     @FXML
    private void moodAwfulOnActionButton(ActionEvent event) throws IOException {
         System.out.println("Mood is Awful");
          saveMoodFile("Awful");
          AnchorPane pane =  FXMLLoader.load(getClass().getResource("afsignup2.fxml"));
          Aftersignuppane.getChildren().setAll(pane);
    }
    
     @FXML
    private void moodGoodOnActionButton(ActionEvent event) throws IOException {
         System.out.println("Mood is Good");
          saveMoodFile("Good");
          AnchorPane pane =  FXMLLoader.load(getClass().getResource("afsignup2.fxml"));
          Aftersignuppane.getChildren().setAll(pane);
    }
    
     @FXML
    private void moodBadOnActionButton(ActionEvent event) throws IOException {
         System.out.println("Mood is Bad");
          saveMoodFile("Bad");
          AnchorPane pane =  FXMLLoader.load(getClass().getResource("afsignup2.fxml"));
          Aftersignuppane.getChildren().setAll(pane);
    }
    
     @FXML
    private void moodMehOnActionButton(ActionEvent event) throws IOException {
        System.out.println("Mood is Meh");
          saveMoodFile("Meh");
          AnchorPane pane =  FXMLLoader.load(getClass().getResource("afsignup2.fxml"));
          Aftersignuppane.getChildren().setAll(pane);
    }
    
    String getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        System.out.println(dateFormat.format(d));
        
        return dateFormat.format(d);
    }
    //__________________________________________ N E W C O D E_______________________________________________________________

 
    


   

    
    
    
    
}
