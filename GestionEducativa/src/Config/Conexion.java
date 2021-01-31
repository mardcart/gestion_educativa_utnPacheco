package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private final String database = "bd_gestioneducativa";
	private final String hostname = "localhost";
	private final String port = "3306";
	private final String horario = "?serverTimezone=UTC";
	private final String url = "jdbc:mysql://"+ hostname +":"+port+"/"+database+horario;
	private final String user = "root";
	private final String password = "root";

	private Connection cnx;
	private Statement statement=null;
	private PreparedStatement pst;
	private ResultSet rst = null;


	public Conexion() {
		
	}

	public Connection conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.cnx = DriverManager.getConnection(this.url,this.user,this.password);
			
		}catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
			e.printStackTrace();
			
		}
		return cnx;
	}
	
	//CONSULT SELECT TRAER UN DATO
	public PreparedStatement ConsultaPST(String consulta) {
		
	
		try {
			this.cnx = this.conectar();
			this.pst = this.cnx.prepareStatement(consulta);			
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
	     	
		return pst;
	}
	
	
	public ResultSet ConsultaRS(String consulta) {
		
		
		try {
			this.cnx =  this.conectar();
			this.statement = this.cnx.createStatement();
			this.rst = this.statement.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
}
