package core;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
public class DBConnector {
	private String _dbName;
	private String _user;
	private String _password;
	private String _host;
	private Connection  _dbConnection;
	
	public DBConnector( String host, String db_name, String user, String password) {
		super();
		_dbName = db_name;
		_user = user;
		_password = password;
		_host = host;
	}

	public boolean connect(){
		
		//DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName(this._dbName);
		dataSource.setUser(this._user);
		dataSource.setPassword(this._password);
		dataSource.setServerName(this._host);
		try {
			_dbConnection = dataSource.getConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean close(){
		try {
			if(_dbConnection != null && !_dbConnection.isClosed()) 
				_dbConnection.close();
			_dbConnection = null;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/*public void execute() throws SQLException{
		Statement stmt = this._dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ID FROM soccer_model");
		 while (rs.next()) {
		 int coffeeName = rs.getInt("id");
		 System.out.println(coffeeName);
		 }
	}*/
}
