package parshing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ParshingServ 
{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void setTech(ArrayList<TechCpuVO> vo) 
	{
		int result = 0;
		try 
		{
			
			con = ConnectionManager.getConnection();
			for(int i =0; i<vo.size();i++) 
			{
				
				String sql = "insert into tpj_techcpu values(techcpu_seq.nextval,?,?,?,?,?,?,?,?,?,0)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.get(i).getCpuname());
				pstmt.setString(2, vo.get(i).getCpucode());
				pstmt.setString(3, vo.get(i).getCores());
				pstmt.setString(4, vo.get(i).getClock());
				pstmt.setString(5, vo.get(i).getSocket());
				pstmt.setString(6, vo.get(i).getProcess());
				pstmt.setString(7, vo.get(i).getL3cache());
				pstmt.setString(8, vo.get(i).getTdp());
				pstmt.setString(9, vo.get(i).getReleased());
				
				result = result + pstmt.executeUpdate();
				
			}
			
			System.out.println(result);
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			try 
			{
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void setPM(ArrayList<PMCpuVO> vo) 
	{
		int result = 0;
		int num = 0;
		try 
		{
			con = ConnectionManager.getConnection();
			for(int i =0; i<vo.size();i++) 
			{
				System.out.println(i);
				num=i;
				String sql = "insert into tpj_pmcpu values(pmcpu_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.get(i).getCpuname());
				pstmt.setString(2, vo.get(i).getPrice());
				pstmt.setString(3, vo.get(i).getCpuMark());
				pstmt.setString(4, vo.get(i).getCpuval());
				pstmt.setString(5, vo.get(i).getThreadMark());
				pstmt.setString(6, vo.get(i).getThreadVal());
				pstmt.setString(7, vo.get(i).getTdp());
				pstmt.setString(8, vo.get(i).getPowerf());
				pstmt.setString(9, vo.get(i).getDate());
				pstmt.setString(10, vo.get(i).getSocket());
				pstmt.setString(11, vo.get(i).getCategory());
				pstmt.setString(12, vo.get(i).getRank());
				result = result + pstmt.executeUpdate();
				
			}
			
			System.out.println(result);
			
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println(num);
		} finally 
		{
			try 
			{
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public ArrayList<TechCpuVO> gettechlist() 
	{
		ArrayList<TechCpuVO> cpulist = new ArrayList<TechCpuVO>();
		try 
		{
			con = ConnectionManager.getConnection();
			String sql = "select * from tpj_techcpu";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			while(rs.next()) 
			{
				int cpunum = rs.getInt(1);
				String cpuname = rs.getString(2); 
				String cpucode = rs.getString(3);
				String cores = rs.getString(4);
				String clock = rs.getString(5);
				String socket = rs.getString(6);
				String process = rs.getString(7);
				String l3cache = rs.getString(8);
				String tdp = rs.getString(9);
				String released = rs.getString(10);
				int point = rs.getInt(11);
				
					
				TechCpuVO temp = new TechCpuVO(cpunum, cpuname, cpucode, cores, clock, socket, process, l3cache, tdp, released, point);
				
				cpulist.add(temp);
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			try 
			{
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cpulist;
		
	}
	
	
	public ArrayList<PMCpuVO> getpmlist() 
	{
		ArrayList<PMCpuVO> cpulist = new ArrayList<PMCpuVO>();
		try 
		{
			con = ConnectionManager.getConnection();
			String sql = "select cpuname,cpumark from tpj_pmcpu";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			while(rs.next()) 
			{
				String cpuname = rs.getString(1); 
				String cpuMark = rs.getString(2);
				PMCpuVO tempvo = new PMCpuVO();
				tempvo.setCpuname(cpuname);
				tempvo.setCpuMark(cpuMark);
				cpulist.add(tempvo);	
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			try 
			{
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cpulist;
		
	}
	
}
