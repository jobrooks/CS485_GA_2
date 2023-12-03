package edu.loyola.cs485.model.entity;

import java.sql.Time;

public class Route extends AbstractEntity{
    private Integer Id;
    private java.sql.Time Time_Traveled;
    private String Starting_Station;
    private String Ending_Station;
    private Integer Distance_Traveled;

    public Route(){

    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public Time getTime_Traveled() {
        return Time_Traveled;
    }
    public void setTime_Traveled(Time time_Traveled) {
        Time_Traveled = time_Traveled;
    }
    public String getStarting_Station() {
        return Starting_Station;
    }
    public void setStarting_Station(String starting_Station) {
        Starting_Station = starting_Station;
    }
    public String getEnding_Station() {
        return Ending_Station;
    }
    public void setEnding_Station(String ending_Station) {
        Ending_Station = ending_Station;
    }
    public Integer getDistance_Traveled() {
        return Distance_Traveled;
    }
    public void setDistance_Traveled(Integer distance_Traveled) {
        Distance_Traveled = distance_Traveled;
    }
}
