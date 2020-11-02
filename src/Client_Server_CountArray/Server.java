package Client_Server_CountArray;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	static String out(File f) throws FileNotFoundException {
		Scanner c = new Scanner(f);
	    int i=0;
	    while(c.hasNext()) {
	    	String x = new String(c.nextLine());
	    	if(x.matches("\\d+")) //[0-9]+
	    	{
	    		i = i + Integer.parseInt(x);
	    	}
	    }
	    c.close();
	    return Integer.toString(i);
	}
	public static void main(String[] args) throws IOException{
		    try {
				ServerSocket server = new ServerSocket(9540);
				System.out.println("Server da duoc tao");
				Socket client = server.accept();
				System.out.println("Client da ket noi den server");
				PrintStream outToClient = new PrintStream(client.getOutputStream());
				outToClient.println("Nhap mang:");
				String obj = ".";
				File f = new File("D:\\PhatTrienHeThongTichHop\\src\\Client_Server_CountArray\\lib.txt");
			    FileWriter fw = new FileWriter(f);
				while(true) {
					Scanner inFromClient = new Scanner(client.getInputStream());
					String text = inFromClient.nextLine();
					System.out.println("client: " + text);
					 fw.write(text+"\n");
					if(text.equals(obj)) {
						fw.close();
						outToClient.println("result = "+out(f));
						System.out.println("exit");						
						server.close();
						break;
					}
				}
				
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
}