package ImgToText;

import java.io.PrintWriter;

public class Testmain {
	
	 
	public static void main(String[] args) 
	{
		String input_file="C:\\test\\sample2.png";
		String output_file="C:\\test\\55";
		String tesseract_install_path="C:\\Tesseract-OCR\\tesseract";
		String[] command ={"cmd",};
		Process p;
		try 
		{
			 p = Runtime.getRuntime().exec(command);
			 new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			 new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			 PrintWriter stdin = new PrintWriter(p.getOutputStream());
			 stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
			 stdin.close();
			 p.waitFor();
			 System.out.println();
			 System.out.println();
			 System.out.println();
			 System.out.println();
			 System.out.println(Readimg.read_a_file(output_file+".txt"));
		} catch (Exception e) 
		{
		 e.printStackTrace();
		}
	}
}


