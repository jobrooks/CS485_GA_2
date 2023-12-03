package edu.loyola.cs485.model.dao;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import edu.loyola.cs485.model.entity.Route;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends AbstractDAO<Route> {
    @Override
    public void create(Route entity) throws SQLException{
        String sql ="INSERT INTO route(time_traveled, starting_station, ending_station, distance_traveled) " +
                "VAlUES(?,?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setTime(1, entity.getTime_Traveled());
        pst.setString(2, entity.getStarting_Station());
        pst.setString(3, entity.getEnding_Station());
        pst.setInt(4, entity.getDistance_Traveled());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    @Override
    public Route read(int id) throws SQLException {
        String sql = "SELECT * FROM route WHERE id_route = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        Route r = null;
        if(rs.next()){
            r = new Route();
            r.setId(rs.getInt("id_route"));
            r.setTime_Traveled(rs.getTime("time_traveled"));
            r.setStarting_Station(rs.getString("starting_station"));
            r.setEnding_Station(rs.getString("ending_station"));
            r.setDistance_Traveled(rs.getInt("distance_traveled"));
        }
        con.close();
        return r;
    }

    @Override
    public void update(Route entity, Time tm_trvld, String str_stn, String end_stn, int dst_trvld)
            throws SQLException
    {
        String sql = "UPDATE route SET time_traveled = ?, starting_station = ?, ending_station = ?, " +
                "distance_traveled = ? WHERE id_route = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setTime(1, tm_trvld);
        pst.setString(2, str_stn);
        pst.setString(3, end_stn);
        pst.setInt(4, dst_trvld);
        pst.setInt(5, entity.getId());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void delete(Route entity) throws SQLException {
        String sql = "DELETE FROM route WHERE id_route = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public List<Route> list() throws SQLException {
        ArrayList<Route> listRoute = new ArrayList<Route>();
        Connection con = getConnection();
        String sql = "SELECT * FROM route ORDER BY distance_traveled";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            Route r = new Route();
            r.setId(rs.getInt("id_route"));
            r.setTime_Traveled(rs.getTime("time_traveled"));
            r.setStarting_Station(rs.getString("starting_station"));
            r.setEnding_Station(rs.getString("ending_station"));
            r.setDistance_Traveled(rs.getInt("distance_traveled"));
            listRoute.add(r);
        }
        con.close();
        return listRoute;
    }
}
