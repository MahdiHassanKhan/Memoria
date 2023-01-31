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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NafishA
 */
public class StatsController implements Initializable {

    @FXML
    private AnchorPane statsrecordpane;
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
    private BarChart<String, Double> BarChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            // mynotestable.scrollTo(100);
            username();
        } catch (IOException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        usernameLabel.setText(s);
        // TODO
        //1.Database theka mood er man ta niye ei jar jar month mood e initialize hbe
        //2.amra ekhn october month e asi, so 31 tarikh prjnto joto mood insert korbo shb gular oct_mood change hbe first e 
        //3.october mash j sesh hoisey ekhn eta app re bujhabi kmne eta dekhar bishoy

        double jan_mood = 0, feb_mood = 0, mar_mood = 0, apr_mood = 0, may_mood = 0, jun_mood = 0, jul_mood = 0, aug_mood = 0, sep_mood = 0, oct_mood = 0, nov_mood = 0, dec_mood = 0;

        //r eta hochhe mainly parameter hishebe pass hbe
        double jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

        //1.suppose database theke jan_mood dilam 4 tyle agey jan_mood e 4 jbey thn prthmbar entry jehetu ty jan=0 thakbe so condition e dhukbena
        //2.else e jabey r jan=jan_mood=4 dekhabey.....abar mood entry dley jan_mood=2 hoiley ager value=4 repace hoia jbey ekhn jaya dekhbe jan er value 4
        //3.so condition e dhukbe r jan=(4+2)/2=3 hbe..ekhn ei jan =3 parameter hishebe graph er value change krbe...emne bar bar mood entry dley
        //4.bar chart change hoite thakbe
        /*if(jan!=0)
         {
         jan=(jan+jan_mood)/2;
         }
         else if(jan==0)
         {
         jan=jan_mood;
         }
        
         if(feb!=0)
         {
         feb=(feb+feb_mood)/2;
         }
         else if(feb==0)
         {
         feb=feb_mood;
         }
        
         if(mar!=0)
         {
         mar=(mar+mar_mood)/2;
         }
         else if(mar==0)
         {
         mar=mar_mood;
         }
        
         if(apr!=0)
         {
         apr=(apr+apr_mood)/2;
         }
         else if(apr==0)
         {
         apr=apr_mood;
         }
        
         if(may!=0)
         {
         may=(may+may_mood)/2;
         }
         else if(may==0)
         {
         may=may_mood;
         }
        
         if(jun!=0)
         {
         jun=(jun+jun_mood)/2;
         }
         else if(jun==0)
         {
         jun=jun_mood;
         }
        
         if(jul!=0)
         {
         jul=(jul+apr_mood)/2;
         }
         else if(jul==0)
         {
         jul=jul_mood;
         }
        
         if(aug!=0)
         {
         aug=(aug+aug_mood)/2;
         }
         else if(aug==0)
         {
         aug=aug_mood;
         }
        
         if(sep!=0)
         {
         sep=(sep+sep_mood)/2;
         }
         else if(sep==0)
         {
         sep=sep_mood;
         }
        
         if(oct!=0)
         {
         oct=(oct+oct_mood)/2;
         }
         else if(oct==0)
         {
         oct=oct_mood;
         }
        
         if(nov!=0)
         {
         nov=(nov+nov_mood)/2;
         }
         else if(nov==0)
         {
         nov=nov_mood;
         }
        
         if(dec!=0)
         {
         dec=(dec+dec_mood)/2;
         }
         else if(dec==0)
         {
         dec=dec_mood;
         }*/
        DatabaseConnection db = new DatabaseConnection();
        double[] month = new double[12];
        try {
            month = db.getAverage(s);
        } catch (SQLException ex) {
            Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        XYChart.Series S = new XYChart.Series();
        S.setName("ALL MONTH");
        jan = month[0];
        feb = month[1];
        mar = month[2];
        apr = month[3];
        may = month[4];
        jun = month[5];
        jul = month[6];
        aug = month[7];
        sep = month[8];
        oct = month[9];
        nov = month[10];
        dec = month[11];

        for (int i = 0; i < 12; i++) {
            System.out.println(month[i]);
        }

        S.getData().add(new XYChart.Data<>("Jan", jan));
        S.getData().add(new XYChart.Data<>("Feb", feb));
        S.getData().add(new XYChart.Data<>("Mar", mar));
        S.getData().add(new XYChart.Data<>("Apr", apr));
        S.getData().add(new XYChart.Data<>("May", may));
        S.getData().add(new XYChart.Data<>("Jun", jun));
        S.getData().add(new XYChart.Data<>("Jul", jul));
        S.getData().add(new XYChart.Data<>("Aug", aug));
        S.getData().add(new XYChart.Data<>("Sep", sep));
        S.getData().add(new XYChart.Data<>("Oct", oct));
        S.getData().add(new XYChart.Data<>("Nov", nov));
        S.getData().add(new XYChart.Data<>("Dec", dec));

        BarChart.getData().addAll(S);
    }

    @FXML
    private void entryButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("entry.fxml"));

        statsrecordpane.getChildren().setAll(pane2);

    }

    @FXML
    private void goalsButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("goals.fxml"));

        statsrecordpane.getChildren().setAll(pane2);
    }

    @FXML
    private void notesButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("notes.fxml"));

        statsrecordpane.getChildren().setAll(pane);
    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        statsrecordpane.getChildren().setAll(pane);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }

}
