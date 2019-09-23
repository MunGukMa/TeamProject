package Selenium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.ConnectionManager;
import parshing.SteamVO;

public class SteamDAO {

	public void insertSteam(ArrayList<SteamVO> vo){
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null; 
		conn = ConnectionManager.getConnection();
		try{
			for(int i = 0 ; i < vo.size() ; i++){
				String sql = "INSERT INTO steam_product(num, appid, name)"
						+ " values(steam_seq.NEXTVAL, ?, ?)";
				try{
					pstmt = conn.prepareStatement(sql);
					conn.setAutoCommit(false);
					pstmt.setString(1, vo.get(i).getAppid());
					pstmt.setString(2, vo.get(i).getName());
					row = row + pstmt.executeUpdate();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(row);
	}
}
