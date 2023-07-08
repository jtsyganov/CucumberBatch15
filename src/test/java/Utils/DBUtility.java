package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    static Connection conn = null;
    static Statement statement = null;
    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;

    public static ResultSet getResultSet(String sqlQuery) {
        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));

            statement = conn.createStatement();
            rset = statement.executeQuery(sqlQuery);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rset;
    }

    public static ResultSetMetaData getrSetMetaDa(String query) {
        rset = getResultSet(query);
        rSetMetaData = null;
        try {
            rSetMetaData = rset.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rSetMetaData;
    }

    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        rSetMetaData = getrSetMetaDa(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (rset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    //fetching key and value from the columns
                    String key = rSetMetaData.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return listFromRset;
    }
    public static void closeResultSet (ResultSet rset){
        if (rset!=null){
            try {
                rset.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeStatement(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeConnection(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
