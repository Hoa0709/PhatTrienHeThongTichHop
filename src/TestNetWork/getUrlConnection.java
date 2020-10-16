package TestNetWork;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class getUrlConnection {
	public static void main(String[] args) {
		 String a = "http://www.google.com";
		 try {
			 URL u = new URL(a);
			 URLConnection uc = u.openConnection( );
		 } catch (MalformedURLException e) {
			 e.printStackTrace();
		 }
		 catch (IOException e) {
		  //TODO Auto-generated catch block
		 e.printStackTrace();
		 }	 
	}
}
