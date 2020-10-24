package Client_Server_Number;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server{	
	public static String ReadNum(String x) {
		String rd;
		if(x.matches("[0-9]+")){
			int n = Integer.parseInt(x);
			if(n <= 100) {
				String chuc = "",dv = "";
				int mod = n%10;
				int div = n/10;
				switch(div) {
					case 2:{ dv = "hai"; break; }
					case 3:{ dv = "ba"; break; }
					case 4:{ dv = "bon"; break; }
					case 5:{ dv = "nam"; break; }
					case 6:{ dv = "sau"; break; }
					case 7:{ dv = "bay"; break; }
					case 8:{ dv = "tam"; break; }
					case 9:{ dv = "chin"; break; }
				}
				switch(mod) {
					case 1:{ chuc = "mot"; break; }
					case 2:{ chuc = "hai"; break; }
					case 3:{ chuc = "ba"; break; }
					case 4:{ chuc = "bon"; break; }
					case 5:{ chuc = "lam"; break; }
					case 6:{ chuc = "sau"; break; }
					case 7:{ chuc = "bay"; break; }
					case 8:{ chuc = "tam"; break; }
					case 9:{ chuc = "chin"; break; }		
				}
				if(n < 10) {
					if(n == 0) {rd = "khong";}
					else if(n == 5) {rd = "nam";}
					else {rd = chuc;}
				}
				else {
					if(n == 10) rd = "muoi";
					else if(n == 100) rd = "mot tram";
					else
					rd = dv + " muoi " + chuc;
				}
			}
			else {
				rd = "The data is a number greater than 100. you must enter less than 100";
			}
		}
		else {
			rd = "Data isn't number";
		}
		return rd;
	}
	public static void main(String[] args){
		try {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(9540);
		System.out.println("Server da duoc tao");
		Socket client = server.accept();
		System.out.println("Client da ket noi den server");
		Scanner inFromClient = new Scanner(client.getInputStream());
		PrintStream outToClient = new PrintStream(client.getOutputStream());
		outToClient.println("Nhap so :");
		String txt = inFromClient.nextLine();
		outToClient.println("Result : " + ReadNum(txt));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
}
