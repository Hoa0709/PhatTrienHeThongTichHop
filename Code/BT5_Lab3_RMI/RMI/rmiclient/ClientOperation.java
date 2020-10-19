package BT5_Lab3_RMI.RMI.rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import cam.RMI.rmiinterface.RMIInterface;

public class ClientOperation {

	private static RMIInterface look_up;

	public static void main(String[] args)
		throws MalformedURLException, RemoteException, NotBoundException {

		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
		String txt = JOptionPane.showInputDialog("The text you want to send to the server is : ");

		String response = look_up.textstring(txt);
		JOptionPane.showMessageDialog(null, response);

	}

}