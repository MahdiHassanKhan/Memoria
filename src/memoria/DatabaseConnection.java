/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Zunayed
 */
public class DatabaseConnection {

    //First we need to get connection;
    //We make a connection function that will connect
    Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/memoria", "root", "");
        System.out.println("Connected to Database");
        return conn;
    }

    //________________________________________________________SIGN UP FUNCTION____________________________________//
    //inserts users information to database
    void insertUserSignUp(User user) throws SQLException {

        Connection conn = getConnection(); //Connection established
        Statement statement = conn.createStatement(); //creating a statement to execute by the connection

        //INSERT Query
        String query = "insert into userinfo values('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "')";
        System.out.println(query);

        if (statement.executeUpdate(query) > 0) {
            System.out.println("Sign Up Completed");
        } else {
            System.out.println("Sign Up Failed");
        }
    }
    //NEW

    //__________________________________________ N E W C O D E_______________________________________________________________
    void saveMoodEntry(moodActivity mood, String username) throws SQLException {
        Connection conn = getConnection(); //Connection established
        Statement statement = conn.createStatement(); //creating a statement to execute by the connection

        //INSERT Query
        // String query1 = "insert into "+username+"values('"+mood.getDate()+"','"+mood.getMood()+"','"+mood.getNotes()+"','";
        String query = "INSERT INTO " + username + " values('" + mood.getDate() + "', '" + mood.getMood() + "', '" + mood.getNotes() + "','" + mood.getGoals() + "','" + mood.getActivity() + "','" + mood.getWorkActivity() + "', '" + mood.getFamilyActivity() + "', '" + mood.getFriendsActivity() + "', '" + mood.getDateActivity() + "', '" + mood.getReadingActivity() + "', '" + mood.getWorkoutActivity() + "', '" + mood.getMusicActivity() + "', '" + mood.getGoodmealActivity() + "')";

//String query = "insert into userinfo values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"')";
        System.out.println(query);

        if (statement.executeUpdate(query) > 0) {
            System.out.println("Mood Entry Completed");
        } else {
            System.out.println("Mood Entry Failed");
        }
    }

    void createUserDatabase(User user) throws SQLException {
        Connection conn = getConnection(); //Connection established
        Statement statement = conn.createStatement(); //creating a statement to execute by the connection ;
        String query = "create table " + user.getUsername() + "(date varchar(100), mood varchar (100), notes varchar(400),goals varchar(400),activity varchar(400), workActivity int(20),familyActivity int(20),friendsActivity int(20),dateActivity int(20),readingActivity int(20),workoutActivity int(20),musicActivity int(20),goodmealActivity int(20))";
        System.out.println(query);
        if (statement.executeUpdate(query) > 0) {
            System.out.println("User Database Failed to Create");
        } else {

            System.out.println("User Database Created");
        }
    }

    //__________________________________________ N E W C O D E_______________________________________________________________
    ObservableList<TableInfo> getMoodEntry(String username) throws SQLException {
        ObservableList<TableInfo> moodList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "select date,mood,activity from " + username;

        ResultSet rs = statement.executeQuery(query);
        int i = 0;
        int count = 0;
        /* while(rs.next())
         {
         count++;
         }
         //rs = statement.executeQuery(query);
         //System.out.println(count);
         //Stud[] stdList = new Stud[count];
         */

        while (rs.next()) {
            String date = rs.getString("date");
            String mood = rs.getString("mood");
            String activity = rs.getString("activity");
            if (mood != null && !mood.isEmpty()) {
                TableInfo user = new TableInfo(date, mood, activity);
                moodList.add(user);
            }
            //i++;
        }
        return moodList;
    }

    void setNotes(moodActivity mood, String username) throws SQLException {
        Connection conn = getConnection(); //Connection established
        Statement statement = conn.createStatement(); //creating a statement to execute by the connection

        //INSERT Query
        // String query1 = "insert into "+username+"values('"+mood.getDate()+"','"+mood.getMood()+"','"+mood.getNotes()+"','";
        String query = "INSERT INTO " + username + " values('" + mood.getDate() + "', '" + mood.getMood() + "', '" + mood.getNotes() + "','" + mood.getGoals() + "','" + mood.getActivity() + "','" + mood.getWorkActivity() + "', '" + mood.getFamilyActivity() + "', '" + mood.getFriendsActivity() + "', '" + mood.getDateActivity() + "', '" + mood.getReadingActivity() + "', '" + mood.getWorkoutActivity() + "', '" + mood.getMusicActivity() + "', '" + mood.getGoodmealActivity() + "')";

//String query = "insert into userinfo values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"')";
        System.out.println(query);

        if (statement.executeUpdate(query) > 0) {
            System.out.println("Note Entry Completed");
        } else {
            System.out.println("Note Entry Failed");
        }
    }

    ObservableList<NotesTable> getNotes(String username) throws SQLException {
        ObservableList<NotesTable> List = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "select notes,goals from " + username;

        ResultSet rs = statement.executeQuery(query);
        int i = 0;
        int count = 0;

        while (rs.next()) {
            String str = rs.getString("notes");
            String goals = rs.getString("goals");
            if ((str != null && !str.isEmpty()) && !(goals != null && !goals.isEmpty())) {
                NotesTable nt = new NotesTable(str);
                List.add(nt);
                //i++;
            }
        }
        return List;
    }

    void setGoals(moodActivity mood, String username) throws SQLException {
        Connection conn = getConnection(); //Connection established
        Statement statement = conn.createStatement(); //creating a statement to execute by the connection

        //INSERT Query
        // String query1 = "insert into "+username+"values('"+mood.getDate()+"','"+mood.getMood()+"','"+mood.getNotes()+"','";
        String query = "INSERT INTO " + username + " values('" + mood.getDate() + "', '" + mood.getMood() + "', '" + mood.getNotes() + "','" + mood.getGoals() + "','" + mood.getActivity() + "','" + mood.getWorkActivity() + "', '" + mood.getFamilyActivity() + "', '" + mood.getFriendsActivity() + "', '" + mood.getDateActivity() + "', '" + mood.getReadingActivity() + "', '" + mood.getWorkoutActivity() + "', '" + mood.getMusicActivity() + "', '" + mood.getGoodmealActivity() + "')";

//String query = "insert into userinfo values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"')";
        System.out.println(query);

        if (statement.executeUpdate(query) > 0) {
            System.out.println("Goal Entry Completed");
        } else {
            System.out.println("Goal Entry Failed");
        }
    }

    ObservableList<GoalsTable> getGoals(String username) throws SQLException {
        ObservableList<GoalsTable> List = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "select goals,date,notes from " + username;

        ResultSet rs = statement.executeQuery(query);
        int i = 0;
        int count = 0;

        while (rs.next()) {
            String goalName = rs.getString("goals");
            String dueDate = rs.getString("Date");
            String noteGoal = rs.getString("notes");
            if (goalName != null && !goalName.isEmpty()) {
                GoalsTable nt = new GoalsTable(goalName, dueDate, noteGoal);
                List.add(nt);
                //i++;
            }
        }
        return List;
    }

    double[] getAverage(String username) throws SQLException {
        double[] month = new double[12];

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "select date,mood,notes,goals from " + username;
        ResultSet rs = statement.executeQuery(query);
        double jan_mood = 0.0, feb_mood = 0.0, mar_mood = 0.0, apr_mood = 0.0, may_mood = 0.0, jun_mood = 0.0, jul_mood = 0, aug_mood = 0, sep_mood = 0, oct_mood = 0, nov_mood = 0, dec_mood = 0;
        double jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;
        double value = 0.0;
        while (rs.next()) {
            String date = rs.getString("date");
            String mood = rs.getString("mood");
            String notes = rs.getString("notes");
            String goals = rs.getString("goals");
            if ((mood != null && !mood.isEmpty()) && !(notes != null && !notes.isEmpty()) && !(goals != null && !goals.isEmpty())) {
                String dateCheck = "";
                dateCheck = dateCheck + date.charAt(3) + date.charAt(4);
                System.out.println("Month is");
                System.out.println(dateCheck);
                if ("Rad".equals(mood)) {
                    value = 5.0;
                } else if ("Good".equals(mood)) {
                    value = 4.0;
                } else if ("Meh".equals(mood)) {
                    value = 3.0;
                } else if ("Bad".equals(mood)) {
                    value = 2.0;
                } else if ("Awful".equals(mood)) {
                    value = 1.0;
                } else {
                    value = 0.0;
                }

                if ("01".equals(dateCheck)) {
                    if (jan_mood != 0) {
                        jan = value;
                        jan_mood = (jan_mood + jan) / 2.00;
                        System.out.println("January");
                    } else {
                        jan_mood = value;
                    }
                } else if ("02".equals(dateCheck)) {
                    if (feb_mood != 0) {
                        feb = value;
                        feb_mood = (feb_mood + feb) / 2.00;
                        System.out.println("February");
                    } else {
                        feb_mood = value;
                    }
                } else if ("03".equals(dateCheck)) {
                    if (mar_mood != 0) {
                        mar = value;
                        mar_mood = (mar_mood + mar) / 2.00;
                        System.out.println("March");
                    } else {
                        mar_mood = value;
                    }
                } else if ("04".equals(dateCheck)) {
                    if (apr_mood != 0) {
                        apr = value;
                        apr_mood = (apr_mood + apr) / 2.00;
                        System.out.println("April");
                    } else {
                        apr_mood = value;

                    }
                } else if ("05".equals(dateCheck)) {
                    if (may_mood != 0) {
                        may = value;
                        may_mood = (may_mood + may) / 2.00;
                        System.out.println("May");
                    } else {
                        mar_mood = value;
                    }
                } else if ("06".equals(dateCheck)) {
                    if (jun_mood != 0) {
                        jun = value;
                        jun_mood = (jun_mood + jun) / 2.00;
                        System.out.println("June");
                    } else {
                        jun_mood = value;
                    }
                } else if ("07".equals(dateCheck)) {
                    if (jul_mood != 0) {
                        jul = value;
                        jul_mood = (jul_mood + jul) / 2.00;
                        System.out.println("July");
                    } else {
                        jul_mood = value;
                    }
                } else if ("08".equals(dateCheck)) {
                    if (sep_mood != 0) {
                        aug = value;
                        aug_mood = (aug_mood + aug) / 2.00;
                        System.out.println("August");
                    } else {
                        aug_mood = value;
                    }
                } else if ("09".equals(dateCheck)) {
                    if (sep_mood != 0) {
                        sep = value;
                        sep_mood = (sep_mood + sep) / 2.00;
                        System.out.println("September");
                    } else {
                        sep_mood = value;
                    }
                } else if ("10".equals(dateCheck)) {
                    if (oct_mood != 0) {
                        oct = value;
                        oct_mood = (oct_mood + oct) / 2.00;
                    //System.out.println(oct);
                        // System.out.println(value);
                        // System.out.println(oct_mood);
                        //System.out.println("October");
                    } else {
                        oct_mood = value;
                        System.out.println(oct_mood);
                    }
                } else if ("11".equals(dateCheck)) {
                    if (nov_mood != 0) {
                        nov = value;
                        nov_mood = (nov_mood + nov) / 2.00;
                        System.out.println("November");
                    } else {
                        nov_mood = value;
                    }
                } else if ("12".equals(dateCheck)) {
                    if (dec_mood != 0) {
                        dec = value;
                        dec = (dec + dec) / 2.00;
                        System.out.println("December");
                    } else {
                        dec_mood = value;
                    }
                } else {
                    System.out.println("Error");
                }
                //i++;
            }

        }

        month[0] = jan_mood;
        month[1] = feb_mood;
        month[2] = mar_mood;
        month[3] = apr_mood;
        month[4] = may_mood;
        month[5] = jun_mood;
        month[6] = jul_mood;
        month[7] = aug_mood;
        month[8] = sep_mood;
        month[9] = oct_mood;
        month[10] = nov_mood;
        month[11] = dec_mood;

        return month;
    }
    
    void deleteNotes(String username,ObservableList<NotesTable> selectedNotes) throws SQLException
    {
        
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for(NotesTable note:selectedNotes)
        {
        String query = "delete from "+username+" where notes = '"+note.getNotes()+"'";
        statement.execute(query);
        }
    }
    
    void deleteGoals(String username,ObservableList<GoalsTable> selectedNotes) throws SQLException
    {
        
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for(GoalsTable goal:selectedNotes)
        {
        String query = "delete from "+username+" where goals = '"+goal.getGoals()+"'";
        statement.execute(query);
        }
    }
}
