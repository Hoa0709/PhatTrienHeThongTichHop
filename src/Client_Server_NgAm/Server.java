package Client_Server_NgAm;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	//Find
	static boolean NguyenAm(String x) {
		if(x.contains("a")||x.contains("e")||x.contains("o")||x.contains("i")||x.contains("u")) {
			return true;
		}return false;
	}
	//Process
	static String Process(String x) {
		if (NguyenAm(x)) {
			int n = -1;
			char[] ch = new char[x.length()];
			x.getChars(0, x.length(), ch, 0);
			char[] y =  {'a','e','o','i','u'} ;
			for (int i = 0 ; i < ch.length; i++) {
				for (int j = 0; j < y.length; j++) {
					if (ch[i]==y[j]) {
						n = i;
						break;
					}
				}if(n!=-1) break;		
			}
			if (n!=0) {
				String str1 = x.substring(n, x.length());
				String str2 = x.substring(0, n);
				return str1+str2+"ay";
			}
			else return x+"way";
		}else return x;
	}
	//read file
	static String out(File f) throws FileNotFoundException {
		String str = "";
		Scanner c = new Scanner(f);
	    while(c.hasNext()) {
	    	String x = new String(c.nextLine());
	    	if(!x.contains("ketthuc")) {
	    		String[] parts = x.split(" ");
		    	for (int i = 0; i < parts.length; i++) {
		    		str = str+Process(parts[i])+" ";
				}
		    	str = str+"\n";
	    	}
	    	
	    }
	    c.close();
	    return str;
	}
	public static void main(String[] args) throws IOException{
		    try {
				ServerSocket server = new ServerSocket(9540);
				System.out.println("Server da duoc tao");
				Socket client = server.accept();
				System.out.println("Client da ket noi den server");
				PrintStream outToClient = new PrintStream(client.getOutputStream());
				outToClient.println("Nhap mang:");
				File f = new File("D:\\PhatTrienHeThongTichHop\\src\\Client_Server_NgAm\\lib.txt");
			    FileWriter fw = new FileWriter(f);
				while(true) {
					Scanner inFromClient = new Scanner(client.getInputStream());
					String text = inFromClient.nextLine();
					System.out.println("client: " + text);
					if(!text.contains("ketthuc")) {
						fw.write(text+"\n");
					}
					else{
						fw.write(text+"\n");
						fw.close();
						outToClient.println("-------------Server result :--------------- \n\n"+out(f));
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