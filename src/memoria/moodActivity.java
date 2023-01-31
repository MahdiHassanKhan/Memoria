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
 * @author Zunayed
 */
//__________________________________________ N E W C O D E_______________________________________________________________
public class moodActivity {
   
    private String date;  
    private String mood;
    private String notes;
    private String goals;
    private String activity;
    private int workActivity;
    private int familyActivity;
    private int friendsActivity;
    private int dateActivity;
    private int readingActivity;
    private int workoutActivity;
    private int musicActivity;
    private int goodmealActivity;
//static ObservableList<moodActivity> moodList=FXCollections.observableArrayList();
    public moodActivity(String date, String mood, String notes, String goals, String activity, int workActivity, int familyActivity, int friendsActivity, int dateActivity, int readingActivity, int workoutActivity, int musicActivity, int goodmealActivity) {
        this.date = date;
        this.mood = mood;
        this.notes = notes;
        this.goals = goals;
        this.activity = activity;
        this.workActivity = workActivity;
        this.familyActivity = familyActivity;
        this.friendsActivity = friendsActivity;
        this.dateActivity = dateActivity;
        this.readingActivity = readingActivity;
        this.workoutActivity = workoutActivity;
        this.musicActivity = musicActivity;
        this.goodmealActivity = goodmealActivity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setWorkActivity(int workActivity) {
        this.workActivity = workActivity;
    }

    public void setFamilyActivity(int familyActivity) {
        this.familyActivity = familyActivity;
    }

    public void setFriendsActivity(int friendsActivity) {
        this.friendsActivity = friendsActivity;
    }

    public void setDateActivity(int dateActivity) {
        this.dateActivity = dateActivity;
    }

    public void setReadingActivity(int readingActivity) {
        this.readingActivity = readingActivity;
    }

    public void setWorkoutActivity(int workoutActivity) {
        this.workoutActivity = workoutActivity;
    }

    public void setMusicActivity(int musicActivity) {
        this.musicActivity = musicActivity;
    }

    public void setGoodmealActivity(int goodmealActivity) {
        this.goodmealActivity = goodmealActivity;
    }

    public String getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    public String getNotes() {
        return notes;
    }

    public String getGoals() {
        return goals;
    }

    public int getWorkActivity() {
        return workActivity;
    }

    public int getFamilyActivity() {
        return familyActivity;
    }

    public int getFriendsActivity() {
        return friendsActivity;
    }

    public int getDateActivity() {
        return dateActivity;
    }

    public int getReadingActivity() {
        return readingActivity;
    }

    public int getWorkoutActivity() {
        return workoutActivity;
    }

    public int getMusicActivity() {
        return musicActivity;
    }

    public int getGoodmealActivity() {
        return goodmealActivity;
    }

    
   public moodActivity()
   {
       
   }

    public moodActivity(String date, String mood, String activity) {
        this.date = date;
        this.mood = mood;
        this.activity = activity;
    }
   

    @Override
    public String toString() {
        return "moodActivity{" + "date=" + date + ", mood=" + mood + ", notes=" + notes + ", goals=" + goals + ", activity=" + activity + ", workActivity=" + workActivity + ", familyActivity=" + familyActivity + ", friendsActivity=" + friendsActivity + ", dateActivity=" + dateActivity + ", readingActivity=" + readingActivity + ", workoutActivity=" + workoutActivity + ", musicActivity=" + musicActivity + ", goodmealActivity=" + goodmealActivity + '}';
    }

     
   
}
