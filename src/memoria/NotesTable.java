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
public class NotesTable {

    String notes;

    public NotesTable(String notes) {
        this.notes = notes;
    }

    public static void setList(ObservableList<NotesTable> list) {
        NotesTable.list = list;
    }

    public static ObservableList<NotesTable> getList() {
        return list;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    //*****************************************NEW CODES*************************************************
    static ObservableList<NotesTable> list = FXCollections.observableArrayList();
}
