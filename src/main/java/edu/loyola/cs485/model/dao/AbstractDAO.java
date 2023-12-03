package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.AbstractEntity;
import edu.loyola.cs485.model.entity.Route;

import java.sql.*;
import java.util.List;
public abstract class AbstractDAO<E extends AbstractEntity> {
    protected String ConUrl = "jdbc:mysql://localhost";
    protected String Port = "3306";
    protected String Database = "train_db";
    protected String Username = "root";
    protected String Password = "Demiurge321??";

    public Connection getConnection() throws SQLException{
        String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                +"&password="+Password;
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void setTestDatabase(){
        this.Database = "train_db_test";
    }

    public abstract void create(E entity) throws SQLException;
    public abstract E read(int id) throws SQLException;
    public abstract void update(E entity, Time tm_trvld, String str_dst, String end_dst, int dst_trvld)
            throws SQLException;

    public abstract void delete(E entity) throws SQLException;

    public abstract List<E> list() throws SQLException;
}
