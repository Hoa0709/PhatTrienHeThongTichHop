package Lab1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TimDCIP {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Network Address : ");
		String a = sc.nextLine();
		try{
			InetAddress host = InetAddress.getByName(a);
			String hostName = host.getHostName();
			System.out.println("Host name:"+hostName);
			System.out.println("Dia chi IP:"+host.getHostAddress());
		}
		catch(UnknownHostException e)
		{
			System.out.println("Khong tim thay dia chi");
			return;
		}
	}
}
