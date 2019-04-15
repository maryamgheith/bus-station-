package application;

import java.io.IOException;
import java.util.ArrayList;

public interface GUI {
	public ArrayList<String> Readfile(String filename);
	public boolean validateUsername(String username, String password, String radiobutton);
	public int reservation(String filename);
	public void writeToFile(String filename,String from) throws IOException;
	public void overwriteToFile(String filename,String from) throws IOException;
	//public void Car(String w,String t,String s);
//	public Bus(NoOfString w,String t,String s);
	//public Limo(String w,String t,String s);
	
}
