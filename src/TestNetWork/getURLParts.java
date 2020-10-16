package TestNetWork;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class getURLParts {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("URL is : ");
		String a = sc.nextLine();
		try
		{
			URL u = new URL(a);
			System.out.println("URL is "+u);
			System.out.println("The protocol part is "+u.getProtocol());
			System.out.println("The host part is "+u.getHost());
			System.out.println("The file part is "+u.getFile());
			System.out.println("The reference part is "+u.getRef());
		}
		catch(MalformedURLException e)
		{
			System.err.println(e);
		}
	}

}
