package BT5_Lab3_Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(9540);
			System.out.println("Server da duoc tao");
			Socket client = server.accept();
			System.out.println("Client da ket noi den server");
			Scanner inFromClient = new Scanner(client.getInputStream());
			PrintStream outToClient = new PrintStream(client.getOutputStream());
			outToClient.println("The String want reverse ?");
			String ten = inFromClient.nextLine();
			System.out.println("clien: " + ten);
			outToClient.println(reverse(ten));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}
}
