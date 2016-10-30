package db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection implements Serializable {

	/**
	 * @author Matias Jimenez
	 * Implementa Singleton
	 */
	private static final long serialVersionUID = -2292999609271615808L;
	private static Connection conn = null;
	private static DBConnection instance;
	private Statement statement = null;
	private String ruta = "WarDraft.db";
	
	public DBConnection() throws SQLException {
		try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+ruta);
            System.out.println("La conexion a la base de datos ha sido exitosa.");
        }catch(Exception e){
        	System.out.println("No se encuentra la base");
        }
    }
	
	public Connection getConnection() throws SQLException {
		return conn;
	}
	
	public static DBConnection getInstance() throws SQLException
    {
        if(instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
	
	public void Close() throws SQLException {
		conn.close();
	}
	
	/*
	public static void main(String[] args) throws SQLException {
		DBConnection db = DBConnection.getInstance();
	}
	*/
	
	public ResultSet query(String query) throws SQLException{
        statement = conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
	
	public int insert(String insertQuery) throws SQLException {
        statement = conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
}
