package BT2_Lab3_Socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	public static String TextSearch(String name){
    	String m = null;
    	try {
			
			File f = new File("D:\\PhatTrienHeThongTichHop\\src\\BT2_Lab3_Socket\\lib.txt");
			FileReader fr = new FileReader(f);
			//
			BufferedReader br = new BufferedReader(fr);
			Scanner c = new Scanner(f,"UTF-8");
			while(c.hasNextLine()) {
			String line = c.nextLine();
			if(line.contentEquals(name)) {
				m = " has in library";
			}
			}
			if(m == null) {
				m = " hasn't in library";
			}
			c.close();
			fr.close();
			br.close();	
        }
		catch(IOException ex) {
			ex.printStackTrace();
		}
        System.err.println(name + " is trying to contact!");
        return "Book name :" + name + m;

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
			outToClient.println("Search book ?");
			String ten = inFromClient.nextLine();
			System.out.println("clien: " + ten);
			outToClient.println(TextSearch(ten));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}
}
