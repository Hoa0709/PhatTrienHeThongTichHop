package BT2_Lab3_RMI.RMI.rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.RMI.rmiinterface.RMIInterface;

public class ClientOperation {

	private static RMIInterface look_up;

	public static void main(String[] args)
		throws MalformedURLException, RemoteException, NotBoundException {

		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
		String txt = JOptionPane.showInputDialog("Book Name?");

		String response = look_up.TextSearch(txt);
		JOptionPane.showMessageDialog(null, response);

	}

}
