package application;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFile {
	ArrayList<String> trips = new ArrayList<String>();
	private Scanner x;

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

	public boolean validateUsername(String username, String password, String radiobutton) {
		ArrayList<String> people = new ArrayList<String>();
		people = Readfile(radiobutton);
		HashMap<String, String> info = new HashMap<String, String>();

		for (int i = 0; i <= (people.size()/2); i += 2) {
			info.put(people.get(i), people.get(i + 1));

		}System.out.println(username);
		System.out.println(info);
		System.out.println(info.get(username));
		if (info.containsKey(username)) {
			
			String y = info.get(username);

			if (y.equals(password) == true)
				return true;
		} 
			return false;

	}

}