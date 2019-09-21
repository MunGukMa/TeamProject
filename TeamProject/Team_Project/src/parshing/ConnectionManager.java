//ConnectionManager Ŭ���� - DB����

package parshing;

import java.sql.*;

/**
 * DB���� ������ ���� Ŭ����
 * ����̹� �ε�, Connection �����Ͽ� ����
 */
public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String db = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String dbid = "hr";
	private static final String dbpw = "hr";
	
	//������. ��ü ���� ����.
	private ConnectionManager() {}
	
	//�ʱ�ȭ ��. Ŭ���� �ε��� ����̹��� �ε�
	static {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//Connection ��ü�� �����ϴ� �޼ҵ�
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

