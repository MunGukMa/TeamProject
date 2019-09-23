package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String db = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String dbid = "hr";
	private static final String dbpw = "hr";
	
	private ConnectionManager() {}
	
	static {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(db, dbid, dbpw);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

