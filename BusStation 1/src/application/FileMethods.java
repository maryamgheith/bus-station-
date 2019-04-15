package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class FileMethods implements GUI{
	ArrayList<String> trips = new ArrayList<String>();
	private Scanner x;
@Override
	public ArrayList<String> Readfile(String filename) {
		try {
			filename = filename + ".txt";
			x = new Scanner(new File(filename));

			while (x.hasNext()) {
				x.useDelimiter(",");
				String a = x.next();
				trips.add(a);
			}
			x.close();
			return trips;

		} catch (Exception e) {

		}
		return null;

	}
@Override
	public boolean validateUsername(String username, String password, String radiobutton) {
		ArrayList<String> people = new ArrayList<String>();
		people = Readfile(radiobutton);
		HashMap<String, String> info = new HashMap<String, String>();

		for (int i = 0; i < (people.size()-1); i += 2) {
			info.put(people.get(i), people.get(i + 1));

		
		if (info.containsKey(username)) {
			
			String y = info.get(username);

			if (y.equals(password))
				return true;
		}	} 
			return false;

	}@Override
	public int reservation(String filename) {
		 String fusername = filename +".txt";
			File file=new File(fusername);
		 if (file.length()==0) {
				return 0;
			} else
				return 1;
		}@Override
	public void writeToFile(String filename,String from) throws IOException
	{
		filename = filename + ".txt";
		FileWriter fileWriter = new FileWriter(filename,true);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);
		printWriter.print(from+",\n");
		printWriter.close();
	}@Override
	public void overwriteToFile(String filename,String from) throws IOException
	{
		filename = filename + ".txt";
		FileWriter fileWriter = new FileWriter(filename,false);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);
		printWriter.print(from+",");
		printWriter.close();
	}

	
}