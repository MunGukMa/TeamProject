//ConnectionManager 클래스 - DB관련

package parshing;

import java.sql.*;

/**
 * DB와의 연결을 위한 클래스
 * 드라이버 로딩, Connection 생성하여 리턴
 */
public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String db = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String dbid = "hr";
	private static final String dbpw = "hr";
	
	//생성자. 객체 생성 금지.
	private ConnectionManager() {}
	
	//초기화 블럭. 클래스 로딩시 드라이버도 로딩
	static {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//Connection 객체를 리턴하는 메소드
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

