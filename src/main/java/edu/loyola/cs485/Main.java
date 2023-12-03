package edu.loyola.cs485;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String ConUrl = "jdbc:mysql://localhost"; //protocol + url
        String Port = "3306"; //default MySQL port
        String Database = "train_db"; // database/schema name
        String Username = "root"; //read this from a local file
        String Password = "Demiurge321??"; //Also read this from a file

        try {
            String url = ConUrl+":"+Port+"/"+Database+
                    "?user="+Username+"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            //int rows = st.executeUpdate("INSERT INTO station(name_station, address_station, capacity) VALUES ('Test', 'test station', 3)");
            con.close();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
