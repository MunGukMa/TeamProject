package com.test.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<SteamVO> getAppid(){
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs;
		ArrayList<SteamVO> list = new ArrayList<>();
		conn = ConnectionManager.getConnection();
		try{
				String sql = "select * from steam_product";
				try{
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						list.add(new SteamVO(rs.getString(2),rs.getString(3)));
					}
				} catch(Exception e) {
					e.printStackTrace();
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
		return list;
	}
}