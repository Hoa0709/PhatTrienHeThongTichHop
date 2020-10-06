package Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class viewSourse {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Network Address : ");
		String a = sc.nextLine();
		URL u;
		String thisLine;
		{
			try{
				u = new URL(a);
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
					while((thisLine = br.readLine())!= null)
						System.out.println(thisLine);
				}
				catch(IOException e)
				{
					System.err.println(e);
				}
			}
			catch(MalformedURLException e){
				System.err.println(e);
			}
		}
	}
}
