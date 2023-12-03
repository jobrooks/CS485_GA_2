package edu.loyola.cs485.controller;

import edu.loyola.cs485.model.dao.RouteDAO;
import edu.loyola.cs485.model.entity.Route;

import java.sql.Time;
import java.util.List;
public class RouteService {

    public void createNewRoute(Time T_T, String sStation, String eStation, int dTraveled)
        throws Exception{
        Route r = new Route();
        r.setTime_Traveled(T_T);
        r.setStarting_Station(sStation);
        r.setEnding_Station(eStation);
        r.setDistance_Traveled(dTraveled);

        RouteDAO dao = new RouteDAO();
        dao.create(r);
    }

    public List<Route> getRoutes() throws Exception{
        RouteDAO dao = new RouteDAO();
        return dao.list();
    }

    public void update(Route r, Time T_T, String sStation, String eStation, int dTraveled)
    throws Exception{
        if (r!=null) {
            RouteDAO dao = new RouteDAO();
            dao.update(r, T_T, sStation, eStation, dTraveled);
        }
    }

    public void delete(Route r) throws Exception {
        if(r!=null) {
            RouteDAO dao = new RouteDAO();
            dao.delete(r);
        }
    }
}
