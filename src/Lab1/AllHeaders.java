package Lab1;

import java.net.*;
import java.io.*;

public class AllHeaders {
	 public static void main(String args[]) 
	 {
		 String a = "http://www.google.com";
		 for (int i=0; i < a.length(); i++) 
		 {
			 try {
				 URL u = new URL(a);
				 URLConnection uc = u.openConnection( );
		 
				 for (int j = 1; ; j++) 
				 {
					 String header = uc.getHeaderField(j);
					 if (header == null) break;
					 System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
				 }
			 }
			 catch (MalformedURLException ex) {
				 System.err.println(a + " is not a URL I understand.");
			 }
			 catch (IOException ex) {
				 System.err.println(ex);
			 }
			 System.out.println( );
	 	}
	}	 
}
