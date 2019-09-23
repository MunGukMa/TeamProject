package Selenium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.ConnectionManager;
import parshing.PowerVO;

public class PowerDAO {

	public void insertPower(ArrayList<PowerVO> vo){
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null; 
		conn = ConnectionManager.getConnection();
		try{
			for(int i = 0 ; i < vo.size() ; i++){
				String sql = "INSERT INTO power_product(num, name, price, power, output, fanSize, fanNum, atx, sata, connecter, etc, releaseDate)"
						+ " values(power_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				try{
					pstmt = conn.prepareStatement(sql);
					conn.setAutoCommit(false);
					pstmt.setString(1, vo.get(i).getName());
					pstmt.setString(2, vo.get(i).getPrice());
					pstmt.setString(3, vo.get(i).getPower());
					pstmt.setString(4, vo.get(i).getOutput());
					pstmt.setString(5, vo.get(i).getFanSize());
					pstmt.setString(6, vo.get(i).getFanNum());
					pstmt.setString(7, vo.get(i).getAtx());
					pstmt.setString(8, vo.get(i).getSata());
					pstmt.setString(9, vo.get(i).getConnecter());
					pstmt.setString(10, vo.get(i).getEtc());
					pstmt.setString(11, vo.get(i).getReleaseDate());
					row = row + pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		} finally
		{
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
