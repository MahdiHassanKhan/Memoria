/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.awt.Checkbox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

/**
 *
 * @author NafishA
 */
public class GoalsTable {

    String Goals;
    String Date;
    String statement;

    public GoalsTable(String Goals, String Date, String Statement) {
        this.Goals = Goals;
        this.Date = Date;
        this.statement = Statement;
    }

    public String getGoals() {
        return Goals;
    }

    public void setGoals(String Goals) {
        this.Goals = Goals;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    static ObservableList<GoalsTable> list = FXCollections.observableArrayList();

}
