package team.project.one.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AutoDAO {

	@Autowired
	SqlSession session;
	
	public ArrayList<String> getlist(String keyvalue, String key) {
		AutoMapper mapper = session.getMapper(AutoMapper.class);
		Map<String, String[]> templist = new HashMap<String,String[]>();
		String[] temp = keyvalue.split("");
		templist.put("keyvalue", temp);
		
		if(key ==null){
			return mapper.getlistall(templist);
		} else if(key.equals("fit_cpu"))
		{
			return mapper.getlistcpu(templist);
		} else if(key.equals("fit_gpu"))
		{
			return mapper.getlistgpu(templist);
		} else if(key.equals("fit_ram"))
		{
			return mapper.getlistram(templist);
		} else if(key.equals("fit_mainboard"))
		{
			return mapper.getlistmainboard(templist);
		} else if(key.equals("fit_case"))
		{
			return mapper.getlistcase(templist);
		} else if(key.equals("fit_power"))
		{
			return mapper.getlistpower(templist);
		} else if(key.equals("fit_steam"))
		{
			return mapper.getliststeam(templist);
		} else 
		{
			return mapper.getlistall(templist);
		}
	}
}
