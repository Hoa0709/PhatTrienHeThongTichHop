package Client_Server_Communication;

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
		Socket client = new Socket("192.168.56.104", 9540);
		System.out.println("Client da duoc tao");
		inFromServer = new Scanner(client.getInputStream());
		PrintStream outToServer = new PrintStream(client.getOutputStream());
		System.out.println("server: " + inFromServer.nextLine());
		while(true) {
			System.out.print(">>>");
			scan = new Scanner(System.in);
			String text = scan.nextLine();
			outToServer.println(text);
			String txt = inFromServer.nextLine();
			System.out.println("server: " + txt);
			if(text.equals("exit")) {
				break;
			}
			if(txt.equals("exit")) {
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
