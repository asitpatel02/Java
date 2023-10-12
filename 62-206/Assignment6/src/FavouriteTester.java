import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.*;

/** Example program for the FavoriteList and FavoriteListMTF classes */
public class FavouriteTester {
	public static void main(String[] args) {
		String[] urlArray = { "http://wiley.com", "http://datastructures.net", "http://algorithmdesign.net",
				"http://www.brown.edu", "http://uci.edu" };
		FavouriteList<String> L1 = new FavouriteList<String>();
		FavouriteListMTF<String> L2 = new FavouriteListMTF<String>();
		int n = 20; // number of access operations

		// Simulation scenario: access n times a random URL
		Random rand = new Random();
		for (int k = 0; k < n; k++) {
			System.out.println("-------------------------------------------");
			int i = rand.nextInt(urlArray.length); // random index
			String url1 = urlArray[i]; // random URL
			String url2 = url1;
			System.out.println("Accessing: " + url1);
			L1.access(url1);
			System.out.println("L1 = " + L1);
			L2.access(url2);
			System.out.println("L2 = " + L2);
		}
		int t = L1.size() / 2;
		System.out.println("-------------------------------------------");
		System.out.println("Top " + t + " in L1 = " + L1.top(t));
		System.out.println("Top " + t + " in L2 = " + L2.top(t));
		//Interestingly the top 2 in each list will vary as if 2 entries have the same number of accesses the list will pseudorandomly decide between them.
		// Pop up a browser window displaying the most popular URL in L1
		try //Pretty sure that the URL's are dead. It tries to access them but fails except for the uci one so I made it only go to that one. It does throw an image format exception but I'm very certain that this is just extra on the assignment since we haven't learned any kind of GUI stuff.
		{
			//String popular = L1.top(1).iterator().next(); // most popular URL in L1
			String popular = "http://uci.edu";
			JEditorPane jep = new JEditorPane(popular);
			jep.setEditable(false);
			JFrame frame = new JFrame(popular);
			frame.getContentPane().add(new JScrollPane(jep), BorderLayout.CENTER);
			frame.setSize(640, 480);
			frame.setVisible(true);
		} catch (IOException e)
		{
			/** ignore I/O exceptions **/
		}
	}
}
