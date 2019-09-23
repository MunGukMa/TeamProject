package parshing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ProgressMonitorInputStream;

public class TestMain {

	public static void main(String[] args) 
	{
		  try {
		        String filePath = "./foo.txt";
		        // Use "dxdiag /t" variant to redirect output to a given file
		        ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dxdiag","/t",filePath);
		        System.out.println("-- Executing dxdiag command --");
		        Process p = pb.start();
		        p.waitFor();
		        BufferedReader br = new BufferedReader(new FileReader(filePath));
		        String line;
		        System.out.println(String.format("-- Printing %1$1s info --",filePath));
		        while((line = br.readLine()) != null){
		        	
				  if(line.trim().startsWith("Card name:") ||line.trim().startsWith("Current Mode:"))
				  {
					  System.out.println(line.trim());
				  }
				 		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }	// TODO Auto-generated method stub
		  
		  try {
				String line;
				InputStream is;
				is = Runtime.getRuntime().exec("wmic baseboard get product, manufacturer").getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "MS949"));
				System.out.println(br.readLine());
				
				while((line = br.readLine()) != null) {
					if(!line.startsWith(" "))
					System.out.println("Mainboard :["+line+"]");
				}
				br.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
