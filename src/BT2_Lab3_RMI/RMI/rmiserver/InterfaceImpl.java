package BT2_Lab3_RMI.RMI.rmiserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import com.RMI.rmiinterface.RMIInterface;

public class InterfaceImpl extends UnicastRemoteObject implements RMIInterface{
	
	private static final long serialVersionUID = 1L;

    protected InterfaceImpl() throws RemoteException {
        super();
    }
    public String TextSearch(String name) throws RemoteException{
    	String m = null;
    	try {
			
			File f = new File("D:\\PhatTrienHeThongTichHop\\src\\BT2_Lab3_RMI\\RMI\\rmiserver\\lib.txt");
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
        return "Book name :" + name +m;

    }
}
