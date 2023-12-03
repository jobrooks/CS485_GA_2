package edu.loyola.cs485.model.dao;
import edu.loyola.cs485.model.entity.Route;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class RouteDAOTest {
    @Test
    public void testFake(){
        assertAll(
                () -> assertEquals(1,1),
                () -> assertNull(null)

        );
    }

    @Test
    public void testCreateRoute() throws SQLException{
        RouteDAO dao = new RouteDAO();
        dao.setTestDatabase();
        Route r = new Route();
        r.setTime_Traveled(Time.valueOf("02:58:12"));
        r.setStarting_Station("Baltimore Station");
        r.setEnding_Station("Penn Station");
        r.setDistance_Traveled(30);
        dao.create(r);
        Route found = dao.read(r.getId());
        assertAll(
                () ->assertNotNull(r.getId()),
                ()->assertEquals(found.getStarting_Station(), r.getStarting_Station())
        );
        dao.delete(r);
    }

    @Test
    public void testDeleteRoute() throws SQLException{
        RouteDAO dao = new RouteDAO();
        dao.setTestDatabase();
        Route r = new Route();
        r.setTime_Traveled(Time.valueOf("02:58:12"));
        r.setStarting_Station("Baltimore Station");
        r.setEnding_Station("Penn Station");
        r.setDistance_Traveled(30);
        dao.create(r);
        dao.delete(r);
        Route found = dao.read(r.getId());
        assertAll(
                () ->assertNull(found)
        );
        dao.delete(r);
    }

    @Test
    public void testUpdateRoute() throws SQLException{
        RouteDAO dao = new RouteDAO();
        dao.setTestDatabase();
        Route r = new Route();
        r.setTime_Traveled(Time.valueOf("02:58:12"));
        r.setStarting_Station("Baltimore Station");
        r.setEnding_Station("Penn Station");
        r.setDistance_Traveled(30);
        dao.create(r);
        dao.update(r, Time.valueOf("3:30:50"), "Bronx Station", "Ohio Station", 50);
        Route found = dao.read(r.getId());
        assertAll(
                () ->assertEquals(found.getStarting_Station(), "Bronx Station")
        );
        dao.delete(r);
    }

    @Test
    public void testList() throws SQLException{
        RouteDAO dao = new RouteDAO();
        dao.setTestDatabase();
        for (int i=0; i<3; i++) {
            Route r = new Route();
            r.setTime_Traveled(Time.valueOf("00:00:00"));
            r.setStarting_Station("Number " + Integer.toString(i));
            r.setEnding_Station("Number " + Integer.toString(i));
            r.setDistance_Traveled(i);
            dao.create(r);
        }
        List<Route> lst = dao.list();
        assertAll(
                ()->assertEquals(3, lst.size())
        );

        for (Route r : lst){
            dao.delete(r);
        }
    }
}
