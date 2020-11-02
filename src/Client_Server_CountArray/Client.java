package Client_Server_CountArray;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static Scanner inFromServer;
	private static Scanner scan;

	public static void main(String[] args) {
		try {
		@SuppressWarnings("resource")
		Socket client = new Socket("LocalHost", 9540);
		System.out.println("Client da duoc tao");
		inFromServer = new Scanner(client.getInputStream());
		System.out.println("server: " + inFromServer.nextLine());
		while(true) {
				PrintStream outToServer = new PrintStream(client.getOutputStream());
				scan = new Scanner(System.in);
				String text = scan.nextLine();
				outToServer.println(text);
				if(text.equals(".")) {
					System.out.println("server: " + inFromServer.nextLine());
					break;
				}
		}
		
		} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}

}