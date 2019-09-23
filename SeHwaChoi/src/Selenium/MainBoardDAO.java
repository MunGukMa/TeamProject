package Selenium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.ConnectionManager;
import parshing.MainBoardVO;

public class MainBoardDAO {

	public void insertMainBoard(ArrayList<MainBoardVO> vo){
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null; 
		conn = ConnectionManager.getConnection();
		try{
			for(int i =0; i<vo.size();i++){
				String sql = "INSERT INTO mainboard_product(num, name, sockets, formFactor, chipSet, RAM, releaseDate, audioChip, usb2, usb3, sata)"
						+ " values(mainboard_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				try{
					pstmt = conn.prepareStatement(sql);
					conn.setAutoCommit(false);
					pstmt.setString(1, vo.get(i).getName());
					pstmt.setString(2, vo.get(i).getSockets());
					pstmt.setString(3, vo.get(i).getFormFactor());
					pstmt.setString(4, vo.get(i).getChipSet());
					pstmt.setString(5, vo.get(i).getRAM());
					pstmt.setString(6, vo.get(i).getReleaseDate());
					pstmt.setString(7, vo.get(i).getAudioChip());
					pstmt.setString(8, vo.get(i).getUsb2());
					pstmt.setString(9, vo.get(i).getUsb3());
					pstmt.setString(10, vo.get(i).getSata());
					row = row+ pstmt.executeUpdate();
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
