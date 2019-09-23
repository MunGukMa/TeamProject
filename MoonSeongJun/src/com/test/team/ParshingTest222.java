package com.test.team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ParshingTest222 
{
	static URL url=null;
	static URLConnection conn=null;
	
	public static void main(String[] args) 
	{
		try {
			url = new URL("https://cpu.userbenchmark.com/Intel-Core-i5-9400F/Rating/4051");
			conn= url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			char[] buff = new char[512];
			int len = -1;
			
			
			while( (len = br.read(buff)) != -1) {
                System.out.print(new String(buff, 0, len));
            };
			
			br.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
