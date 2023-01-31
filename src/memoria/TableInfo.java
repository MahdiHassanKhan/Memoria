/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author NafishA
 */
//__________________________________________ N E W C O D E_______________________________________________________________
public class TableInfo {

    String name;
    String mood;
    String activity;

    TableInfo(String name, String mood, String activity) {
        this.name = name;
        this.mood = mood;
        this.activity = activity;
    }
    static ObservableList<TableInfo> moodList = FXCollections.observableArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}
