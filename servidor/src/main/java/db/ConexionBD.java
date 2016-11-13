package db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constantes.Mensaje;

public class ConexionBD implements Serializable {

	/**
	 * @author Matias Jimenez
	 * Implementa Singleton
	 */
	
	private static final long serialVersionUID = -2292999609271615808L;
	private static Connection conn = null;
	private static ConexionBD instance;
	private Statement statement = null;
	private String ruta = "WarDraft.db";
	
	public ConexionBD() throws SQLException {
		try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+ruta);
            System.out.println("La conexion a la base de datos ha sido exitosa.");
        } catch(Exception e){
        	System.out.println("No se encuentra la base");
        }
    }
	
	public Connection getConnection() throws SQLException {
		return conn;
	}
	
	public static ConexionBD getInstance() throws SQLException
    {
        if(instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }
	
	public void Close() throws SQLException {
		conn.close();
	}
	
	public ResultSet query(String query) throws SQLException{
        statement = conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
	
	public int login (String usuario, String password) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT nombre, password, permisos FROM Usuario" + " WHERE nombre LIKE '" + usuario + "' " + "AND password LIKE '" + password + "'");
			if(rs.next())
				return rs.getInt(3);
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return Mensaje.LOGEO_INCORRECTO;
	}
	
	public boolean agregarUsuario (String nombre, String password, String nick, String pregS, String rtaS) throws SQLException {
		statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO Usuario VALUES ('" + nombre + "','" + password + "','" + nick + "','" + pregS + "','" + rtaS + "',0)");
        return true;
	}
	
	/*
	public static void main(String[] args) throws SQLException {
		DBConnection db = DBConnection.getInstance();
	}
	*/
}
