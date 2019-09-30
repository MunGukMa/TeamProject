package team.project.one.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AutoDAO {

	@Autowired
	SqlSession session;
	
	
	public ArrayList<String> getlist(String keyvalue) 
	{
		AutoMapper mapper = session.getMapper(AutoMapper.class);
		HashMap<String, String> templist = new HashMap<>();
		String[] temp = keyvalue.split(" ");
		for(int i =0; i<temp.length;i++)
		{
			templist.put("keyvalue", keyvalue);
		}
		return mapper.getlist(templist);
	}

}
